package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import models._
import akka.actor.Actor
import org.joda.time.LocalDate
import com.github.tototoshi.slick.PostgresJodaSupport._

object Application extends Controller {

  def index = DBAction { implicit rs =>
    val openWeatherID = sys.env("OPEN_WEATHER_ID")

    val currentJson = io.Source.fromURL(s"http://api.openweathermap.org/data/2.5/weather?q=Tokyo&units=metric&appid=${openWeatherID}")
    val json = Json.parse(currentJson.mkString)
    val temps = (json \ "main").validate[CurrentTemps].getOrElse(null)
    val detail = (json \ "weather").validate[List[WeatherDetail]].getOrElse(null).head

    // 最高気温、最低気温はDBにデータがあればそれを表示する
    val tempdatum = TableQuery[TempDatum]
    val date = new LocalDate()
    val city = "Tokyo"
    val dbData = tempdatum.filter(row => row.date === date && row.city === city)

    // 明日の予報データ
    val twoDaysJson = io.Source.fromURL(s"http://api.openweathermap.org/data/2.5/forecast/daily?q=Tokyo&units=metric&cnt=2&appid=${openWeatherID}")
    val jsonTomorrow = Json.parse(twoDaysJson.mkString)
    val tempsTommorow =
      (jsonTomorrow \\ "temp")
      .last
      .validate[DailyTemp].getOrElse(null)

    val detailTomorrow =
      (jsonTomorrow \\ "weather")
      .last
      .validate[List[WeatherDetail]].getOrElse(null).head

    Ok(views.html.index(detail, temps, dbData.list, tempsTommorow, detailTomorrow))

  }

  def about = Action {
    Ok(views.html.about())
  }
}
