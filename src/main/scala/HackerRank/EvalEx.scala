package HackerRank

object EvalEx {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    (0 until n).foreach { _ =>
      val x = stdin.readLine.trim.toDouble
      println(exponent(x))
    }
  }

  def exponent(x: Double): Double = {

    def inner(n: Int, pow: Int, factorial: Int, acc: Double): Double = n match {
      case 0 => acc
      case _ =>
        inner(n - 1, pow + 1, pow * factorial, acc + (Math.pow(x, pow) / (pow * factorial)))
    }

    inner(9, 1, 1, 1)
  }

}
