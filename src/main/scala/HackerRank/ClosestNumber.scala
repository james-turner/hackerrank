package HackerRank

object ClosestNumber extends App {


  def closestNumber(a: Int, b: Int, x: Int): Int = {
    /*
     * Write your code here.
     */
    val expected = Math.pow(a,b)
    Math.round((expected / x)).toInt * x
  }

  assert(closestNumber(349, 1, 4) == 348)
  assert(closestNumber(395, 1, 7) == 392)
  assert(closestNumber(4, -2, 2) == 0)
}
