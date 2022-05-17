package HackerRank
import scala.collection.mutable.BitSet

object LonelyInteger extends App {

  def lonelyinteger(a: Array[Int]): Int = {
    var counter = 0
    val bs = BitSet()
    a.foreach{ i =>
      if(bs.contains(i)) counter = counter - i
      else {
        counter = counter + i
        bs.add(i)
      }
    }
    counter
  }

  val v: Int = lonelyinteger(Array(1, 2, 3, 4, 5, 4, 3, 2, 1))
  assert(v == 5)

}
