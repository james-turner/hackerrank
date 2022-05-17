package HackerRank

object LuckBalance {

  def main(args: Array[String]) {

    val stdin = scala.io.StdIn

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val contests = Array.ofDim[Int](n, 2)

    for (i <- 0 until n) {
      contests(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = luckBalance(k, contests)

    println(result)

  }

  // Complete the maxMin function below.
  def luckBalance(k: Int, arr: Array[Array[Int]]): Int = {
    val notImportant = arr.filter(a => a(1)==0)
    val unimportantLuck = notImportant.map(_(0)).sum
    val important = arr.filter(a => a(1)==1).map(_(0)).sortBy(-_)
    val importantLuck = important.take(k).sum
    importantLuck + unimportantLuck - (important.sum - importantLuck)
  }
}
