package com.weichuang.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.types._
import org.apache.spark.sql.{DataFrame, Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object SparkDemo2 {

  def main(args: Array[String]): Unit = {
    //提交的这个程序可以连接到spark集群
    val conf = new SparkConf().setAppName("SparkDemo2").setMaster("local[2]")
    //创建sparksql的连接（程序执行的入口）
    val sc = new SparkContext(conf)

    //将sparkcontext包装进而增强
    val sqlContext = new SQLContext(sc)
    val lines: RDD[String] = sc.textFile("hdfs://hadoop101:8020/etl/")
    val bRDD: RDD[Row] = lines.map(line => {
      val fields = line.split(",")
      val id = fields(0).toLong
      val name = fields(1)
      val age = fields(2).toInt
      Row(id, name, age)
    })
    //结果类型，其实就是表头，用于描述DataFrame
    val sch: StructType = StructType(List(
      StructField("id", LongType, true),
      StructField("name", StringType, true),
      StructField("age", IntegerType, true)
    ))
    val df: DataFrame = sqlContext.createDataFrame(bRDD,sch)

    //该boyRDD装的是Person类型的数据，有 shcma信息，但是还是一个RDD
    //将RDD转换成DataFrame
    //导入隐式转换
    import sqlContext.implicits._
//    val df: DataFrame = boyRDD.toDF

    df.registerTempTable("t_person");
    val res = sqlContext.sql("select * from t_person")
    res.show()
    sc.stop()

  }
}
