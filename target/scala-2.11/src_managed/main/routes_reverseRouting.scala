// @SOURCE:/home/vagrant/app/conf/routes
// @HASH:624f28cee677a3e299f848794946cfcabacd32b0
// @DATE:Sun Mar 20 14:16:45 JST 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:3
// @LINE:2
// @LINE:1
package controllers {

// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApplication {


// @LINE:2
def about(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "about")
}
                        

// @LINE:1
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:3
def statistic(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "statistic")
}
                        

}
                          
}
                  


// @LINE:3
// @LINE:2
// @LINE:1
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApplication {


// @LINE:2
def about : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.about",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "about"})
      }
   """
)
                        

// @LINE:1
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:3
def statistic : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.statistic",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "statistic"})
      }
   """
)
                        

}
              
}
        


// @LINE:3
// @LINE:2
// @LINE:1
package controllers.ref {


// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApplication {


// @LINE:2
def about(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.about(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "about", Seq(), "GET", """""", _prefix + """about""")
)
                      

// @LINE:1
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

// @LINE:3
def statistic(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.statistic(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "statistic", Seq(), "GET", """""", _prefix + """statistic""")
)
                      

}
                          
}
        
    