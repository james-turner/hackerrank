package HackerRank

object SpecialMultiple extends App {

  def solve(n: Int): String = {
    def reduce(v: Long): Boolean = {
      if(v <= 0) true
      else if(v % 10 > 1) false
      else reduce(v/10)
    }

    def inner(i: Int, acc: Long): Long = {
      val res = acc+i
      if(res.toDouble / 9 == (res / 9) && reduce(res/9)) {
        res.toLong
      } else inner(i, res)
    }
    inner(n, 0).toString


  }

  println(Array(1,0,1).permutations.map(_.mkString(",")).mkString("|"))

  println(solve(3))
  println(solve(5))
  println(solve(7))
  println(solve(1))

}
