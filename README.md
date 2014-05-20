A scala project skeleton, SBT based, with some SBT plugins enabled (eclipse and assembly). Everything needed to generate a single standalone executable jar, using scala language and eclipse as an optional IDE.

Edit (or create) the file ~/.sbt/0.13/plugins.sbt and add the following line to enable eclipse plugin :
```
addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")
```

So now everything is ready to use the skeleton :

```
$ sbt
> eclipse
> exit

$ sbt run

$ sbt test

$ sbt assembly

$ java -jar target/dummy.jar
```

So, Eclipse is optional, but if used all features are available for the scala language, if and only if you have installed scala eclipse plugin (http://www.scala-ide.org/).

