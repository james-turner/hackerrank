package HackerRank

import scala.collection.mutable

object QHeap1 extends App {

  var heap = mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

  def add(num: Int): Unit ={
    heap += num
  }

  def delete(num: Int) = {
    heap = heap.filter(_ != num)
  }

  def peek() = {
    heap.headOption.getOrElse(0)
  }

  val numQueries = scala.io.StdIn.readLine().trim.toInt
  (0 until numQueries).map { i =>
    val opAndMaybeValue = scala.io.StdIn.readLine().trim.split(" ")
    opAndMaybeValue(0).toInt match {
      case 1 => add(opAndMaybeValue(1).toInt)
      case 2 => delete(opAndMaybeValue(1).toInt)
      case 3 => println(peek())
    }
  }


}
