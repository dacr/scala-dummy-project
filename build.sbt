name := "scala-dummy-project"
organization := "org.dummy"
version := "2017.10.02"

scalaVersion := "2.12.7"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature", "-language:implicitConversions")

mainClass in assembly := Some("dummy.Dummy")
assemblyJarName := "dummy.jar"

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/junitresults")

libraryDependencies ++= Seq(
  "ch.qos.logback" %  "logback-classic" % "1.2.3",
  "org.scalatest"  %% "scalatest"       % "3.0.5" % "test"
)

initialCommands in console := """
   |import dummy._
   |""".stripMargin


sourceGenerators in Compile +=  Def.task {
  val dir = (sourceManaged in Compile).value
  val jarbasename = (assemblyJarName in assembly).value.split("[.]").head
  val file = dir / "dummy" / "ProjectMetaInfo.scala"
  val fiso = java.time.format.DateTimeFormatter.ISO_INSTANT
  val buildate = java.time.ZonedDateTime.now().format(fiso)
  IO.write(file,
  """package dummy
    |object ProjectMetaInfo {
    |  val name="%s"
    |  val version="%s"
    |  val buildate="%s"
    |  val jarbasename="%s"
    |  val appcode="dummy"
    |}
    |""".stripMargin.format(name.value, version.value, buildate, jarbasename) )
  Seq(file)
}.taskValue
