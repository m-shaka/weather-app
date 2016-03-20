
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
object navi extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(page: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand">Ozora Weather</a>
    </div>
    <ul class="nav navbar-nav">
      """),_display_(/*9.8*/(if(page == "index") {
        <li class="active"><a href="/">Top</a></li>
        <li><a href="/statistic">Statistic</a></li>
        <li><a href="/about">About</a></li>
      } else if(page == "about") {
        <li><a href="/">Top</a></li>
        <li><a href="/statistic">Statistic</a></li>
        <li class="active"><a href="/about">About</a></li>
      } else {
        <li><a href="/">Top</a></li>
        <li class="active"><a href="/statistic">Statistic</a></li>
        <li><a href="/about">About</a></li>
      })),format.raw/*21.9*/("""
    """),format.raw/*22.5*/("""</ul>
  </div>
</nav>
"""))}
  }

  def render(page:String): play.twirl.api.HtmlFormat.Appendable = apply(page)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (page) => apply(page)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 20 14:21:00 JST 2016
                  SOURCE: /home/vagrant/app/app/views/navi.scala.html
                  HASH: 1af267cf34cb1f09933ddd86717cace40780c606
                  MATRIX: 504->1|606->15|634->17|851->209|1396->734|1428->739
                  LINES: 19->1|22->1|24->3|30->9|42->21|43->22
                  -- GENERATED --
              */
          