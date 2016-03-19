package models
import play.api.libs.json.Json

case class WeatherDetail(id: Int, main: String, description: String, icon: String)
object WeatherDetail {
  implicit def jsonWrites = Json.writes[WeatherDetail]
  implicit def jsonReads = Json.reads[WeatherDetail]
}

case class CurrentTemps(temp: Double, pressure: Int, humidity: Int, temp_min: Int, temp_max: Int)
object CurrentTemps {
  implicit def jsonWrites = Json.writes[CurrentTemps]
  implicit def jsonReads = Json.reads[CurrentTemps]
}
