package HackerRank

import scala.collection.mutable

object ConstructTheArray {

  // Complete the countArray function below.
  def countArray(n: Int, k: Int, x: Int): Long = {
    // Return the number of ways to fill in the array.
    val dp = Array.fill(n-2, k)(0L)

    def inner(xPos: Int, lastChosenNum: Int): Long = {
      if(dp(xPos)(lastChosenNum) != 0) dp(xPos)(lastChosenNum)
      else {
        if(xPos == n-3){
          val endVal = if(lastChosenNum == x) k - 1 else k - 2
          dp(xPos)(lastChosenNum) = endVal
          endVal
        } else {
          var acc  = 0L
          (1 to k).foreach{ nextK =>
            if(nextK != lastChosenNum)
              acc = (acc + (inner(xPos+1, nextK) % 1000000007)) % 1000000007
          }
          dp(xPos)(lastChosenNum) = acc
          acc
        }
      }
    }

    inner(0, 1)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nkx = stdin.readLine.split(" ")

    val n = nkx(0).trim.toInt

    val k = nkx(1).trim.toInt

    val x = nkx(2).trim.toInt

    val answer = countArray(n, k, x)

    println(answer)
  }

}
