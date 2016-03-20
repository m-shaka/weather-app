
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
"""),format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("statistic | Ozora Weather", "statistic")/*4.48*/ {_display_(Seq[Any](format.raw/*4.50*/("""
  """),format.raw/*5.3*/("""<div class="container">
    <div class="row">
      preparing...<br>
      <!-- """),_display_(/*8.13*/weeklyTemps/*8.24*/.length),format.raw/*8.31*/(""" """),format.raw/*8.32*/("""-->
    </div>
  </div>
""")))}),format.raw/*11.2*/("""
"""))}
  }

  def render(weeklyTemps:List[TempData]): play.twirl.api.HtmlFormat.Appendable = apply(weeklyTemps)

  def f:((List[TempData]) => play.twirl.api.HtmlFormat.Appendable) = (weeklyTemps) => apply(weeklyTemps)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 20 14:51:16 JST 2016
                  SOURCE: /home/vagrant/app/app/views/statistic.scala.html
                  HASH: a3e511e1d288120a4b4344c89c845839482b4e6e
                  MATRIX: 517->1|664->30|691->63|718->65|772->111|811->113|840->116|947->197|966->208|993->215|1021->216|1076->241
                  LINES: 19->1|22->1|23->3|24->4|24->4|24->4|25->5|28->8|28->8|28->8|28->8|31->11
                  -- GENERATED --
              */
          