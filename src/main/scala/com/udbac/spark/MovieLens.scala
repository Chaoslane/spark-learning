package com.udbac.spark

import breeze.util.partition
import org.apache.spark.ml.recommendation.ALS.Rating
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.recommendation.ALS
/**
  * Created by root on 2017/2/9.
  */
object MovieLens {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Spark Movie").setMaster("local")
    val sparkContext = new SparkContext(conf)

    val rawData = sparkContext.textFile("ml-100k/u.data")
    val rawRatings = rawData.map(_.split("\t").take(3))

    val ratings = rawRatings.map({
      case Array(user, movie, rating) => Rating(user.toInt, movie.toInt, rating.toFloat)
    })


  }
}
