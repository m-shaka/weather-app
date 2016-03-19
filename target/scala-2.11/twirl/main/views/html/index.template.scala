
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[WeatherDetail,CurrentTemps,List[TempData],DailyTemp,WeatherDetail,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(detail: WeatherDetail, temps: CurrentTemps, dbData: List[TempData], tempsTommorow: DailyTemp, detailTomorrow: WeatherDetail):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*4.127*/("""

"""),_display_(/*6.2*/main("Ozora Weather", "index")/*6.32*/ {_display_(Seq[Any](format.raw/*6.34*/("""
"""),format.raw/*7.1*/("""<div class="container">
  <div class="row">
    <h2>東京のお天気</h2>
    <div class="col-sm-6">
      <h3>今日</h3>
      <h4>
        <img src="http://openweathermap.org/img/w/"""),_display_(/*13.52*/(detail.icon)),format.raw/*13.65*/(""".png" width=50 height=50> """),_display_(/*13.92*/temps/*13.97*/.temp),format.raw/*13.102*/(""" """),format.raw/*13.103*/("""℃（現在）<br>
        """),_display_(/*14.10*/detail/*14.16*/.description),format.raw/*14.28*/("""
      """),format.raw/*15.7*/("""</h4>
      <table class="table">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>最高気温</td>
            <td>
              """),_display_(/*23.16*/if(dbData != Nil && dbData.head.max != null.asInstanceOf[Double])/*23.81*/ {_display_(Seq[Any](format.raw/*23.83*/("""
                """),_display_(/*24.18*/dbData/*24.24*/.head.max),format.raw/*24.33*/("""
              """)))}/*25.17*/else/*25.22*/{_display_(Seq[Any](format.raw/*25.23*/("""
                """),_display_(/*26.18*/temps/*26.23*/.temp_max),format.raw/*26.32*/("""
              """)))}),format.raw/*27.16*/("""  """),format.raw/*27.18*/("""℃
            </td>
          </tr>
          <tr>
            <td>最低気温</td>
            <td>
              """),_display_(/*33.16*/if(dbData != Nil && dbData.head.min != null.asInstanceOf[Double])/*33.81*/ {_display_(Seq[Any](format.raw/*33.83*/("""
                """),_display_(/*34.18*/dbData/*34.24*/.head.min),format.raw/*34.33*/("""
              """)))}/*35.17*/else/*35.22*/{_display_(Seq[Any](format.raw/*35.23*/("""
                """),_display_(/*36.18*/temps/*36.23*/.temp_min),format.raw/*36.32*/("""
              """)))}),format.raw/*37.16*/("""  """),format.raw/*37.18*/("""℃
            </td>
          </tr>
          <tr>
            <td>気圧</td>
            <td>"""),_display_(/*42.18*/temps/*42.23*/.pressure),format.raw/*42.32*/(""" """),format.raw/*42.33*/("""pha</td>
          </tr>
          <tr>
            <td>湿度</td>
            <td>"""),_display_(/*46.18*/temps/*46.23*/.humidity),format.raw/*46.32*/(""" """),format.raw/*46.33*/("""%</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="col-sm-6">
      <h3>明日</h3>
      <h4>
        <img src="http://openweathermap.org/img/w/"""),_display_(/*54.52*/(detailTomorrow.icon)),format.raw/*54.73*/(""".png" width=50 height=50> """),_display_(/*54.100*/tempsTommorow/*54.113*/.day),format.raw/*54.117*/(""" """),format.raw/*54.118*/("""℃（平均）<br>
        """),_display_(/*55.10*/detailTomorrow/*55.24*/.description),format.raw/*55.36*/("""
      """),format.raw/*56.7*/("""</h4>
      <table class="table">
        <thead>
        </thead>
        <tbody>
          <tr>
            <td>最高気温</td>
            <td>"""),_display_(/*63.18*/tempsTommorow/*63.31*/.max),format.raw/*63.35*/(""" """),format.raw/*63.36*/("""℃</td>
          </tr>
          <tr>
            <td>最低気温</td>
            <td>"""),_display_(/*67.18*/tempsTommorow/*67.31*/.min),format.raw/*67.35*/(""" """),format.raw/*67.36*/("""℃</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
""")))}),format.raw/*74.2*/("""
"""))}
  }

  def render(detail:WeatherDetail,temps:CurrentTemps,dbData:List[TempData],tempsTommorow:DailyTemp,detailTomorrow:WeatherDetail): play.twirl.api.HtmlFormat.Appendable = apply(detail,temps,dbData,tempsTommorow,detailTomorrow)

  def f:((WeatherDetail,CurrentTemps,List[TempData],DailyTemp,WeatherDetail) => play.twirl.api.HtmlFormat.Appendable) = (detail,temps,dbData,tempsTommorow,detailTomorrow) => apply(detail,temps,dbData,tempsTommorow,detailTomorrow)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Mar 19 21:42:35 JST 2016
                  SOURCE: /home/vagrant/app/app/views/index.scala.html
                  HASH: dcd968229e5d89aa04ef65469187c468b3c9c86b
                  MATRIX: 641->82|855->207|883->210|921->240|960->242|987->243|1185->414|1219->427|1273->454|1287->459|1314->464|1344->465|1390->484|1405->490|1438->502|1472->509|1655->665|1729->730|1769->732|1814->750|1829->756|1859->765|1894->782|1907->787|1946->788|1991->806|2005->811|2035->820|2082->836|2112->838|2248->947|2322->1012|2362->1014|2407->1032|2422->1038|2452->1047|2487->1064|2500->1069|2539->1070|2584->1088|2598->1093|2628->1102|2675->1118|2705->1120|2824->1212|2838->1217|2868->1226|2897->1227|3005->1308|3019->1313|3049->1322|3078->1323|3278->1496|3320->1517|3375->1544|3398->1557|3424->1561|3454->1562|3500->1581|3523->1595|3556->1607|3590->1614|3758->1755|3780->1768|3805->1772|3834->1773|3942->1854|3964->1867|3989->1871|4018->1872|4131->1955
                  LINES: 21->4|24->4|26->6|26->6|26->6|27->7|33->13|33->13|33->13|33->13|33->13|33->13|34->14|34->14|34->14|35->15|43->23|43->23|43->23|44->24|44->24|44->24|45->25|45->25|45->25|46->26|46->26|46->26|47->27|47->27|53->33|53->33|53->33|54->34|54->34|54->34|55->35|55->35|55->35|56->36|56->36|56->36|57->37|57->37|62->42|62->42|62->42|62->42|66->46|66->46|66->46|66->46|74->54|74->54|74->54|74->54|74->54|74->54|75->55|75->55|75->55|76->56|83->63|83->63|83->63|83->63|87->67|87->67|87->67|87->67|94->74
                  -- GENERATED --
              */
          