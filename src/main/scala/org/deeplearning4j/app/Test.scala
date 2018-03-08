package org.deeplearning4j.app

import org.apache.spark.SparkContext, org.apache.spark.SparkConf

object Test {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("scala spark").setMaster(args(0))
    val sc = new SparkContext(conf)
    val i = List(1, 2, 3, 4, 5)
    val dataRDD = sc.parallelize(i)
    dataRDD.saveAsTextFile(args(1))
  }
}


 