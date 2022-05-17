package HackerRank

import scala.collection.mutable

object ReverseFactorization extends App {

  def reverseFactorize(num: Int, factors: Array[Int]): Array[Int] = {
    val sortedFactors = factors.sorted.reverse
    val map = mutable.Map[Int,Int]()
    def inner(startNum: Int, startPos: Int, pos: Int, factors: Array[Int], num: Int, acc: List[Int]): List[Int] = {
      if(num == 1) acc
      else if(startPos < sortedFactors.length && pos >= sortedFactors.length) {
        inner(startNum, startPos+1, startPos+1, factors, startNum, List())
      }
      else if(pos >= sortedFactors.length) List(-1)
      else {
        val divisor = factors(pos)
        if(num % divisor == 0){
          inner(startNum, startPos, pos + 1, factors, num / divisor, acc :+ divisor)
        } else {
          inner(startNum, startPos, pos + 1, factors, num, acc)
        }
      }
    }
    inner(num, 0, 0, sortedFactors, num, List()).toArray
  }

  val Array(num, _) = scala.io.StdIn.readLine().split(" ")
  val factors = scala.io.StdIn.readLine().split(" ")

  val res = reverseFactorize(num.toInt, factors.map(_.toInt))
  if(res.head == -1) println("-1")
  else {
    val res2 = res.foldRight[List[Int]](List(1)){ case(multiplier, acc) =>
      acc :+ acc.last*multiplier
    }
    println(res2.mkString(" "))
  }
}
//24 3
//4 6 8
