package HackerRank

import java.io.PrintWriter

object GridChallenge extends App {
  def gridChallenge(grid: Array[String]): String = {
    val len = grid(0).length
    val sorted = grid.flatMap(_.split("").sorted)
    val sortedLen = sorted.length
    def inner(pos: Int): String = {
      if(pos >= sortedLen) "YES"
      else if(sorted(pos) >= sorted(pos-len)) inner(pos+1)
      else "NO"
    }
    inner(len)
  }

  val stdin = scala.io.StdIn

  val t = stdin.readLine.trim.toInt

  for (tItr <- 1 to t) {
    val n = stdin.readLine.trim.toInt

    val grid = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val gridItem = stdin.readLine
      grid(i) = gridItem
    }

    val result = gridChallenge(grid)

    println(result)
  }

}
