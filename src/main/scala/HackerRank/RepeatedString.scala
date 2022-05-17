package HackerRank

object RepeatedString {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    println(result)

  }

  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val filler: Array[Int] = Array.fill(s.length)(0)
    (0 until s.length).foreach { i =>
      val add = if(s(i)=='a') 1 else 0
      filler(i) = filler(Math.max(0,i-1)) + add
    }
    val numOfFull = n/s.length
    val remainder = (n%s.length).toInt
    (numOfFull * filler(s.length-1)) + (if(remainder > 0) filler(remainder-1) else 0)
  }

}
