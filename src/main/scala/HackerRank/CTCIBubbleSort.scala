package HackerRank

object CTCIBubbleSort {

  // Complete the countSwaps function below.
  def countSwaps(a: Array[Int]): Int = {
    val n = a.length
    var cnt = 0
    (0 until n).foreach { i =>
      (0 until n-1).foreach { j =>
        if(a(j) > a(j+1)){
          val tmp = a(j+1)
          a(j+1) = a(j)
          a(j) = tmp
          cnt = cnt+1
        }
      }
    }
    cnt
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val a = stdin.readLine.split(" ").map(_.trim.toInt)
    val swaps = countSwaps(a)
    val first = a(0)
    val last = a(a.length-1)
    println(s"Array is sorted in ${swaps} swaps.")
    println(s"First Element: ${first}")
    println(s"Last Element: $last")

  }

}
