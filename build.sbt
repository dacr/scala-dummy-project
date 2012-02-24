import AssemblyKeys._

seq(assemblySettings: _*)

name := "ScalaDummyProject"

version := "0.1"

scalaVersion := "2.9.1"

mainClass in assembly := Some("dummy.Dummy")

jarName in assembly := "dummy.jar"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

