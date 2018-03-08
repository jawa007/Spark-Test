package com.spark.variables

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Broadcast {
  def main(args: Array[String]): Unit = {
     val conf = new SparkConf().setAppName("scala spark").setMaster("local")
     val sc = new SparkContext(conf)
     val broadcastVar = sc.broadcast(Array(1, 2, 3))
     println("====>"+broadcastVar.value)
  }
}