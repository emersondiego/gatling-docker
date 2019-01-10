package com.moip.inflow.gatling.simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import scala.util.Random

class CreateNewContact extends Simulation {

  val cpf = CpfGeneration

  val feederCsv = Iterator.continually(Map("cpf" -> cpf.create(),"email" -> (Random.alphanumeric.take(20).mkString + "@foo.com")))

  //Header
  val sessionHeaders = Map(
    "Content-Type" -> "application/json",
    "Accept" -> "application/vnd.tasksmanager.v2")

  val httpProtocol = http
    .baseURL("https://api-de-tarefas.herokuapp.com")
    .acceptHeader("*/*")

  val scenario_post_create_account = scenario("Create Contacts")
    .feed(feederCsv)
    .exec(http("Create Contacts")
      .post("/contacts")
      .headers(sessionHeaders)
      .body(ElFileBody("bodies/create_contacts.json")).asJSON
      .check(status.is(201)))

  setUp(
    scenario_post_create_account.inject(
      constantUsersPerSec(1) during(5 seconds)
    )
  ).protocols(httpProtocol)
}