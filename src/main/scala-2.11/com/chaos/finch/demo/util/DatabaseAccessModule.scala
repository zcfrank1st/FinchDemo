package com.chaos.finch.demo.util

import java.util.Properties

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import slick.jdbc.JdbcBackend.Database
/**
  * Created by zcfrank1st on 7/2/16.
  */
trait DatabaseAccessModule {
  val databasePool = {
    val conf = ConfigLoader.config
    val env = ConfigLoader.env

    val datasourceConfig = new HikariConfig()
    datasourceConfig.setPoolName("hikari-pool")
    datasourceConfig.setDataSourceClassName(conf.getString(env + ".db.dataSourceClassName"))
    datasourceConfig.setMaximumPoolSize(conf.getInt(env + ".db.maximumPoolSize"))
    datasourceConfig.setMinimumIdle(conf.getInt(env + ".db.minimumIdle"))
    val properties = new Properties()
    properties.setProperty("url", conf.getString(env + ".db.url"))
    properties.setProperty("user", conf.getString(env + ".db.user"))
    properties.setProperty("password", conf.getString(env + ".db.password"))
    datasourceConfig.setDataSourceProperties(properties)

    val ds = new HikariDataSource(datasourceConfig)
    Database.forDataSource(ds)
  }
}
