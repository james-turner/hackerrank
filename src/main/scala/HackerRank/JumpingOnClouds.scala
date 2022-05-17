package HackerRank

object JumpingOnClouds {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    println(result)

  }

  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int]): Int = {

    def inner(pos: Int, acc: Int): Int = {
      if(pos == c.length-3) acc+1
      else if(pos == c.length-2) acc+1
      else if(c(pos+2) == 1) inner(pos+1, acc+1)
      else inner(pos+2, acc+1)
    }
    inner(0, 0)
  }
}
