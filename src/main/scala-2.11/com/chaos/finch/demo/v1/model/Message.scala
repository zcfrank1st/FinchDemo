package com.chaos.finch.demo.v1.model

import com.chaos.finch.demo.v1.model.gen.Tables.DemoRow

/**
  * Created by zcfrank1st on 7/2/16.
  */
final case class Message(message: String)

final case class Message1(list: List[DemoRow])
