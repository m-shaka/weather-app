package models
import play.api.libs.json.Json

case class WeatherImage(width: Int, url: String, title: String, height: Int)
object WeatherImage {
  implicit def jsonWrites = Json.writes[WeatherImage]
  implicit def jsonReads = Json.reads[WeatherImage]
}
