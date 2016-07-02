package com.chaos.finch.demo

import com.chaos.finch.demo.v1.Api
import com.twitter.finagle.Http
import com.twitter.util.Await
import com.typesafe.scalalogging.StrictLogging


/**
  * Created by zcfrank1st on 7/1/16.
  */
object Main extends App with StrictLogging {
  logger.info("server start !!!")
  Await.ready(
    Http
      .server
      .serve(":8080", Api.apiService)
  )
}
