package com.chaos.finch.demo.util

import com.typesafe.config.Config

/**
  * Created by zcfrank1st on 7/2/16.
  */
object SlickGenerator extends App {
  val conf: Config = ConfigLoader.config

  slick.codegen.SourceCodeGenerator.main(
    Array(
      conf.getString("slickgen.slickDriver"),
      conf.getString("slickgen.jdbcDriver"),
      conf.getString("slickgen.url"),
      conf.getString("slickgen.outputFolder"),
      conf.getString("slickgen.pkg"),
      conf.getString("slickgen.user"),
      conf.getString("slickgen.password")
    )
  )
}
