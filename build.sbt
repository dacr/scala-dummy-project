import AssemblyKeys._

seq(assemblySettings: _*)

name := "ScalaDummyProject"

version := "0.1.3"

scalaVersion := "2.9.2"

scalacOptions ++= Seq("-unchecked", "-deprecation")

mainClass in assembly := Some("dummy.Dummy")

jarName in assembly := "dummy.jar"

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"


sourceGenerators in Compile <+= 
 (sourceManaged in Compile, version, name, jarName in assembly) map {
  (dir, version, projectname, jarexe) =>
  val file = dir / "dummy" / "MetaInfo.scala"
  IO.write(file,
  """package dummy
    |object MetaInfo { 
    |  val version="%s"
    |  val projectName="%s"
    |  val jarbasename="%s"
    |}
    |""".stripMargin.format(version, projectname, jarexe.split("[.]").head) )
  Seq(file)
}
