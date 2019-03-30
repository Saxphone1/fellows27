package com.weichuang.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

object SparkDemo1 {

  def main(args: Array[String]): Unit = {
    //提交的这个程序可以连接到spark集群
    val conf = new SparkConf().setAppName("SparkDemo1").setMaster("local[2]")
    //创建sparksql的连接（程序执行的入口）
    val sc = new SparkContext(conf)

    //将sparkcontext包装进而增强
    val sqlContext = new SQLContext(sc)
    val lines: RDD[String] = sc.textFile("hdfs://hadoop101:8020/etl/")
    val boyRDD = lines.map(line=>{
      val fields = line.split(",")
      val id = fields(0).toLong
      val name = fields(1)
      val age = fields(2).toInt
      Person(id,name,age)
    })
    //该boyRDD装的是Person类型的数据，有 shcma信息，但是还是一个RDD
    //将RDD转换成DataFrame
    //导入隐式转换
    import sqlContext.implicits._
    val df: DataFrame = boyRDD.toDF

    df.registerTempTable("t_person");
    val res = sqlContext.sql("select * from t_person")
    res.show()
    sc.stop()

  }
}

case class Person(id:Long,name:String,age:Int)
