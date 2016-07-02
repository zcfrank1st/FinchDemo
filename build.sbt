name := "FinchDemo"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.github.finagle" %% "finch-core" % "0.10.0",
  "com.github.finagle" %% "finch-circe" % "0.10.0",
  "io.circe" %% "circe-generic" % "0.3.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.4.0",
  "ch.qos.logback" %  "logback-classic" % "1.1.7",
  "com.typesafe" % "config" % "1.3.0",

  "com.typesafe.slick" %% "slick" % "3.1.1",
  "com.typesafe.slick" %% "slick-codegen" % "3.1.1",

  "mysql" % "mysql-connector-java" % "5.1.37",
  "com.zaxxer" % "HikariCP" % "2.4.3"
)
