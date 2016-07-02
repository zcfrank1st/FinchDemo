package com.chaos.finch.demo.v1

import com.chaos.finch.demo.v1.api.{Demo, HelloWorld}
import com.chaos.finch.demo.v1.handler.ErrorHandler
import com.twitter.finagle.Service
import com.twitter.finagle.http.filter.ExceptionFilter
import com.twitter.finagle.http.{Request, Response}

import io.finch._
import io.finch.circe._
import io.circe.generic.auto._

/**
  * Created by zcfrank1st on 7/2/16.
  */
trait Api {
  private def api = HelloWorld.helloWorldApi :+: Demo.demoApi

  def apiService: Service[Request, Response] = ExceptionFilter andThen api.handle(ErrorHandler.apiErrorHandler).toService
}

object Api extends Api
