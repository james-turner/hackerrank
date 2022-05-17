package HackerRank

object WeightedUniformString extends App {

  val s = "aabcdeee"

  def makeSetOfSubs(s: String): Set[Int] = {
    val lastChar = s(0).toInt - 96

    def inner(pos: Int, counter: Int, acc: Set[Int]): Set[Int] = {
      if(pos >= s.length) acc + (s(pos-1).toInt - 96)*counter
      else if(s(pos) != s(pos-1)) inner(pos+1, 1, acc + (s(pos-1).toInt - 96)*counter)
      else inner(pos+1, counter+1, acc + (s(pos-1).toInt - 96)*counter)
    }
    inner(1, 1, Set(lastChar))

  }

  // Complete the weightedUniformStrings function below.
  def weightedUniformStrings(s: String, queries: Array[Int]): Array[String] = {
    val subs = makeSetOfSubs(s)
    queries.map(i => if(subs.contains(i)) "Yes" else "No")
  }


  val res: Set[Int] = makeSetOfSubs(s)
  println(res)
  assert(res == Set(5, 10, 1, 2, 3, 4, 15))

  println(weightedUniformStrings("aaabbbbcccddd", Array(9,7,8,12,5)).mkString("\n"))

//  Set(1,2,3,4,5,10,15,...)
}
