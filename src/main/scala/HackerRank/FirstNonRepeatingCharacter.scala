package HackerRank

import scala.annotation.tailrec

object FirstNonRepeatingCharacter {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val s = stdin.readLine

    val result = firstNonRepeatingCharacter(s)

    println(result)

  }

  // Complete the repeatedString function below.
  def firstNonRepeatingSequentialCharacter(s: String): Char = {
    @tailrec
    def inner(pos: Int, acc: (Char, Int)): Char = {
      if(pos >= s.length && acc._2 <=1) acc._1
      else if(pos >= s.length) '\u0000'
      else if(s(pos) != acc._1 && acc._2 <= 1) acc._1
      else if(s(pos) != acc._1) inner(pos+1, (s(pos), 1))
      else inner(pos+1, (acc._1, acc._2+1))
    }
    inner(0, ('\u0000', 999))
  }

  // Complete the repeatedString function below.
  def firstNonRepeatingCharacter(s: String): Char = {
    val bag = s.toSeq.groupBy(c => c).map(t => (t._1,t._2.length))
    def inner(pos: Int): Char = {
      if(pos >= s.length) '_'
      else if(bag.getOrElse(s(pos),0)==1) s(pos)
      else inner(pos+1)
    }
    inner(0)
  }

}
