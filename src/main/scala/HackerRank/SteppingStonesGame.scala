package HackerRank

object SteppingStonesGame extends App {

  def solve(n: Long): String = {

    def v(n: Long) = {
      (Math.pow(n,2) - ((n * ((n-1)/2)) - ((n-1)%2)*n/2)).toLong
    }

    def inner(pos: Long, n: Long, acc: Long): String = {
      if(acc > n) "Better Luck Next Time"
      else if(acc == n) s"Go On Bob ${Math.max(0,pos-1)}"
      else inner(pos+1,n,acc+pos)
    }

    val approx = Math.sqrt(n).toLong
    inner(approx, n, v(approx-1))

  }

  println(solve(3))

}
