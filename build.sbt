import AssemblyKeys._

seq(assemblySettings: _*)

name := "ScalaDummyProject"

version := "v2015-01-27"

scalaVersion := "2.11.5"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature")

mainClass in assembly := Some("dummy.Dummy")

jarName in assembly := "dummy.jar"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.+" % "test"

libraryDependencies += "junit" % "junit" % "4.+" % "test"

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
