package com.chaos.finch.demo.v1.apis

import com.chaos.finch.demo.v1.models.Message
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._
/**
  * Created by zcfrank1st on 7/2/16.
  */
trait Demo {
  def demoApi = demo

  def demo: Endpoint[Message] =
    get("demo" :: string("demo")) {(demo: String) =>
      Ok(Message(demo))
    }
}

object Demo extends Demo
