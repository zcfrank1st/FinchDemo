package com.chaos.finch.demo

import com.chaos.finch.demo.v1.Api
import com.twitter.finagle.Http
import com.twitter.server.TwitterServer
import com.twitter.util.Await


/**
  * Created by zcfrank1st on 7/1/16.
  */
object Main extends TwitterServer {
  def main() {
    val server = Http.serve(":8080", Api.apiService)

    onExit {
      server.close()
    }

    Await.ready(
      server
    )
  }
}
