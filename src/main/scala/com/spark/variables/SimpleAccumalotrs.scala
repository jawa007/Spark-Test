package com.spark.variables

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object SimpleAccumalotrs {
  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("scala spark").setMaster("local")
    val sc = new SparkContext(conf)
    val accum=sc.accumulator(0, "myAccumalator")
    sc.parallelize(Array(1, 2, 3, 4)).foreach(x => accum.add(x))
    println(accum.value)
  }
  
}