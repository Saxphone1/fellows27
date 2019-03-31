package com.weichuang.spark

import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

object SparkStreamingWordCount1 {
  /**
    * 第一个参数：聚合的key，就是单词
    * 第二个参数：当前批次产生批次该单词在每一个分区出现的次数
    * 第三个参数：初始值或累加的中间结果
    */
  val updateFunc = (iter: Iterator[(String, Seq[Int], Option[Int])]) => {
    iter.map(t => (t._1, t._2.sum + t._3.getOrElse(0)))//(hello , 3+3)
//    iter.map{ case(x, y, z) => (x, y.sum + z.getOrElse(0))}
  }


  def main(args: Array[String]): Unit = {
    //离线任务是创建SparkContext，现在要实现实时计算，用StreamingContext
    val conf = new SparkConf().setAppName("SparkStreamingWordCount1").setMaster("local[2]")
    val sc = new SparkContext(conf)
    //StreamingContext是对SparkContext的包装，包了一层就增加了实时的功能
    //第二个参数是小批次产生的时间间隔
    val ssc = new StreamingContext(sc, Seconds(5))
    ssc.checkpoint("./ck")
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop101", 8888)

    val word: DStream[String] = lines.flatMap(_.split(" "))// (a,b,c,d) (e,d,f)
    //(a b c d e f g )
    val value: DStream[(String, Int)] = word.map(x => {
      (x, 1)
    })
    val res: DStream[(String, Int)] = value.updateStateByKey(updateFunc,new HashPartitioner(ssc.sparkContext.defaultParallelism),true)
    //(a,1)(b,1)(b,1)
    res.print();
    //启动sparksteaming程序
    ssc.start()
    //等待优雅的退出
    ssc.awaitTermination()
  }

}
