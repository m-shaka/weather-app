
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
    preparing ...
    <div class="row" id="graph">
      <!-- """),_display_(/*8.13*/weeklyTemps/*8.24*/.length),format.raw/*8.31*/(""" """),format.raw/*8.32*/("""-->
    </div>
  </div>

  <script src="http://code.highcharts.com/highcharts.js"></script>
  <script type="text/javascript">
    var chart;
    var dates = [];
    var maxes = [];
    var mins = [];
    """),_display_(/*18.6*/for(temp <- weeklyTemps) yield /*18.30*/{_display_(Seq[Any](format.raw/*18.31*/("""
      """),format.raw/*19.7*/("""dates.push(""""),_display_(/*19.20*/(temp.date)),format.raw/*19.31*/("""".replace(/-/g, "/"));
      maxes.push("""),_display_(/*20.19*/temp/*20.23*/.max),format.raw/*20.27*/(""");
      mins.push("""),_display_(/*21.18*/temp/*21.22*/.min),format.raw/*21.26*/(""");
    """)))}),format.raw/*22.6*/("""

    """),format.raw/*24.5*/("""function draw() """),format.raw/*24.21*/("""{"""),format.raw/*24.22*/("""
      """),format.raw/*25.7*/("""var options = """),format.raw/*25.21*/("""{"""),format.raw/*25.22*/("""
        """),format.raw/*26.9*/("""chart: """),format.raw/*26.16*/("""{"""),format.raw/*26.17*/("""renderTo: "graph""""),format.raw/*26.34*/("""}"""),format.raw/*26.35*/(""",
        title: """),format.raw/*27.16*/("""{"""),format.raw/*27.17*/("""text: "東京の気温推移""""),format.raw/*27.32*/("""}"""),format.raw/*27.33*/(""",
        xAxis: """),format.raw/*28.16*/("""{"""),format.raw/*28.17*/("""
          """),format.raw/*29.11*/("""title: """),format.raw/*29.18*/("""{"""),format.raw/*29.19*/("""text: "日付""""),format.raw/*29.29*/("""}"""),format.raw/*29.30*/(""",
          categories: dates
        """),format.raw/*31.9*/("""}"""),format.raw/*31.10*/(""",
        yAxis: """),format.raw/*32.16*/("""{"""),format.raw/*32.17*/("""title: """),format.raw/*32.24*/("""{"""),format.raw/*32.25*/("""text: "気温（℃）""""),format.raw/*32.38*/("""}"""),format.raw/*32.39*/("""}"""),format.raw/*32.40*/(""",
        series: [
          """),format.raw/*34.11*/("""{"""),format.raw/*34.12*/("""name: "最低気温", data: mins"""),format.raw/*34.36*/("""}"""),format.raw/*34.37*/(""",
          """),format.raw/*35.11*/("""{"""),format.raw/*35.12*/("""name: "最高気温", data: maxes, color: '#DD0000'"""),format.raw/*35.55*/("""}"""),format.raw/*35.56*/("""
        """),format.raw/*36.9*/("""]
      """),format.raw/*37.7*/("""}"""),format.raw/*37.8*/("""
      """),format.raw/*38.7*/("""chart = new Highcharts.Chart(options);
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/("""
    """),format.raw/*40.5*/("""document.body.onload = draw();

  </script>
""")))}),format.raw/*43.2*/("""
"""))}
  }

  def render(weeklyTemps:List[TempData]): play.twirl.api.HtmlFormat.Appendable = apply(weeklyTemps)

  def f:((List[TempData]) => play.twirl.api.HtmlFormat.Appendable) = (weeklyTemps) => apply(weeklyTemps)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Mar 24 11:15:56 JST 2016
                  SOURCE: /home/vagrant/app/app/views/statistic.scala.html
                  HASH: 042f3720c2dfa2afb6313bd50bd55c68a12db6ee
                  MATRIX: 517->1|664->30|691->63|718->65|772->111|811->113|840->116|953->203|972->214|999->221|1027->222|1258->427|1298->451|1337->452|1371->459|1411->472|1443->483|1511->524|1524->528|1549->532|1596->552|1609->556|1634->560|1672->568|1705->574|1749->590|1778->591|1812->598|1854->612|1883->613|1919->622|1954->629|1983->630|2028->647|2057->648|2102->665|2131->666|2174->681|2203->682|2248->699|2277->700|2316->711|2351->718|2380->719|2418->729|2447->730|2512->768|2541->769|2586->786|2615->787|2650->794|2679->795|2720->808|2749->809|2778->810|2836->840|2865->841|2917->865|2946->866|2986->878|3015->879|3086->922|3115->923|3151->932|3186->940|3214->941|3248->948|3318->991|3346->992|3378->997|3453->1042
                  LINES: 19->1|22->1|23->3|24->4|24->4|24->4|25->5|28->8|28->8|28->8|28->8|38->18|38->18|38->18|39->19|39->19|39->19|40->20|40->20|40->20|41->21|41->21|41->21|42->22|44->24|44->24|44->24|45->25|45->25|45->25|46->26|46->26|46->26|46->26|46->26|47->27|47->27|47->27|47->27|48->28|48->28|49->29|49->29|49->29|49->29|49->29|51->31|51->31|52->32|52->32|52->32|52->32|52->32|52->32|52->32|54->34|54->34|54->34|54->34|55->35|55->35|55->35|55->35|56->36|57->37|57->37|58->38|59->39|59->39|60->40|63->43
                  -- GENERATED --
              */
          