package HackerRank

object Factorial extends App {


  def factorial(n: Int): BigInt = {

    def inner(pos: Int, n:Int, acc: BigInt): BigInt = {
      if(pos > n) acc
      else inner(pos+1, n, acc*pos)
    }
    inner(1,n,1)
  }

  println(factorial(10))


}
