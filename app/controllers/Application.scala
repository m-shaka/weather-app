package controllers

import play.api._
import play.api.mvc._
import play.api.Play.current
import play.api.libs.json.Json
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import models._
import akka.actor.Actor
import org.joda.time.LocalDate
import com.github.tototoshi.slick.PostgresJodaSupport._
import play.api.libs.ws._
import scala.concurrent.duration.{ Duration, MILLISECONDS }
import scala.concurrent.{ Future, Await }
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.concurrent.Execution.Implicits.defaultContext

object Application extends Controller {

  def index = Action { rs =>
    // 最高気温、最低気温はDBにデータがあればそれを表示する
    val dbData: List[TempData] = getDBData()

    val openWeatherID = sys.env("OPEN_WEATHER_ID")

    // 現在の天気
    lazy val currentJson =
      io.Source.fromURL(s"http://api.openweathermap.org/data/2.5/weather?id=1850147&units=metric&appid=${openWeatherID}")

    val json1 = Json.parse(currentJson.mkString)

    // 今日明日の予報（明日分のみ使用）
    lazy val twoDaysJson =
      io.Source.fromURL(s"http://api.openweathermap.org/data/2.5/forecast/daily?id=1850147&units=metric&cnt=2&appid=${openWeatherID}")

    val json2 = Json.parse(twoDaysJson.mkString)

    val temps =
      (json1 \ "main")
      .validate[CurrentTemps]
      .getOrElse(null)

    val detail =
      (json1 \ "weather")
      .validate[List[WeatherDetail]]
      .getOrElse(null).head

    val tempsTommorow =
      (json2 \\ "temp")
      .last
      .validate[DailyTemp].getOrElse(null)

    val detailTomorrow =
      (json2 \\ "weather")
      .last
      .validate[List[WeatherDetail]].getOrElse(null).head

    Ok(views.html.index(detail, temps, dbData, tempsTommorow, detailTomorrow))
  }

  def getDBData() = {
    DB.withSession {implicit session =>
      val tempdatum = TableQuery[TempDatum]
      val date = new LocalDate()
      val city = "Tokyo"
      tempdatum.filter(row => row.date === date && row.city === city).list
    }
  }

  def about = Action {
    Ok(views.html.about())
  }

  def statistic = Action {
    DB.withSession {implicit session =>
      val tempdatum = TableQuery[TempDatum]
      val date = new LocalDate().minusWeeks(1)
      val city = "Tokyo"
      val weeklyTemps =
        tempdatum.filter(row => row.date >= date && row.city === city).list
      Ok(views.html.statistic(weeklyTemps))
    }
  }
}
