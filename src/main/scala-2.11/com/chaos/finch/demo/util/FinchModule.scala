package com.chaos.finch.demo.util

import com.chaos.finch.demo.v1.Api
import com.twitter.finagle.Http
import com.twitter.util.Await

/**
  * Created by zcfrank1st on 7/4/16.
  */
trait FinchModule {
  self: com.twitter.app.App =>
  premain {
    println("[Finch] server is starting ...")

    val server = Http.serve(ConfigLoader.config.getString(ConfigLoader.env + ".http.port"), Api.apiService)
    onExit {
      server.close()
    }
    Await.ready(
      server
    )
  }
}
