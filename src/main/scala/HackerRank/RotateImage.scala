package HackerRank

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object RotateImage {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.toInt
    val arr = ArrayBuffer[Array[Int]]()
    (0 until n).foreach {
      val a = stdin.readLine.split("\\s+").map(_.toInt)
      arr.addOne(a)
    }

    val result = rotateImage(arr.toArray)

    println(result)

  }

  // Complete the repeatedString function below.
  def rotateImage(a: Array[Array[Int]]): Unit = {

  }

}
