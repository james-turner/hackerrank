package HackerRank

object DiwaliLights extends App {

  def lights(n: Int): Long = {
    /*
     * Write your code here.
     */
    BigInt(2).pow(n).toLong-1 % 10^5

  }


  println(lights(3))

}
