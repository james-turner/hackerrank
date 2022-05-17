package HackerRank

object GreedyFlorist {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val minimumCost = getMinimumCost(k, c)

    println(minimumCost)

  }

  // Complete the getMinimumCost function below.
  def getMinimumCost(k: Int, c: Array[Int]): Int = {
    val r = c.sorted.reverse
    def inner(pos: Int, acc: Int): Int = {
      if(pos*k >= r.length) acc
      else {
        val sum= r.slice(pos*k, pos*k+k).sum * (pos+1)
        inner(pos+1, acc+sum)
      }
    }
    inner(0, 0)
  }
}
