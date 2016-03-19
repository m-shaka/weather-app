
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
      """),_display_(/*9.8*/if(page == "index")/*9.27*/ {_display_(Seq[Any](format.raw/*9.29*/("""
        """),format.raw/*10.9*/("""<li class="active"><a href="/">Top</a></li>
        <li><a href="/about">About</a></li>
      """)))}/*12.9*/else/*12.14*/{_display_(Seq[Any](format.raw/*12.15*/("""
        """),format.raw/*13.9*/("""<li><a href="/">Top</a></li>
        <li class="active"><a href="/about">About</a></li>
      """)))}),format.raw/*15.8*/("""
    """),format.raw/*16.5*/("""</ul>
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
                  DATE: Sat Mar 19 21:42:54 JST 2016
                  SOURCE: /home/vagrant/app/app/views/navi.scala.html
                  HASH: 89c5b848fcaa71e41820d3da88fe86c2258dbd7b
                  MATRIX: 504->1|606->15|634->17|851->209|878->228|917->230|953->239|1066->335|1079->340|1118->341|1154->350|1279->445|1311->450
                  LINES: 19->1|22->1|24->3|30->9|30->9|30->9|31->10|33->12|33->12|33->12|34->13|36->15|37->16
                  -- GENERATED --
              */
          