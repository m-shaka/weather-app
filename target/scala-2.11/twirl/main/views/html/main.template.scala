
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[String,String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String, page: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.46*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    </head>
    <body>
        """),_display_(/*17.10*/navi(page)),format.raw/*17.20*/("""
        """),_display_(/*18.10*/content),format.raw/*18.17*/("""
    """),format.raw/*19.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,page:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title,page)(content)

  def f:((String,String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title,page) => (content) => apply(title,page)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Mar 19 21:44:33 JST 2016
                  SOURCE: /home/vagrant/app/app/views/main.scala.html
                  HASH: 0085a16cee1abfe20ac630c3a7cdadeef16e0c06
                  MATRIX: 516->1|648->45|676->47|753->98|778->103|1585->883|1616->893|1653->903|1681->910|1713->915
                  LINES: 19->1|22->1|24->3|28->7|28->7|38->17|38->17|39->18|39->18|40->19
                  -- GENERATED --
              */
          