name := """mock-server-gatling"""
organization := "com.example"
run / fork := true

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava).disablePlugins(PlayLayoutPlugin)

scalaVersion := "2.13.6"

libraryDependencies += guice
