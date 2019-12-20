package HackerRank

object YouCanGoYourOwnWay {

  def main(args: Array[String]): Unit = {
    val numTests = scala.io.StdIn.readLine().toInt
    (0 until numTests).foreach{ i =>
      val n = scala.io.StdIn.readLine().toInt
      val path = scala.io.StdIn.readLine()
      println(path.toArray.map { c =>
        if(c=='S') 'E'
        else 'S'
      }.mkString)
    }
  }


}
