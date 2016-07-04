package com.chaos.finch.demo

import com.chaos.finch.demo.util.{ConfigModule, FinchModule}
import com.twitter.server.TwitterServer


/**
  * Created by zcfrank1st on 7/1/16.
  */
object Main extends TwitterServer with FinchModule with ConfigModule