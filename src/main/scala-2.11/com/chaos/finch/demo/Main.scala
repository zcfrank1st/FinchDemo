package com.chaos.finch.demo

import com.twitter.finagle.Http
import com.twitter.util.Await
import com.typesafe.scalalogging.{LazyLogging, StrictLogging}
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._
/**
  * Created by zcfrank1st on 7/1/16.
  */
object Main extends App with StrictLogging {

  case class Message(message: String)

  val time: Endpoint[Message] =
    post("time" :: body.as[Message]) { l: Message =>
      Ok(Message(l.message + "111"))
    }

  val test: Endpoint[Message] =
    get("test" :: string("value")) { (value: String) =>
      Ok(Message(value))
    }

  logger.info("server start !!!")

  Await.ready(
    Http
      .server
      .serve(":8081", (test :+: time).toService)
  )
}
