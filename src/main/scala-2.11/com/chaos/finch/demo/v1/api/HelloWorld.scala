package com.chaos.finch.demo.v1.api

import com.chaos.finch.demo.v1.model.Message
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._

/**
  * Created by zcfrank1st on 7/2/16.
  */
trait HelloWorld {
  def helloWorldApi = hello :+: world :+: helloworld

  def hello: Endpoint[Message] =
    get("hello" :: int("hello")) { (hello: Int) =>
      Ok(Message(hello + ""))
    }

  def world: Endpoint[Message] =
    get("world" :: param("world")) { (world: String) =>
      Ok(Message(world))
    }

  def helloworld: Endpoint[Message] =
    post("helloworld" :: body.as[Message]) {m: Message =>
      Ok(m)
    }
}

object HelloWorld extends HelloWorld
