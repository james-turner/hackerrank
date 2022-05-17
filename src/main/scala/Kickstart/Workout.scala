package Kickstart

import scala.annotation.tailrec
import scala.collection.mutable

object Solution {

  def main(args: Array[String]): Unit = {

    val t = scala.io.StdIn.readLine().toInt

    (1 to t).foreach { i =>
      val Array(n, k) = scala.io.StdIn.readLine().split(' ').map(_.toInt)
      val m: Array[Int] = scala.io.StdIn.readLine().split(' ').map(_.toInt)
      if(((m.max - m.min - 1) - m.length - 2) <= k){
        System.out.println(s"Case #${i}: 1")
      } else {
        val diffs = (1 until m.length).map { i =>
          m(i) - m(i-1)
        }
        System.out.println(s"Case #${i}: ${solve(k, mutable.PriorityQueue(diffs:_*))}")
      }
      System.out.flush()
    }
  }

  @tailrec
  def solve(k: Int, m: mutable.PriorityQueue[Int]): Int = k match {
    case 0 => m.head
    case _ if m.head == 1 => 1
    case _ =>
      solve(k-1, m.tail += (m.head / 2) += (m.head+1) / 2)
  }

}
