import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._

object ApplicationBuild extends Build {

  val appName         = "niyama"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm
  )

// Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory
def customLessEntryPoints(base: File): PathFinder = (
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "responsive.less") +++
      (base / "app" / "assets" / "stylesheets" * "*.less")
    )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
    Play2WarKeys.servletVersion := "3.0",
    lessEntryPoints <<= baseDirectory(customLessEntryPoints),
    javascriptEntryPoints <<= baseDirectory(base =>
              base / "app" / "assets" / "javascripts" ** "*.js"
                  )
  ).settings(Play2WarPlugin.play2WarSettings: _*)

}
