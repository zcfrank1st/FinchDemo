package com.chaos.finch.demo.v1.model.gen
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  import slick.collection.heterogeneous._
  import slick.collection.heterogeneous.syntax._
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Demo.schema ++ EtlTaskCfg.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table Demo
   *  @param id Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey
   *  @param name Database column name SqlType(VARCHAR), Length(25,true), Default(Some())
   *  @param age Database column age SqlType(INT) */
  case class DemoRow(id: Int, name: Option[String] = Some(""), age: Int)
  /** GetResult implicit for fetching DemoRow objects using plain SQL queries */
  implicit def GetResultDemoRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[DemoRow] = GR{
    prs => import prs._
    DemoRow.tupled((<<[Int], <<?[String], <<[Int]))
  }
  /** Table description of table demo. Objects of this class serve as prototypes for rows in queries. */
  class Demo(_tableTag: Tag) extends Table[DemoRow](_tableTag, "demo") {
    def * = (id, name, age) <> (DemoRow.tupled, DemoRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), name, Rep.Some(age)).shaped.<>({r=>import r._; _1.map(_=> DemoRow.tupled((_1.get, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(INT UNSIGNED), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name SqlType(VARCHAR), Length(25,true), Default(Some()) */
    val name: Rep[Option[String]] = column[Option[String]]("name", O.Length(25,varying=true), O.Default(Some("")))
    /** Database column age SqlType(INT) */
    val age: Rep[Int] = column[Int]("age")
  }
  /** Collection-like TableQuery object for table Demo */
  lazy val Demo = new TableQuery(tag => new Demo(tag))

  /** Row type of table EtlTaskCfg */
  type EtlTaskCfgRow = HCons[Option[Int],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Char],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[Boolean],HCons[Option[String],HCons[java.sql.Timestamp,HCons[Option[String],HCons[Option[java.sql.Timestamp],HCons[Option[Boolean],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[String],HCons[Option[Int],HCons[Option[Int],HCons[Option[Boolean],HCons[Option[String],HCons[Option[Byte],HNil]]]]]]]]]]]]]]]]]]]]]]]]]]]
  /** Constructor for EtlTaskCfgRow providing default values if available in the database schema. */
  def EtlTaskCfgRow(taskId: Option[Int] = None, taskName: Option[String] = None, resource: Option[String] = None, command: Option[String] = None, logFile: Option[String] = None, taskGroupId: Option[Int] = None, cycle: Option[Char] = None, prioLvl: Option[Boolean] = None, ifRecall: Option[Boolean] = None, ifWait: Option[Boolean] = None, ifPre: Option[Boolean] = None, ifEnable: Option[Boolean] = None, addUser: Option[String] = None, addTime: java.sql.Timestamp, updateUser: Option[String] = None, updateTime: Option[java.sql.Timestamp] = None, `type`: Option[Boolean] = None, offset: Option[String] = None, freq: Option[String] = None, owner: Option[String] = None, waitCode: Option[String] = None, recallCode: Option[String] = None, timeout: Option[Int] = None, recallInterval: Option[Int] = None, recallLimit: Option[Boolean] = None, successCode: Option[String] = None, concurrency: Option[Byte] = None): EtlTaskCfgRow = {
    taskId :: taskName :: resource :: command :: logFile :: taskGroupId :: cycle :: prioLvl :: ifRecall :: ifWait :: ifPre :: ifEnable :: addUser :: addTime :: updateUser :: updateTime :: `type` :: offset :: freq :: owner :: waitCode :: recallCode :: timeout :: recallInterval :: recallLimit :: successCode :: concurrency :: HNil
  }
  /** GetResult implicit for fetching EtlTaskCfgRow objects using plain SQL queries */
  implicit def GetResultEtlTaskCfgRow(implicit e0: GR[Option[Int]], e1: GR[Option[String]], e2: GR[Option[Char]], e3: GR[Option[Boolean]], e4: GR[java.sql.Timestamp], e5: GR[Option[java.sql.Timestamp]], e6: GR[Option[Byte]]): GR[EtlTaskCfgRow] = GR{
    prs => import prs._
    <<?[Int] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Char] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[Boolean] :: <<?[String] :: <<[java.sql.Timestamp] :: <<?[String] :: <<?[java.sql.Timestamp] :: <<?[Boolean] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[String] :: <<?[Int] :: <<?[Int] :: <<?[Boolean] :: <<?[String] :: <<?[Byte] :: HNil
  }
  /** Table description of table etl_task_cfg. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class EtlTaskCfg(_tableTag: Tag) extends Table[EtlTaskCfgRow](_tableTag, "etl_task_cfg") {
    def * = taskId :: taskName :: resource :: command :: logFile :: taskGroupId :: cycle :: prioLvl :: ifRecall :: ifWait :: ifPre :: ifEnable :: addUser :: addTime :: updateUser :: updateTime :: `type` :: offset :: freq :: owner :: waitCode :: recallCode :: timeout :: recallInterval :: recallLimit :: successCode :: concurrency :: HNil

    /** Database column task_id SqlType(INT), Default(None) */
    val taskId: Rep[Option[Int]] = column[Option[Int]]("task_id", O.Default(None))
    /** Database column task_name SqlType(VARCHAR), Length(25,true), Default(None) */
    val taskName: Rep[Option[String]] = column[Option[String]]("task_name", O.Length(25,varying=true), O.Default(None))
    /** Database column resource SqlType(VARCHAR), Length(25,true), Default(None) */
    val resource: Rep[Option[String]] = column[Option[String]]("resource", O.Length(25,varying=true), O.Default(None))
    /** Database column command SqlType(VARCHAR), Length(255,true), Default(None) */
    val command: Rep[Option[String]] = column[Option[String]]("command", O.Length(255,varying=true), O.Default(None))
    /** Database column log_file SqlType(VARCHAR), Length(255,true), Default(None) */
    val logFile: Rep[Option[String]] = column[Option[String]]("log_file", O.Length(255,varying=true), O.Default(None))
    /** Database column task_group_id SqlType(INT), Default(None) */
    val taskGroupId: Rep[Option[Int]] = column[Option[Int]]("task_group_id", O.Default(None))
    /** Database column cycle SqlType(VARCHAR), Default(None) */
    val cycle: Rep[Option[Char]] = column[Option[Char]]("cycle", O.Default(None))
    /** Database column prio_lvl SqlType(BIT), Default(None) */
    val prioLvl: Rep[Option[Boolean]] = column[Option[Boolean]]("prio_lvl", O.Default(None))
    /** Database column if_recall SqlType(BIT), Default(None) */
    val ifRecall: Rep[Option[Boolean]] = column[Option[Boolean]]("if_recall", O.Default(None))
    /** Database column if_wait SqlType(BIT), Default(None) */
    val ifWait: Rep[Option[Boolean]] = column[Option[Boolean]]("if_wait", O.Default(None))
    /** Database column if_pre SqlType(BIT), Default(None) */
    val ifPre: Rep[Option[Boolean]] = column[Option[Boolean]]("if_pre", O.Default(None))
    /** Database column if_enable SqlType(BIT), Default(None) */
    val ifEnable: Rep[Option[Boolean]] = column[Option[Boolean]]("if_enable", O.Default(None))
    /** Database column add_user SqlType(VARCHAR), Length(125,true), Default(None) */
    val addUser: Rep[Option[String]] = column[Option[String]]("add_user", O.Length(125,varying=true), O.Default(None))
    /** Database column add_time SqlType(TIMESTAMP) */
    val addTime: Rep[java.sql.Timestamp] = column[java.sql.Timestamp]("add_time")
    /** Database column update_user SqlType(VARCHAR), Length(125,true), Default(None) */
    val updateUser: Rep[Option[String]] = column[Option[String]]("update_user", O.Length(125,varying=true), O.Default(None))
    /** Database column update_time SqlType(TIMESTAMP), Default(None) */
    val updateTime: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("update_time", O.Default(None))
    /** Database column type SqlType(BIT), Default(None)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[Boolean]] = column[Option[Boolean]]("type", O.Default(None))
    /** Database column offset SqlType(VARCHAR), Length(30,true), Default(None) */
    val offset: Rep[Option[String]] = column[Option[String]]("offset", O.Length(30,varying=true), O.Default(None))
    /** Database column freq SqlType(VARCHAR), Length(30,true), Default(None) */
    val freq: Rep[Option[String]] = column[Option[String]]("freq", O.Length(30,varying=true), O.Default(None))
    /** Database column owner SqlType(VARCHAR), Length(25,true), Default(None) */
    val owner: Rep[Option[String]] = column[Option[String]]("owner", O.Length(25,varying=true), O.Default(None))
    /** Database column wait_code SqlType(VARCHAR), Length(20,true), Default(None) */
    val waitCode: Rep[Option[String]] = column[Option[String]]("wait_code", O.Length(20,varying=true), O.Default(None))
    /** Database column recall_code SqlType(VARCHAR), Length(20,true), Default(None) */
    val recallCode: Rep[Option[String]] = column[Option[String]]("recall_code", O.Length(20,varying=true), O.Default(None))
    /** Database column timeout SqlType(INT), Default(None) */
    val timeout: Rep[Option[Int]] = column[Option[Int]]("timeout", O.Default(None))
    /** Database column recall_interval SqlType(INT), Default(None) */
    val recallInterval: Rep[Option[Int]] = column[Option[Int]]("recall_interval", O.Default(None))
    /** Database column recall_limit SqlType(BIT), Default(None) */
    val recallLimit: Rep[Option[Boolean]] = column[Option[Boolean]]("recall_limit", O.Default(None))
    /** Database column success_code SqlType(VARCHAR), Length(20,true), Default(None) */
    val successCode: Rep[Option[String]] = column[Option[String]]("success_code", O.Length(20,varying=true), O.Default(None))
    /** Database column concurrency SqlType(TINYINT), Default(None) */
    val concurrency: Rep[Option[Byte]] = column[Option[Byte]]("concurrency", O.Default(None))
  }
  /** Collection-like TableQuery object for table EtlTaskCfg */
  lazy val EtlTaskCfg = new TableQuery(tag => new EtlTaskCfg(tag))
}
