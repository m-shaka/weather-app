package models

import slick.driver.PostgresDriver.simple._
import org.joda.time.LocalDate
import com.github.tototoshi.slick.PostgresJodaSupport._

case class TempData(id: Option[Int], city: String, min: Int, max: Int, date: LocalDate)

class TempDatum(tag: Tag) extends Table[TempData](tag, "tempdatum") {
  def id = column[Option[Int]]("id", O.PrimaryKey, O.AutoInc)
  def city = column[String]("city", O.NotNull)
  def min = column[Int]("min")
  def max = column[Int]("max")
  def date = column[LocalDate]("date")

  def * = (id, city, min, max, date) <> (TempData.tupled, TempData.unapply)
}
