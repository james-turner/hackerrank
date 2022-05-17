package HackerRank

import scala.annotation.tailrec
import scala.collection.mutable

object SherlockAndAnagrams {

  def buildNChoose2(n: Int) = {
    @tailrec
    def inner(pos: Int, acc: Map[Int,Int]): Map[Int,Int] = {
      if(pos > n) acc
      else inner(pos+1, acc + (pos->((pos-1)+acc(pos-1))))
    }
    inner(3, Map(2->1))
  }

  // Complete the sherlockAndAnagrams function below.
  def sherlockAndAnagrams(s: String): Int = {
    val m = mutable.Map[String, Int]()
    def inner(start: Int, end: Int): Unit = {
      if(end <= s.length) {
        val str = s.substring(start,end).sorted
        m.put(str, m.getOrElse(str, 0)+1)
        inner(start+1, end+1)
      }
    }
    (1 until s.length).foreach(len => {
      inner(0, len)
    })
    val validOnes = m.filter{case(_, v) => v > 1 }
    validOnes.values.map(factorials.getOrElse(_, 0)).sum
  }

  var factorials: Map[Int, Int] = _
  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val q = stdin.readLine.trim.toInt
    factorials = buildNChoose2(100)
    for (qItr <- 1 to q) {
      val s = stdin.readLine

      val result = sherlockAndAnagrams(s)
      println(result)
    }

  }

}
