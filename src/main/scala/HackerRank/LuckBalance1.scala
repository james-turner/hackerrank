package HackerRank

object LuckBalance1 {

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
    val freeLuck: Int = arr.filter(_(1) == 0).map(_(0)).sum
    val importants = arr.filter(_(1) == 1).map(_(0)).sorted
    val subLuck = importants.take(importants.length-k).sum
    val importantsWeLose = importants.reverse.take(k)
    freeLuck + importantsWeLose.sum - subLuck
  }
}
