package HackerRank

import java.io.PrintWriter

object CTCILeftRotation {

  // Complete the rotLeft function below.
  def rotLeft(a: Array[Int], d: Int): Array[Int] = {
    val fill = Array.fill(a.length)(0)
    def inner(n: Int, fill: Array[Int], pos: Int): Array[Int] = n match {
      case 0 => fill
      case _ =>
        fill(pos-d) = a(pos%a.length)
        inner(n-1, fill, pos+1)
    }
    inner(a.length, fill, d)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nd = stdin.readLine.split(" ")

    val n = nd(0).trim.toInt

    val d = nd(1).trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = rotLeft(a, d)

    println(result.mkString(" "))

  }

}
