import AssemblyKeys._

seq(assemblySettings: _*)

name := "ScalaDummyProject"

version := "2"

scalaVersion := "2.10.0-RC3"

scalacOptions ++= Seq("-unchecked", "-deprecation" )

mainClass in assembly := Some("dummy.Dummy")

jarName in assembly := "dummy.jar"

libraryDependencies += "org.scalatest" % "scalatest_2.10.0-RC3" % "2.0.M5-B1"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

initialCommands in console := """import dummy._"""

sourceGenerators in Compile <+= 
 (sourceManaged in Compile, version, name, jarName in assembly) map {
  (dir, version, projectname, jarexe) =>
  val file = dir / "dummy" / "MetaInfo.scala"
  IO.write(file,
  """package dummy
    |object MetaInfo { 
    |  val version="%s"
    |  val project="%s"
    |  val jarbasename="%s"
    |}
    |""".stripMargin.format(version, projectname, jarexe.split("[.]").head) )
  Seq(file)
}
