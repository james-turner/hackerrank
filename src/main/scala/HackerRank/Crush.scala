package HackerRank

import java.io._


class Crush extends App {
  // Complete the arrayManipulation function below.
  def arrayManipulation(n: Int, m: Int): Long = {
    val stdin = scala.io.StdIn
    val array = Array.fill[Long](n + 1)(0L)

    for (i <- 0 until m) {
      val Array(p, q, sum) = stdin.readLine.split(" ").map(_.trim.toLong)
        array(p.toInt) = array(p.toInt) + sum
        if(q.toInt+1 < array.length)
          array(q.toInt+1) = array(q.toInt+1) - sum
    }

    val (_,max) = array.foldLeft((0L,0L)){ case ((rolling,max),r) =>
      (rolling + r, Math.max(max, rolling + r))
    }
    max
  }

  val stdin = scala.io.StdIn

  val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

  val nm = stdin.readLine.split(" ")

  val n = nm(0).trim.toInt

  val m = nm(1).trim.toInt

  val result = arrayManipulation(n, m)

  printWriter.println(result)

  printWriter.close()

}
