package HackerRank

import scala.collection.mutable

object ArrayPairs extends App {
//
//  def solve(arr: Array[Int]) = {
//    val max = arr.max
//    def inner(a: Array[Int], pos: Int, acc: Int): Int = pos match {
//      case a.length => acc
//      case _ =>
//        val lowerThan: Int = a(pos) / max
//        inner(a, pos+1, acc)
//    }
//    inner(arr.sorted, 0, 0)
//  }

  def solve(arr: Array[Int]): Int = {
    val max = arr.max
    val m: Map[Int, Int] = arr.sorted.zipWithIndex.foldLeft[Map[Int,Int]](Map[Int,Int]()) {
      case (m,(v,idx)) => m + (v -> idx)
    }
    def recurseMap(m: Map[Int,Int], v: Int): Int = {
      if(v < 0) 0
      else {
        m.get(v) match {
          case Some(c) => c
          case None => recurseMap(m, v-1)
        }
      }
    }
    val s = mutable.Set[Int]()
    arr.foldLeft[Int](0) { case (c, v) =>
      val newC = c + recurseMap(m, v / max)
      if(s.contains(v)) newC-1 else {
        s.add(v)
        newC
      }
    }
  }

  def binSearch(arr: Array[Int], num: Int): Int = {

    def inner(a: Array[Int], pos: Int, num: Int): Int = {
      if(a(pos) < num) inner(arr, pos/2, num)
      else inner(arr, pos+(pos/2), num)
    }
    inner(arr, arr.length/2, num)
  }

  val res: Int = solve(Array(1, 1, 2, 4, 2))
  println(res)
  assert(res==8)


}
