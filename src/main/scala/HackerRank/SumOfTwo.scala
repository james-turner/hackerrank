package HackerRank

import scala.collection.mutable.ArrayBuffer

object SumOfTwo {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val v = stdin.readLine.toInt
    val a = stdin.readLine.split("\\s+").map(_.toInt)
    val b = stdin.readLine.split("\\s+").map(_.toInt)

    val result = sumOfTwo(a, b, v)

    println(result)

  }

  // Complete the repeatedString function below.
  def sumOfTwo(a: Array[Int], b: Array[Int], v: Int): Boolean = {
    val aSet = a.toSet
    b.foreach(bs => {
      if(aSet.contains(v - bs)) return true
    })
    false
  }

}
