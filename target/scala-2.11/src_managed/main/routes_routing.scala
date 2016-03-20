// @SOURCE:/home/vagrant/app/conf/routes
// @HASH:624f28cee677a3e299f848794946cfcabacd32b0
// @DATE:Sun Mar 20 14:16:45 JST 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:1
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """"""))
        

// @LINE:2
private[this] lazy val controllers_Application_about1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("about"))))
private[this] lazy val controllers_Application_about1_invoker = createInvoker(
controllers.Application.about,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "about", Nil,"GET", """""", Routes.prefix + """about"""))
        

// @LINE:3
private[this] lazy val controllers_Application_statistic2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("statistic"))))
private[this] lazy val controllers_Application_statistic2_invoker = createInvoker(
controllers.Application.statistic,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "statistic", Nil,"GET", """""", Routes.prefix + """statistic"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """about""","""controllers.Application.about"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """statistic""","""controllers.Application.statistic""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:1
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:2
case controllers_Application_about1_route(params) => {
   call { 
        controllers_Application_about1_invoker.call(controllers.Application.about)
   }
}
        

// @LINE:3
case controllers_Application_statistic2_route(params) => {
   call { 
        controllers_Application_statistic2_invoker.call(controllers.Application.statistic)
   }
}
        
}

}
     