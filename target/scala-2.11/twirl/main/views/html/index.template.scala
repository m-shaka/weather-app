
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
import play.api.libs.json.Json
import models._
import org.joda.time.LocalDate
/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[List[WeatherImage],List[String],List[String],List[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(images: List[WeatherImage], dates: List[String], maxes: List[String], mins: List[String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*4.92*/("""

"""),_display_(/*6.2*/main("Ozora Weather", "index")/*6.32*/ {_display_(Seq[Any](format.raw/*6.34*/("""
"""),format.raw/*7.1*/("""<div class="container">
  <div class="row">
    <h2>東京のお天気</h2>
    <div class="col-sm-6" id="today">
      <h3>"""),_display_(/*11.12*/dates(0)),format.raw/*11.20*/("""</h3>
      <h4>
        <img src=""""),_display_(/*13.20*/(images(0).url)),format.raw/*13.35*/(""""> """),_display_(/*13.39*/images(0)/*13.48*/.title),format.raw/*13.54*/("""
      """),format.raw/*14.7*/("""</h4>
      <table class="table">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>最高気温</td>
            <td id="max">"""),_display_(/*21.27*/maxes(0)),format.raw/*21.35*/("""</td>
          </tr>
          <tr>
            <td>最低気温</td>
            <td id="min">"""),_display_(/*25.27*/mins(0)),format.raw/*25.34*/("""</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="col-sm-6" id="tomorrow">
      <h3>"""),_display_(/*32.12*/dates(1)),format.raw/*32.20*/("""</h3>
      <h4>
        <img src=""""),_display_(/*34.20*/(images(1).url)),format.raw/*34.35*/(""""> """),_display_(/*34.39*/images(1)/*34.48*/.title),format.raw/*34.54*/("""
      """),format.raw/*35.7*/("""</h4>
      <table class="table">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>最高気温</td>
            <td id="max">"""),_display_(/*42.27*/maxes(1)),format.raw/*42.35*/("""</td>
          </tr>
          <tr>
            <td>最低気温</td>
            <td id="min">"""),_display_(/*46.27*/mins(1)),format.raw/*46.34*/("""</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
""")))}),format.raw/*53.2*/("""
"""))}
  }

  def render(images:List[WeatherImage],dates:List[String],maxes:List[String],mins:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(images,dates,maxes,mins)

  def f:((List[WeatherImage],List[String],List[String],List[String]) => play.twirl.api.HtmlFormat.Appendable) = (images,dates,maxes,mins) => apply(images,dates,maxes,mins)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Mar 30 22:02:16 JST 2016
                  SOURCE: /home/vagrant/app/app/views/index.scala.html
                  HASH: f67a25b4c75cda11a7862811b3f78b3205ae8893
                  MATRIX: 633->82|811->172|839->175|877->205|916->207|943->208|1083->321|1112->329|1175->365|1211->380|1242->384|1260->393|1287->399|1321->406|1498->556|1527->564|1643->653|1671->660|1816->778|1845->786|1908->822|1944->837|1975->841|1993->850|2020->856|2054->863|2231->1013|2260->1021|2376->1110|2404->1117|2516->1199
                  LINES: 21->4|24->4|26->6|26->6|26->6|27->7|31->11|31->11|33->13|33->13|33->13|33->13|33->13|34->14|41->21|41->21|45->25|45->25|52->32|52->32|54->34|54->34|54->34|54->34|54->34|55->35|62->42|62->42|66->46|66->46|73->53
                  -- GENERATED --
              */
          