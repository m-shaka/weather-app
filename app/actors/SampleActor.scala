package actors

import akka.actor.Actor
import models._
import play.api.libs.json.Json
import play.api.db.slick._
import play.api.Play.current
import slick.driver.PostgresDriver.simple._
import org.joda.time.LocalDate
import com.github.tototoshi.slick.PostgresJodaSupport._

class SampleActor extends Actor {

  def receive = {
    case "min" => insertMin()
    case "max" => insertMax()
    case "delete" => deleteOldData()
    }

  val source = io.Source.fromURL("http://api.openweathermap.org/data/2.5/weather?q=Tokyo&units=metric&appid=4c2b461153c45c9a28757925a1991646")

  val json = Json.parse(source.mkString)
  val temps = (json \ "main").validate[CurrentTemps].getOrElse(null)

  def insertMin() = {
    DB.withSession { implicit session =>
      val tempdatum = TableQuery[TempDatum]
      val insertData = TempData(None, "Tokyo", temps.temp, null.asInstanceOf[Int] , new LocalDate())
      tempdatum.insert(insertData)
    }
    println("creating test data")
  }

  def insertMax() = {
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
