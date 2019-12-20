package HackerRank

import scala.annotation.tailrec
import scala.collection.mutable

object InvertedIndex extends App {

  val arr = Array(4, 3, 1, 2)
  val min = arr.min
  val newArr = arr.map(i => i - min)
  val m = mutable.Map(newArr.zipWithIndex:_*)

  @tailrec
  def inner(pos: Int, arr: Array[Int], acc: Int): Int = {
    if (pos >= arr.length) acc
    else {
      val v = arr(pos)
      if (v == pos) inner(pos + 1, arr, acc)
      else {
        val newIdx = m(pos)
        m.put(v, newIdx)
        m.put(pos, pos)
        arr(newIdx) = v
        arr(pos) = pos
        inner(pos + 1, arr, acc + 1)
      }
    }

  }

  println(inner(0, newArr, 0))

}
