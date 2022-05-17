package HackerRank

object MaxSubArray {

  // Complete the maxSubarray function below.
  def maxSubarray(arr: Array[Int]): Array[Long] = {
    Array(5,3,1,-1,10)
    Array(5)
    Array(5, 8)
    Array(5, 8, 9)
    Array(5, 8, 9, 8)
    Array(5, 8, 9, 8, 18)

    Array(-5, -2, -3, -1, -7)
    Array(-5, -2, -3, -1, -7)

    Array(5, 4, 3, -1, -2)
    Array(5, 9, 12, 11, 9)

    Array(-1, 6, -7, 3, 4)
    Array(-1, 6, -1, 3, 7)

    def inner(arr: Array[Int], pos: Int, acc: (Long, Long)): Long = {
      if(pos >= arr.length) acc._2
      else {
        if(arr(pos) > acc._1 + arr(pos)) inner(arr, pos+1, (arr(pos), Math.max(arr(pos), acc._2)))
        else inner(arr, pos+1, (acc._1 + arr(pos), Math.max(acc._1 + arr(pos), acc._2)))
      }
    }
    val subSum = inner(arr, 0, (0, arr(0)))
    val positiveSums = arr.foldLeft(0L) { case (acc, v) => if (v > 0) acc + v else acc }
    val maxSubSeq = if (positiveSums > 0) positiveSums else arr.max
    Array(subSum,maxSubSeq)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = stdin.readLine.trim.toInt

      val arr = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = maxSubarray(arr)

      println(result.mkString(" "))
    }

  }


}
