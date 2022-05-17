package HackerRank

import scala.annotation.tailrec
import scala.collection.mutable

object FirstDuplicate {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val a = stdin.readLine.split("\\s+").map(_.toInt)

    val result = firstDuplicate(a)

    println(result)

  }

  // Complete the repeatedString function below.
  def firstDuplicate(a: Array[Int]): Int = {
    val bag = mutable.Set[Int]()
    def inner(pos: Int): Int = {
      if(pos >= a.length) 0
      else if(bag.contains(a(pos))) a(pos)
      else {
        bag.add(a(pos))
        inner(pos+1)
      }
    }
    inner(0)
  }

}
