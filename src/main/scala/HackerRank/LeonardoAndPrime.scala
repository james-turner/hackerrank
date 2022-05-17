package HackerRank

object LeonardoAndPrime extends App {

  def primeCount(n: Long): Int = {
    // Write your code here
    val v = Array[Long](2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53)
    def inner(pos: Int, acc: Long, counter: Int): Int = {
      val newMax = acc * v(pos)
      if(newMax > n || newMax <= 0) counter // include overflow
      else inner(pos+1, newMax, counter+1)
    }
    inner(0,1, 0)
  }

  println(primeCount(614889782588491410L))

}
