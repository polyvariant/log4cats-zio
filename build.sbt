ThisBuild / tlBaseVersion := "0.1"
ThisBuild / organization := "org.polyvariant"
ThisBuild / organizationName := "Polyvariant"
ThisBuild / startYear := Some(2023)
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(tlGitHubDev("majk-p", "Michał Pawlik"))
ThisBuild / tlSonatypeUseLegacyHost := false

val Scala213 = "2.13.10"
val Scala3 = "3.3.0"

ThisBuild / scalaVersion := Scala213

ThisBuild / tlFatalWarnings := false
ThisBuild / tlFatalWarningsInCi := false

lazy val root = project
  .in(file("."))
  .settings(
    name := "log4cats-zio",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "log4cats-core" % "2.6.0",
      "dev.zio" %% "zio" % "2.0.14",
    ),
  )
