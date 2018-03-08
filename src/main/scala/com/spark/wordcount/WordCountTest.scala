package org.deeplearning4j.app

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import com.typesafe.config._

object WordCountTest {
  def main(args: Array[String]) {
   //val appConf = ConfigFactory.load()
   val conf = new SparkConf().
      setAppName("Word Count").
      setMaster("local")
    val sc = new SparkContext(conf)
    val inputPath = args(0)
    val outputPath = args(1)
      
    val wc = sc.textFile(inputPath).
      flatMap(rec => rec.split(" ")).
      map(rec => (rec, 1)).
      reduceByKey((acc, value) => acc + value)
      
    wc.saveAsTextFile(outputPath)
  }
}