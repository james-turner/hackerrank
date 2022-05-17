package HackerRank
import scala.collection.{BitSet=>BS}
object BitSet extends App {


  val bs = new BitSet(1024)
  bs.set(1)
  bs.set(14)
  bs.set(31)
  bs.set(32)
  assert(bs.exists(1))
  assert(bs.exists(14))
  assert(bs.exists(31))
  assert(bs.exists(32))
  assert(!bs.exists(33))


}

class BitSet(size: Int) {
  val maxWord = 32
  val bitset: Array[Int] = Array.fill((size/maxWord)+1)(0) // int is 32/64 bits -> 64^2 = 1024 n

  def exists(n: Int): Boolean = {
    val i = bitset(n / maxWord)
    (i & (1 << (n%maxWord))) == (1 << (n%maxWord))
  }

  def set(n: Int) = {
    val i = bitset(n / maxWord)
    bitset(n/maxWord) = i | (1 << n % maxWord)
  }

}
