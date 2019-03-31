package com.weichuang.spark

import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Milliseconds, Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object SparkStreamingWordCount {

  def main(args: Array[String]): Unit = {
    //离线任务是创建SparkContext，现在要实现实时计算，用StreamingContext
    val conf = new SparkConf().setAppName("SparkStreamingWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //StreamingContext是对SparkContext的包装，包了一层就增加了实时的功能
    //第二个参数是小批次产生的时间间隔
    val ssc = new StreamingContext(sc, Seconds(5))
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop101", 8888)

    val word: DStream[String] = lines.flatMap(_.split(" "))// (a,b,c,d) (e,d,f)
    //(a b c d e f g )
    val value: DStream[(String, Int)] = word.map(x => {
      (x, 1)
    })
    val res: DStream[(String, Int)] = value.reduceByKey(_ + _)
    //(a,1)(b,1)(b,1)
    res.print();
    //启动sparksteaming程序
    ssc.start()
    //等待优雅的退出
    ssc.awaitTermination()
  }

}
