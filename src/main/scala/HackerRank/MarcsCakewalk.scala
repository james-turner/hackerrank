package HackerRank

object MarcsCakewalk {

  // Complete the marcsCakewalk function below.
  def marcsCakewalk(calorie: Array[Int]): Long = {
    val a = calorie.sorted.reverse
    def inner(pos: Int, acc: Long): Long = {
      if(pos >= a.length) acc
      else inner(pos+1, acc+(a(pos) * Math.pow(2, pos).toLong))
    }
    inner(0, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val calorie = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = marcsCakewalk(calorie)

    println(result)
  }

}
