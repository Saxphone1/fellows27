package com.weichuang.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}

object SparkWordCount {

  def main(args: Array[String]): Unit = {
    //提交的这个程序可以连接到spark集群
    //是spark2.x SQL执行的入口
    val session = SparkSession.builder()
      .appName("SparkWordCount")
      .master("local[*]")
      .getOrCreate()

    val lines: Dataset[String] = session.read.textFile("hdfs://hadoop101:8020/etl/")
    // hello weichuang
    // hello hadoop
    // hello spark
    // hello weichuang
    // hello hadoop
    // hello spark
    import session.implicits._
    val wordRDD: Dataset[String] = lines.flatMap(_.split(" "))
//    (hello,weichuang)
//    hello
//    hello
//    hello
    wordRDD.createTempView("t_wordcount")
    val res = session.sql("select value,count(*) counts from t_wordcount group by value order by counts")
    res.show()
    session.stop()
  }
}
