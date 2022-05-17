package HackerRank

object DieHard3 extends App {

  def solve(a: Int, b: Int, c: Int): String = {
    val Array(as, bs) = Array(a,b).sorted
    if(c % as == 0 || c % bs == 0) "YES"
    else if(c > (as+bs)) "NO"
    else {
      val options = List(as+as, as+bs, bs-as, bs-as+bs, as - (bs % as) ,(as - (bs % as)) + b) //  any ax <= b

      if(options.find(_==c).getOrElse(0) >0) "YES"
      else "NO"
    }

  }

  assert(solve(5, 3, 4) == "YES")
  assert(solve(3, 6, 4) == "NO")

}
