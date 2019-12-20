package HackerRank

object StringSimilarity extends App {

  def stringSimilarity(s: String): Int = {

    def inner(s: String, pos1: Int, pos2: Int): Int = {
      if (pos2 >= s.length) pos1
      else if (s(pos1) == s(pos2)) inner(s, pos1 + 1, pos2 + 1)
      else pos1
    }

    (0 until s.length).map { i =>
      inner(s, 0, i)
    }.sum
  }

  println(stringSimilarity("ababaa"))

}
