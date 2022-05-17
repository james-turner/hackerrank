package HackerRank

object MinimumAbsoluteDifferenceInAnArray {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val arr = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = minimumAbsoluteDifference(arr)

    println(result)

  }

  // Complete the jumpingOnClouds function below.
  def minimumAbsoluteDifference(arr: Array[Int]): Int = {
    val sorted = arr.sorted
    (1 until sorted.length).map(idx => {
      sorted(idx) - sorted(idx-1)
    }).min

  }
}
