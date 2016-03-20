package actors

import akka.actor.Actor
import models._
import play.api.libs.json.Json
import play.api.db.slick._
import play.api.Play.current
import slick.driver.PostgresDriver.simple._
import org.joda.time.LocalDate
import com.github.tototoshi.slick.PostgresJodaSupport._
import play.api.libs.ws._
import scala.concurrent.duration.{ Duration, MILLISECONDS }
import scala.concurrent.{ Future, Await }
import scala.concurrent.ExecutionContext.Implicits.global

class SampleActor extends Actor {

  def receive = {
    case "min" => insertMin()
    case "max" => insertMax()
    case "delete" => deleteOldData()
  }

  // 現在の天気情報を取得、毎日定刻にDBに入れる
  val openWeatherID = sys.env("OPEN_WEATHER_ID")
  val source =
    WS.url(s"http://api.openweathermap.org/data/2.5/weather?q=Tokyo&units=metric&appid=${openWeatherID}")
    .get()

  def insertMin() = {
    source.onSuccess{
      case response => {
        val temps = (response.json \ "main").validate[CurrentTemps].getOrElse(null)

        DB.withSession { implicit session =>
          val tempdatum = TableQuery[TempDatum]
          val insertData = TempData(None, "Tokyo", temps.temp, null.asInstanceOf[Int] , new LocalDate())
          tempdatum.insert(insertData)
        }
      }
    }
  }

  def insertMax() = {
    source.onSuccess{
      case response => {
        val temps = (response.json \ "main").validate[CurrentTemps].getOrElse(null)

        DB.withSession { implicit session =>
          val temdatum = TableQuery[TempDatum]
          val date = new LocalDate()
          val city = "Tokyo"

          temdatum
          .filter(row => row.date === date && row.city === city)
          .map(_.max)
          .update(temps.temp)
        }
      }
    }
  }

  def deleteOldData() = {
    DB.withSession { implicit session =>
      val temdatum = TableQuery[TempDatum]
      val date = new LocalDate().minusWeeks(1)
      temdatum
      .filter(_.date < date)
      .delete
    }
  }
}
