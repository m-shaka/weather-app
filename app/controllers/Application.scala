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

object Application extends Controller {

  def index = DBAction { implicit rs =>
    // 最高気温、最低気温はDBにデータがあればそれを表示する
    val tempdatum = TableQuery[TempDatum]
    val date = new LocalDate()
    val city = "Tokyo"
    val dbData = tempdatum.filter(row => row.date === date && row.city === city)

    val openWeatherID = sys.env("OPEN_WEATHER_ID")

    // 現在の天気
    val currentJson =
      WS.url(s"http://api.openweathermap.org/data/2.5/weather?q=Tokyo&units=metric&appid=${openWeatherID}")
      .get()

    // 今日明日の予報（明日分のみ使用）
    val twoDaysJson =
      WS.url(s"http://api.openweathermap.org/data/2.5/forecast/daily?q=Tokyo&units=metric&cnt=2&appid=${openWeatherID}")
      .get()

    val json = Await.result(currentJson, Duration.Inf).json
    val json2 = Await.result(twoDaysJson, Duration.Inf).json

    val temps =
      (json \ "main")
      .validate[CurrentTemps]
      .getOrElse(null)

    val detail =
      (json \ "weather")
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

    Ok(views.html.index(detail, temps, dbData.list, tempsTommorow, detailTomorrow))

  }

  def about = Action {
    Ok(views.html.about())
  }
}
