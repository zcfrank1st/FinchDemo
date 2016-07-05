package com.chaos.finch.demo.v1.service

import com.chaos.finch.demo.util.DatabaseAccessModule
import com.chaos.finch.demo.v1.model.{Message, Message1}
import com.chaos.finch.demo.v1.model.gen.Tables.Demo
import slick.lifted.TableQuery
import slick.dbio.DBIO
import slick.driver.MySQLDriver.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
/**
  * Created by zcfrank1st on 7/2/16.
  */

trait DemoService {
self: DatabaseAccessModule =>

  def demoService(): Message1 = {
    val etl: TableQuery[Demo] = TableQuery[Demo]

    val sql = etl.filter(p => p.id > 0).result

    //  val result = databasePool.run(DBIO.seq(
    //    res
    //  ))
    //
    //  println(result.value)

    val result = self.databasePool.run(sql)

    //  result onComplete {
    //    case r => println(r)
    //  }
    val r = Await.result(result, Duration.Inf)

    Message1(r.toList)
  }
}
