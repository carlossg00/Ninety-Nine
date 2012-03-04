// set the name of the project
name := "Scala Ninety-Nine problems"

version := "0.1"


// set the Scala version used for the project
scalaVersion := "2.9.1"


// add a test dependency on ScalaTest
libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.1" % "test"

// append -deprecation to the options passed to the Scala compiler
scalacOptions += "-deprecation"

