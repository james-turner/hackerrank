package HackerRank

object LongestSubArraySum {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val sum = stdin.readLine.toLong
    val a = stdin.readLine.split("\\s+").map(_.toInt)

    val result = longestSubArraySum(a, sum)

    println(result)

  }

  // Complete the repeatedString function below.
  def longestSubArraySum(a: Array[Int], sum: Long): Long = {
    var maxSoFar = 0
    a.indices.foreach { idx1 =>
      var sumSoFar = 0
      (idx1 until a.length).foreach { idx2 =>
        sumSoFar = sumSoFar + a(idx2)
        if(sumSoFar == sum) maxSoFar = Math.max(maxSoFar, (idx2 - idx1) + 1)
      }
    }
    maxSoFar
  }

}
