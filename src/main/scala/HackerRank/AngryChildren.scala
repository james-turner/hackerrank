package HackerRank

object AngryChildren {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val k = stdin.readLine.trim.toInt

    val arr = Array.ofDim[Int](n)

    for (i <- 0 until n) {
      val arrItem = stdin.readLine.trim.toInt
      arr(i) = arrItem}

    val result = maxMin(k, arr)

    println(result)

  }

  // Complete the maxMin function below.
  def maxMin(k: Int, arr: Array[Int]): Int = {
    val sorted = arr.sorted
    def inner(pos: Int, min: Int): Int = {
      if(pos == sorted.length) min
      else {
        inner(pos+1, Math.min(min, sorted(pos) - sorted(pos-k+1)))
      }
    }
    inner(k-1, arr.max)
  }
}
