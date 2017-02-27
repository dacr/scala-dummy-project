name := "ScalaDummyProject"

version := "2017.2.27"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-unchecked", "-deprecation" , "-feature", "-language:implicitConversions")

mainClass in assembly := Some("dummy.Dummy")

jarName in assembly := "dummy.jar"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

initialCommands in console := """
   |import dummy._
   |""".stripMargin


sourceGenerators in Compile +=  Def.task {
  val dir = (sourceManaged in Compile).value
  val projectVersion = version.value
  val projectName = name.value
  val jarbasename = (assemblyJarName in assembly).value.split("[.]").head
  val file = dir / "dummy" / "MetaInfo.scala"
  val sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  val buildate = sdf.format(new java.util.Date())
  IO.write(file,
  """package dummy 
    |object MetaInfo {
    |  val version="%s"
    |  val project="%s"
    |  val buildate="%s"
    |  val jarbasename="%s"
    |  val appcode="dummy"
    |}
    |""".stripMargin.format(projectVersion, projectName, buildate, jarbasename) )
  Seq(file)
}.taskValue



