package HackerRank

object CTCIRansomNote {

  // Complete the checkMagazine function below.
  def checkMagazine(magazine: Array[String], note: Array[String]) {
    val magazineWordCount: Map[String, Int] = magazine.groupBy(identity).mapValues(_.length).toMap
    def inner(pos: Int, words: Array[String], availableWords: Map[String,Int]): Unit = pos match {
      case -1 => println("Yes")
      case _ =>
        val counter = availableWords.getOrElse(words(pos), 0)
        if(counter > 0) inner(pos-1, words, availableWords + (words(pos)->(counter-1)))
        else println("No")
    }
    inner(note.length-1, note, magazineWordCount)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val mn = stdin.readLine.split(" ")

    val m = mn(0).trim.toInt

    val n = mn(1).trim.toInt

    val magazine = stdin.readLine.split(" ")

    val note = stdin.readLine.split(" ")
    checkMagazine(magazine, note)
  }
}
