import akka.actor.{ ActorSystem, Props }
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension
import play.api.libs.concurrent.Akka
import play.api.libs.concurrent.Execution.Implicits._
import play.api.{ Application, GlobalSettings }
import play.api.Play.current
import actors.DatabaseActor


object Global extends GlobalSettings {

  val system = ActorSystem("SampleSystem")
  val actor = system.actorOf(Props(classOf[DatabaseActor]))

  override def onStart(app: Application) = {
    QuartzSchedulerExtension(system).schedule("InsertMinTemp", actor, "min")
    QuartzSchedulerExtension(system).schedule("InsertMaxTemp", actor, "max")
    QuartzSchedulerExtension(system).schedule("DeleteOldData", actor, "delete")
  }

  override def onStop(app: Application) = {
    system.shutdown()
  }

}
