package com.moip.inflow.gatling

import com.moip.inflow.gatling.simulation.{CreateNewContact, GetListContacts}
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {

  val props = new GatlingPropertiesBuilder
  props.dataDirectory("jar")
  props.simulationClass(classOf[CreateNewContact].getName)
  props.sourcesDirectory("./src/main/scala")
  props.dataDirectory("/gatling-jornadas/results")
  props.dataDirectory("/gatling-jornadas/gatling/src/main/resources/data")
  Gatling.fromMap(props.build)
  sys.exit()
}