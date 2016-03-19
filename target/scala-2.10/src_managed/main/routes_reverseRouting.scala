// @SOURCE:/home/vagrant/app/conf/routes
// @HASH:e8e3619e862241f09509c9bafb7aa8b1f56ec860
// @DATE:Sat Mar 12 07:05:37 GMT 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:1
package controllers {

// @LINE:1
class ReverseApplication {


// @LINE:1
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

}
                          
}
                  


// @LINE:1
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:1
class ReverseApplication {


// @LINE:1
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

}
              
}
        


// @LINE:1
package controllers.ref {


// @LINE:1
class ReverseApplication {


// @LINE:1
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      

}
                          
}
        
    