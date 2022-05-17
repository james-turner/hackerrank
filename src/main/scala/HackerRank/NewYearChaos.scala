package HackerRank

object NewYearChaos {

  // Complete the minimumBribes function below.
  def minimumBribes(q: Array[Int]): String = {
    def inner(pos: Int, q: Array[Int], acc: Int): String = {
      if(pos >= q.length) acc.toString
      else {
        val expected = pos+1
        val diff = q(pos) - expected
        if(diff > 2) "Too chaotic"
        else if(diff > 0) inner(pos+1, q, acc+diff)
        else inner(pos+1, q, acc)
      }
    }
    inner(0, q, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val q = stdin.readLine.split(" ").map(_.trim.toInt)
      println(minimumBribes(q))
    }
  }

}
