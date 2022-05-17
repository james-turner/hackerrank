package HackerRank

object MarkAndToys {

  // Complete the maximumToys function below.
  def maximumToys(prices: Array[Int], k: Int): Int = {
    val sorted = prices.sorted
    def inner(pos: Int, left: Int, acc: Int): Int = {
      if(left < sorted(pos)) acc
      else inner(pos+1, left-sorted(pos), acc+1)
    }
    inner(0, k, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val prices = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = maximumToys(prices, k)

    println(result)

  }

}
