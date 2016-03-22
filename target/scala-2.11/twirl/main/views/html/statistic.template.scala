
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object statistic extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[TempData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(weeklyTemps: List[TempData]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {import org.joda.time.LocalDate

Seq[Any](format.raw/*1.31*/("""
"""),_display_(/*3.2*/println(weeklyTemps)),format.raw/*3.22*/("""
"""),_display_(/*4.2*/main("statistic | Ozora Weather", "statistic")/*4.48*/ {_display_(Seq[Any](format.raw/*4.50*/("""
  """),format.raw/*5.3*/("""<div class="container">
    <div class="row">
      preparing...<br>
    </div>
  </div>
""")))}),format.raw/*10.2*/("""
"""))}
  }

  def render(weeklyTemps:List[TempData]): play.twirl.api.HtmlFormat.Appendable = apply(weeklyTemps)

  def f:((List[TempData]) => play.twirl.api.HtmlFormat.Appendable) = (weeklyTemps) => apply(weeklyTemps)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Mar 22 17:58:37 JST 2016
                  SOURCE: /home/vagrant/app/app/views/statistic.scala.html
                  HASH: ffa8ef6d387872a1c941bfb36ede49a480ed50e0
                  MATRIX: 517->1|664->30|691->64|731->84|758->86|812->132|851->134|880->137|1000->227
                  LINES: 19->1|22->1|23->3|23->3|24->4|24->4|24->4|25->5|30->10
                  -- GENERATED --
              */
          