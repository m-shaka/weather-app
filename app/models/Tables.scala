package models

import slick.driver.PostgresDriver.simple._
import org.joda.time.LocalDate
import com.github.tototoshi.slick.PostgresJodaSupport._

case class TempData(id: Option[Int], city: String, min: Double, max: Double, date: LocalDate)

class TempDatum(tag: Tag) extends Table[TempData](tag, "tempdatum") {
  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def city = column[String]("city", O.NotNull)
  def min = column[Double]("min")
  def max = column[Double]("max")
  def date = column[LocalDate]("date")

  def * = (id, city, min, max, date) <> (TempData.tupled, TempData.unapply)
}

// object TempDataDAO {
//   lazy val tempdatum = TableQuery[TempDatum]
//
//   def searchByCityAndDate(city: String, date: LocalDate)(implicit s: Session) {
//     tempdatum.filter(_.city === city).filter(_.date === date).first
//   }
//
//   def create(temp: TempData)(implicit s: Session) {
//     tempdatum.insert(temp)
//
//   }
// }
