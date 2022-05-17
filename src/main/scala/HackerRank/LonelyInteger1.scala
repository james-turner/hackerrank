package HackerRank

import scala.collection.mutable.BitSet

object LonelyInteger1 extends App {

  def lonelyinteger(a: Array[Int]): Int = {

    // iterate through the array
    // make an array of size 100 initialize to 0
    // for each number we encounter, lets keep a counter by putting index  = index+1 in the counter array
    // [0,0,0,0,0]
    // [0,2,2,2,2,1]
    // go through list
    // find the 1
    // that index is your answer

    // {}
    // {1:1, 2:1, 3:1, 4:1, 5:1}
    // iterate through key/values in map
    // find the 1

    // BitSet()
    // iterate through list
    // flip bit to ...? 0->1 , 1->0
    // find bit set to 1, index is the answer

    0

  }

  val v: Int = lonelyinteger(Array(1, 2, 3, 4, 5, 4, 3, 2, 1))
  assert(v == 5)

}
