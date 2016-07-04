package com.chaos.finch.demo.v1.service

import com.chaos.finch.demo.util.{ConfigModule, DatabaseAccessModule}
import com.chaos.finch.demo.v1.model.gen.Tables.EtlTaskCfg
import slick.lifted.TableQuery
import slick.dbio.DBIO
import slick.driver.MySQLDriver.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
/**
  * Created by zcfrank1st on 7/2/16.
  */

object DemoDao extends App with DatabaseAccessModule with ConfigModule {
  val etl: TableQuery[EtlTaskCfg] = TableQuery[EtlTaskCfg]

  val sql = etl.filter(p => p.taskId > 0).result

//  val result = databasePool.run(DBIO.seq(
//    res
//  ))
//
//  println(result.value)

  val result = databasePool.run(sql)

//  result onComplete {
//    case r => println(r)
//  }
  val r = Await.result(result, Duration.Inf)


}
