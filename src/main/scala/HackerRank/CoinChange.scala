package HackerRank

object CoinChange {

  /*
    * Complete the 'getWays' function below.
    *
    * The function is expected to return a LONG_INTEGER.
    * The function accepts following parameters:
    *  1. INTEGER n
    *  2. LONG_INTEGER_ARRAY c
    */

  val dp = Array.fill(6)(0)
  dp(0) = 1

  def getWays(n: Int, c: Array[Int]): Int = {
    c.foreach { coin =>
      (1 until 251).foreach(idx => {
        if (coin <= idx) {
          dp(idx) = dp(idx) + dp(idx - coin)
        }
      })
    }
    dp(n)
  }

  def getWaysF(n: Int, c: Array[Int]): Int = {
    if(n < 0) 0
    else if (dp(n) > 0) dp(n)
    else {
      var numWays = 0
      c.indices.foreach { idx =>
        val coin = c(idx)
        val ways = getWaysF(n - coin, c.slice(idx, c.length))
        if(ways > 0) dp(n - coin) = ways
        numWays = numWays + ways
      }
      numWays
    }
  }


  def main(args: Array[String]) {

    //    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")
    //
    //    val n = firstMultipleInput(0).toInt
    //
    //    val m = firstMultipleInput(1).toInt
    //
    //    val c = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

    //    val ways = getWays(10, Array(2, 3, 5, 6).sorted)
    //    val ways2 = getWaysF(10, Array(2, 3, 5, 6).sorted)
    val way3 = getWaysF(4, Array(1, 2, 3).sorted)
    //    val way4 = getWays(4, Array(1,2,3).sorted)

    //1,2,3 -> 4
    // 1, 1, 1, 1
    // dp[1] -> 1
    // iterate 2,3 -> less than 0 so nothing
    // back up 1
    // dp[2] -> 1
    // iterate 2
    // 2->0, gives 1
    // dp[2] -> 1 + 1 -> 2
    // iterate 3 -> less than 0 so nothing
    // back up 1
    // dp[3] -> 1
    // iterate 2
    // 2->1, (from dp gives 1)
    // dp[3] -> 1+1 -> 2
    // iterate 3
    // 3->0, gives 1
    // dp[3] -> 2+1 -> 3
    // back up 1
    // dp[4] -> 1


    println(way3)
    //    println(way3)

  }

}
