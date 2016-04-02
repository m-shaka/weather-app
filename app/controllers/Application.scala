package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.libs.json.Json
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import models._
import akka.actor.Actor
import org.joda.time.{ LocalDate, DateTimeZone }
import com.github.tototoshi.slick.PostgresJodaSupport._
import play.api.libs.ws._
import scala.concurrent.duration.Duration
import scala.concurrent.{ Future, Await }
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.concurrent.Execution.Implicits.defaultContext

object Application extends Controller {

  def getJsonFromApi(url: String) = {
    implicit val context = play.api.libs.concurrent.Execution.Implicits.defaultContext
    val futureResponse =
      WS.url(url).get().map{
        response => response.json
      }
    Await.result(futureResponse, Duration.Inf)
  }

  def index = Action { request =>

    val cityID = "130010"
    val weatherInfoUrl = s"http://weather.livedoor.com/forecast/webservice/json/v1?city=${cityID}"
    val json = getJsonFromApi(weatherInfoUrl)

    val forecasts = (json \ "forecasts")
    val images = (forecasts \\ "image").map(
      day => day.validate[WeatherImage].getOrElse(null)
    ).toList
    val dates = (forecasts \\ "date").map(
      day => day.validate[String].getOrElse("Error")
    ).toList
    val maxes = (forecasts \\ "temperature").map(
      day => (day \ "max" \ "celsius").validate[String].getOrElse("--")
    ).toList
    val mins = (forecasts \\ "temperature").map(
      day => (day \ "min" \ "celsius").validate[String].getOrElse("--")
    ).toList

    Ok(views.html.index(images, dates, maxes, mins))

  }

  def getDBData() = {
    DB.withSession {implicit session =>
      val tempdatum = TableQuery[TempDatum]
      val date = new LocalDate()
      val city = "Tokyo"
      tempdatum
      .filter(row => row.date === date && row.city === city)
      .list
    }
  }

  def about = Action {
    Ok(views.html.about())
  }

  def statistic = Action {
    DB.withSession {implicit session =>
      val tempdatum = TableQuery[TempDatum]
      val fromDate = new LocalDate(DateTimeZone.forID("Asia/Tokyo")).minusWeeks(1)
      val toDate = fromDate.plusDays(6)
      val city = "Tokyo"
      val weeklyTemps =
        tempdatum
        .filter(row =>
          row.date >= fromDate && row.date <= toDate &&row.city === city
        )
        .sortBy(_.date)
        .list

      Ok(views.html.statistic(weeklyTemps))
    }
  }
}
