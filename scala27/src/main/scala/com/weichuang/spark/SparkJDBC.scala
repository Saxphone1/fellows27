package com.weichuang.spark

import java.util.Properties

import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SparkJDBC {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("JdbcDataSource")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._
    val sDf: DataFrame = spark.read.format("jdbc").options(
      Map("url" -> "jdbc:mysql://hadoop101:3306/test",
        "driver" -> "com.mysql.jdbc.Driver",
        "dbtable" -> "spark",
        "user" -> "root",
        "password" -> "000000")
    ).load()

    //sDf.printSchema()

//    sDf.show()

//        val filtered: Dataset[Row] = sDf.filter(r => {
//          r.getAs[Int]("id") <= 3
//        })
//        filtered.show()

//    lambda表达式
    val r = sDf.filter($"id" <= 3)
    //val r = logs.where($"age" <= 13)
    val reslut: DataFrame = r.select($"id", $"name")

//    reslut.show()
    val props = new Properties()
    props.put("user","root")
    props.put("password","000000")
//    reslut.write.mode("append").jdbc("jdbc:mysql://hadoop101:3306/test", "spark", props)

//    reslut.write.json("hdfs://hadoop101:8020/etl/json")
    reslut.write.json("D://json1")


  }
}
