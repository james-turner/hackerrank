package Facebook

import scala.collection.mutable

object NumberOfWays {

  def main(args: Array[String]) {
    // Call numberOfWays() with test cases here
    assert(numberOfWays(Array(1,5,5,1,5,1,3,3,3), 6)==12)
  }

  def numberOfWays(arr: Array[Int], k: Int) : Int = {
    // Write your code here
    val m = mutable.Map[Int,Int]()
    var acc = 0
    arr.indices.foreach { idx =>
      val lookup = k - arr(idx)
      m.get(lookup) match {
        case None => 0
        case Some(n) => acc = acc+n
      }
      m.put(arr(idx), m.getOrElse(arr(idx),0)+1)
    }
    acc
  }
}
