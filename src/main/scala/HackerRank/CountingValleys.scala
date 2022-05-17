package HackerRank

object CountingValleys {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = countingValleys(n, s)

    println(result)

  }

  def countingValleys(n: Int, s: String): Int = {
    val len = s.length
    @scala.annotation.tailrec
    def inner(pos: Int, height: Int, acc: Int): Int = {
      if(pos == len) acc
      else {
        val move = s(pos) match {
          case 'U' => 1
          case 'D' => -1
        }
        if(height == 0 && height + move == -1) inner(pos+1, height+move, acc+1)
        else inner(pos+1, height+move, acc)
      }
    }
    inner(0, 0, 0)
  }

}
