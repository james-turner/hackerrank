package HackerRank

import scala.annotation.tailrec
import scala.collection.mutable

object JesseAndCookies extends App {

  /*
 * Complete the cookies function below.
 */
  def cookies(k: Int, A: Array[Int]): Int = {
    /*
     * Write your code here.
     */
    val q = new mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
    q.enqueue(A:_*)

    def inner(q: mutable.PriorityQueue[Int], ops: Int): Int = {
      if (q.length <= 1)
        if(q.head >= k) ops else -1
      else {
        if (q.head >= k) ops
        else {
          val a = q.dequeue()
          val b = q.dequeue()
          q.enqueue(a+2*b)
          inner(q, ops+1)
        }
      }
    }

    inner(q, 0)

  }
    println(cookies(7, Array(1,2,3,9,10,12)))
}

