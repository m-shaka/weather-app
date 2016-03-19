lazy val sample = Project(
  "sample", file(".")
).enablePlugins(PlayScala).settings(
  scalaVersion := "2.11.7"
)

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "com.enragedginger" %% "akka-quartz-scheduler" % "1.5.0-akka-2.4.x",
  "com.typesafe.play" %% "play-slick" % "0.8.1",
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "joda-time" % "joda-time" % "2.4",
  "org.joda" % "joda-convert" % "1.6",
  "com.github.tototoshi" %% "slick-joda-mapper" % "1.2.0"
  // "com.github.tototoshi" %% "slick-joda-mapper" % "0.1.0"
)
