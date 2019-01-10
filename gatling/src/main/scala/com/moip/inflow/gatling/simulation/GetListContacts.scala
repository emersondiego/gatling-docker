package com.moip.inflow.gatling.simulation

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class GetListContacts extends Simulation {
  val httpProtocol = http
    .baseURL("https://api-de-tarefas.herokuapp.com")
    .acceptHeader("*/*")

  val scenario_post_create_account = scenario("GET List Contacts")
    .exec(http("GET List Contacts")
      .get("/contacts")
      .check(status.is(200)))

  setUp(
    scenario_post_create_account.inject(
      constantUsersPerSec(3) during(10 seconds) // injeta 3 usuarios a cada segundo num periodo de 10 segundos
    )
  ).protocols(httpProtocol)
}
