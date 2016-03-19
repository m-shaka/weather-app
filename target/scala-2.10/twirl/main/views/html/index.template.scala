
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[JsObject,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(output: JsObject):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.20*/("""

"""),_display_(/*3.2*/main("Top | Osora Weather")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""
  """),format.raw/*4.3*/("""<p>"""),_display_(/*4.7*/(output / "forecasts" / "date")),format.raw/*4.38*/("""</p>
""")))}),format.raw/*5.2*/("""
"""))}
  }

  def render(output:JsObject): play.twirl.api.HtmlFormat.Appendable = apply(output)

  def f:((JsObject) => play.twirl.api.HtmlFormat.Appendable) = (output) => apply(output)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Mar 12 07:26:57 GMT 2016
                  SOURCE: /home/vagrant/app/app/views/index.scala.html
                  HASH: f20f829c7c0886826503f4746bc9509855249d66
                  MATRIX: 507->1|613->19|643->24|678->51|717->53|747->57|776->61|827->92|863->99
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|25->4|25->4|26->5
                  -- GENERATED --
              */
          