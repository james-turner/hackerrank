package HackerRank

import scala.util.Random

object CTCIMergeSort {

  // Complete the countInversions function below.
  def countInversions(arr: Array[Int]): Long = {
    // merge sort
    var ops = 0L
    def merge(posA: Int, posB: Int, a: Array[Int], b: Array[Int], accPos: Int, acc: Array[Int]): Array[Int] = {
      if(posA < a.length && posB < b.length) {
        if(a(posA) <= b(posB)) {
          acc(accPos) = a(posA)
          merge(posA + 1, posB, a, b, accPos+1, acc)
        } else {
          ops = ops + (a.length - posA)
          acc(accPos) = b(posB)
          merge(posA, posB + 1, a, b, accPos+1, acc)
        }
      } else {
        acc.take(accPos) ++ a.slice(posA, a.length) ++ b.slice(posB, b.length)
      }
    }

    def inner(arr: Array[Int]): Array[Int] = {
      if(arr.length > 1){
        val (a, b) = arr.splitAt(arr.length/2)
        merge(0, 0, inner(a), inner(b), 0, new Array(a.length+b.length))
      } else arr
    }
    inner(arr)
    ops
  }

  def main(args: Array[String]) {
//    val stdin = scala.io.StdIn
//
//    val t = stdin.readLine.trim.toInt
//
//    for (tItr <- 1 to t) {
//      val n = stdin.readLine.trim.toInt
//
//      val arr = stdin.readLine.split(" ").map(_.trim.toInt)
//      val result = countInversions(arr)
//
//      println(result)
//    }

    val total = (0 until 1000).foldLeft(0L){ case(acc,_) =>
      val time = System.nanoTime()
      val allTheInts = Array.fill(1000)(Random.nextInt(100))
      countInversions(allTheInts)
      val finish = System.nanoTime()
      acc + (finish - time)
    }
    println(s"Average time: ${(total / 1000)/100000}ms")

  }

}
