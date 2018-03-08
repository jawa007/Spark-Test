package org.deeplearning4j.app

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CreateRDDFromLocalFiles {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("scala spark").setMaster("local")
    val sc = new SparkContext(conf)
    val dataRDD = sc.textFile("file:///F:/Spark/scala-spark-examples-master/src/main/scala/org/deeplearning4j/app/data.txt")
    dataRDD.map(rec => rec.toInt).reduce((acc, value) => acc + value)
    dataRDD.foreach(println)//View the record
    var cnt = dataRDD.count() //Count the record
    println("Count===>" + cnt);
    var total = dataRDD.map(rec => rec.toInt).reduce((acc, value) => acc + value)
    println("total==>" + total);
  }
}