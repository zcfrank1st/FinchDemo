package com.chaos.finch.demo.v1.api

import com.chaos.finch.demo.util.{ConfigModule, DatabaseAccessModule}
import com.chaos.finch.demo.v1.model.Message
import com.chaos.finch.demo.v1.service.DemoService
import io.finch._
import io.finch.circe._
import io.circe.generic.auto._
/**
  * Created by zcfrank1st on 7/2/16.
  */
trait Demo {
  self: DemoService =>
  def demoApi = demoController

  def demoController: Endpoint[Message] =
    get("demo" :: string("demo")) {(demo: String) =>
      Ok(self.demoService())
    }
}

object DemoApi extends Demo with DemoService with DatabaseAccessModule
