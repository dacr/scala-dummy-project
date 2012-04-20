import AssemblyKeys._

seq(assemblySettings: _*)

name := "ScalaDummyProject"

version := "0.1.2"

scalaVersion := "2.9.2"

mainClass in assembly := Some("dummy.Dummy")

jarName in assembly := "dummy.jar"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.7.2" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

