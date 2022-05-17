package HackerRank

import java.io.PrintWriter

import scala.collection.mutable

object BeautifulPairs extends App {

  def beautifulPairs(A: Array[Int], B: Array[Int]): Int = {
    val aLen = A.length
    val bLen = B.length
    val commonLen = A.toSet.union(B.toSet).size
    val bMap = B.groupBy(identity).map(_._2.length)

    1
  }

  println(beautifulPairs(Array(1,2,3,4), Array(1,2,4,4)))

}
