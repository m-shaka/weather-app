
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
"""),_display_(/*5.2*/println(mins)),format.raw/*5.15*/("""

"""),_display_(/*7.2*/main("Ozora Weather", "index")/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""
"""),format.raw/*8.1*/("""<div class="container">
  <div class="row">
    <h2>東京のお天気</h2>
    <div class="col-sm-6" id="today">
      <h3>"""),_display_(/*12.12*/dates(0)),format.raw/*12.20*/("""</h3>
      <h4>
        <img src=""""),_display_(/*14.20*/(images(0).url)),format.raw/*14.35*/(""""> """),_display_(/*14.39*/images(0)/*14.48*/.title),format.raw/*14.54*/("""
      """),format.raw/*15.7*/("""</h4>
      <table class="table">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>最高気温</td>
            <td id="max">"""),_display_(/*22.27*/maxes(0)),format.raw/*22.35*/("""</td>
          </tr>
          <tr>
            <td>最低気温</td>
            <td id="min">"""),_display_(/*26.27*/mins(0)),format.raw/*26.34*/("""</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="col-sm-6" id="tomorrow">
      <h3>"""),_display_(/*33.12*/dates(1)),format.raw/*33.20*/("""</h3>
      <h4>
        <img src=""""),_display_(/*35.20*/(images(1).url)),format.raw/*35.35*/(""""> """),_display_(/*35.39*/images(1)/*35.48*/.title),format.raw/*35.54*/("""
      """),format.raw/*36.7*/("""</h4>
      <table class="table">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>最高気温</td>
            <td id="max">"""),_display_(/*43.27*/maxes(1)),format.raw/*43.35*/("""</td>
          </tr>
          <tr>
            <td>最低気温</td>
            <td id="min">"""),_display_(/*47.27*/mins(1)),format.raw/*47.34*/("""</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
""")))}),format.raw/*54.2*/("""
"""))}
  }

  def render(images:List[WeatherImage],dates:List[String],maxes:List[String],mins:List[String]): play.twirl.api.HtmlFormat.Appendable = apply(images,dates,maxes,mins)

  def f:((List[WeatherImage],List[String],List[String],List[String]) => play.twirl.api.HtmlFormat.Appendable) = (images,dates,maxes,mins) => apply(images,dates,maxes,mins)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Mar 22 18:11:30 JST 2016
                  SOURCE: /home/vagrant/app/app/views/index.scala.html
                  HASH: 6f0a6c7633d1eec3cb9828b21e12130aa1fd5f20
                  MATRIX: 633->82|811->172|838->174|871->187|899->190|937->220|976->222|1003->223|1143->336|1172->344|1235->380|1271->395|1302->399|1320->408|1347->414|1381->421|1558->571|1587->579|1703->668|1731->675|1876->793|1905->801|1968->837|2004->852|2035->856|2053->865|2080->871|2114->878|2291->1028|2320->1036|2436->1125|2464->1132|2576->1214
                  LINES: 21->4|24->4|25->5|25->5|27->7|27->7|27->7|28->8|32->12|32->12|34->14|34->14|34->14|34->14|34->14|35->15|42->22|42->22|46->26|46->26|53->33|53->33|55->35|55->35|55->35|55->35|55->35|56->36|63->43|63->43|67->47|67->47|74->54
                  -- GENERATED --
              */
          