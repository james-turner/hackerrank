package HackerRank

import scala.annotation.tailrec

object MinSwaps extends App {

  // Complete the minimumSwaps function below.
  def minimumSwaps(arr: Array[Int]): Int = {
    val min = arr.min
    val newArr = arr.map(i => i - min + 1)
    println(newArr.mkString(","))
    @tailrec
    def inner(pos: Int, arr: Array[Int], acc: Int): Int = {
      true match {
        case _ if pos >= arr.length => acc
        case _ => {
          val v = arr(pos)
          if(pos == v-1) inner(pos+1, arr, acc)
          else if(arr(v-1) == pos+1 && pos < v) inner(pos+1, arr, acc)
          else inner(pos+1, arr, acc+1)
        }
      }
    }
    Math.max(0, inner(0, newArr, 0)-1)
  }

//  println(minimumSwaps(Array(2,3,4,5,1)))
//  println(minimumSwaps(Array(1,2,3,4,5)))
//  println(minimumSwaps(Array(61,60,59,58,57,56,55,54,53,51,52)))
//  println(minimumSwaps(Array(4,3,1,2)))
  println(minimumSwaps(Array(7, 1, 3, 2, 4, 5, 6)))
  println(minimumSwaps(Array(-7, -1, -3, -2, -4, -5, -6)))
//  println(minimumSwaps(Array(2,1,3,4,5)))
//  println(minimumSwaps(Array(5,4,3,2,1)))
}
