package com.chaos.finch.demo.v1.model

/**
  * Created by zcfrank1st on 7/5/16.
  */
case class Demo1 (id: Int, name: Option[String], age: Int)

object Demo1 {
  def option2string(value: Option[String]): String = {
    value.getOrElse("")
  }
}
