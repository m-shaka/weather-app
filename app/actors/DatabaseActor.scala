package actors

import akka.actor.Actor
import models._
import play.api.libs.json.Json
import play.api.db.slick._
import play.api.Play.current
import slick.driver.PostgresDriver.simple._
import org.joda.time.{ LocalDate, DateTimeZone }
import com.github.tototoshi.slick.PostgresJodaSupport._
import play.api.libs.ws._
import scala.concurrent.duration.{ Duration, MILLISECONDS }
import scala.concurrent.{ Future, Await }
import scala.concurrent.ExecutionContext.Implicits.global

class DatabaseActor extends Actor {

  def receive = {
    case "min" => insertMin()
    case "max" => insertMax()
    case "delete" => deleteOldData()
  }

  // 現在の天気情報を取得、毎日定刻にDBに入れる
  val cityID = "130010"
  val weatherInfoUrl = s"http://weather.livedoor.com/forecast/webservice/json/v1?city=${cityID}"

  lazy val source =
    WS.url(weatherInfoUrl)
    .get()

  def insertMin() = {
    source.onSuccess{
      case response => {
        val min = (response.json \ "forecasts" \\ "temperature").map(
          day => (day \ "min" \ "celsius").validate[String].getOrElse(null)
        ).head
        DB.withSession { implicit session =>
          val tempdatum = TableQuery[TempDatum]
          val insertData = TempData(None, "Tokyo", min.toInt, null.asInstanceOf[Int] , new LocalDate(DateTimeZone.forID("Asia/Tokyo")))
          tempdatum.insert(insertData)
          println("inserting now!!!")
        }
      }
    }
  }

  def insertMax() = {
    source.onSuccess{
      case response => {
        val max = (response.json \ "forecasts" \\ "temperature").map(
          day => (day \ "max" \ "celsius").validate[String].getOrElse(null)
        ).head

        DB.withSession { implicit session =>
          val temdatum = TableQuery[TempDatum]
          val date = new LocalDate(DateTimeZone.forID("Asia/Tokyo"))
          val city = "Tokyo"

          temdatum
          .filter(row => row.date === date && row.city === city)
          .map(_.max)
          .update(max.toInt)

        println("updating now!!!")
        }
      }
    }
  }

  def deleteOldData() = {
    DB.withSession { implicit session =>
      val temdatum = TableQuery[TempDatum]
      val date = new LocalDate(DateTimeZone.forID("Asia/Tokyo")).minusWeeks(1)
      temdatum
      .filter(_.date < date)
      .delete
    }
  }
}
