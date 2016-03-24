
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
object about extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*2.2*/main("about | Ozora Weather", "about")/*2.40*/ {_display_(Seq[Any](format.raw/*2.42*/("""
  """),format.raw/*3.3*/("""<div class="container">
    <div class="row">
      <h1 >このサイトについて</h1>
      <h2 >環境</h2>

      <ul>
        <li>Scala(2.11.7)</li>
        <li>Play Framework(2.3.8)</li>
        <li>Akka(2.4)</li>
        <li>Play-Slick(0.8.1)</li>
        <li>Postgresql(9.3)</li>
      </ul>

      <h2 >概略</h2>
      <p>livedoorさんのWeather HackのAPIからお天気情報をJSONで取得し表示しています。動作はかなり不安定でよくエラーを吐きます……。今後やりたいこととしては</p>
      <ol style="list-style-type: decimal">
        <li>DBに記録している最高気温、最低気温の情報を使い一週間の変化をグラフで示す（jsのライブラリを使う)</li>
        <li>全都道府県の天気を表示する。（JQueryでページ遷移しないで切り替える）</li>
      </ol>
      <p>などが挙げられます。</p>
    </div>
  </div>
""")))}),format.raw/*25.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Wed Mar 23 12:42:00 JST 2016
                  SOURCE: /home/vagrant/app/app/views/about.scala.html
                  HASH: f47129785a48e7fe37d095af6ad0470f4d9eb2c3
                  MATRIX: 580->2|626->40|665->42|694->45|1348->669
                  LINES: 22->2|22->2|22->2|23->3|45->25
                  -- GENERATED --
              */
          