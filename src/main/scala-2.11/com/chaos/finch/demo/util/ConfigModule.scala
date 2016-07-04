package com.chaos.finch.demo.util

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by zcfrank1st on 7/2/16.
  */
trait ConfigModule {
  val config: Config = ConfigFactory.load()
  val env: String = sys.env("env")
}

object ConfigLoader extends ConfigModule