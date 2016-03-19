package models
import play.api.libs.json.Json

case class DailyTemp(day: Double, min: Double, max: Double, night: Double, eve: Double, morn: Double)
object DailyTemp {
  implicit def jsonWrites = Json.writes[DailyTemp]
  implicit def jsonReads = Json.reads[DailyTemp]
}

case class DailyList(dt: Int, temp: DailyTemp, pressure: Double, humidity: Int, weather: WeatherDetail, speed: Double, deg: Int, clouds: Int)
object DailyList {
  implicit def jsonWrites = Json.writes[DailyList]
  implicit def jsonReads = Json.reads[DailyList]
}
