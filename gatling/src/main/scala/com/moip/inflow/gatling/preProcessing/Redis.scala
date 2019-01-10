package com.moip.inflow.gatling.preProcessing

import akka.actor.ActorSystem
import akka.util.Timeout
import redis._

import scala.concurrent.duration._

object Redis {

  implicit val system = ActorSystem("redis-client")
  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(2 seconds)

  def redisConnection(): RedisClient = {
    return RedisClient("redis", 6379)
  }

  def storeElementList(key: String, elementValue: String, basic: String, client: RedisClient): Unit = {
    try {
      client.sadd( key, elementValue + "&" + basic )
    }
    catch {
      case error: Exception => println(s"Add element was not complete using KEY [${key}], BASIC [${basic}] and ELEMENT [${elementValue}]: " + error)
    }
  }

  def closeConnection(client: RedisClient): Unit ={
    try{
      client.quit
    }
    catch {
      case error: Exception => println("Connection does not complete: " + error)
    }
  }
}