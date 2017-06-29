scalaVersion := "2.11.11"

enablePlugins(ScalaNativePlugin)

name := "scalanativeclitest"

organization := "sh.den"

version := "0.1.0"

publishArtifact in Compile := true

publishArtifact in Test := false

homepage := Some(url("https://github.com/densh/scala-native-cli-test"))

startYear := Some(2017)

licenses := Seq(
  "BSD-like" -> url("http://www.scala-lang.org/downloads/license.html"))

developers += Developer(
  email = "denys.shabalin@epfl.ch",
  id = "densh",
  name = "Denys Shabalin",
  url = url("http://den.sh")
)

scmInfo := Some(
  ScmInfo(
	browseUrl = url("https://github.com/densh/scala-native-cli-test"),
	connection = "scm:git:git@github.com:densh/scala-native-cli-test.git"
  ))

pomExtra := (
  <issueManagement>
	<system>GitHub Issues</system>
	<url>https://github.com/densh/scala-native-cli-test/issues</url>
  </issueManagement>
)

publishMavenStyle := true

pomIncludeRepository := { x =>
  false
}

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
	Some("snapshots" at nexus + "content/repositories/snapshots")
  else
	Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

credentials ++= {
  for {
	realm    <- sys.env.get("MAVEN_REALM")
	domain   <- sys.env.get("MAVEN_DOMAIN")
	user     <- sys.env.get("MAVEN_USER")
	password <- sys.env.get("MAVEN_PASSWORD")
  } yield {
	Credentials(realm, domain, user, password)
  }
}.toSeq
