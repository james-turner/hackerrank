package HackerRank

object SherlockAndDivisors extends App {

  val primes = List(2,3,5,7,11,13,17,19)
  val pSet: Set[Int] = Set(primes:_*)

  def isPrime(i: Int) = pSet.contains(i)

  def primeFactorization(n: Int): Map[Int,Int] = {
    def inner(n: Int, pos: Int, m: Map[Int,Int]): Map[Int,Int] = {
      if(isPrime(n))
        m + (n -> (m.getOrElse(n, 0) + 1))
      else {
        val l = n % primes(pos)
        if(l != 0)
          inner(n, pos+1, m)
        else
          inner(n/primes(pos), 0, m + (primes(pos) -> (m.getOrElse(primes(pos), 0) + 1)))
      }
    }
    inner(n, 0, Map())
  }


  println(primeFactorization(18))



  def divisorOf2(n: Int) = {
    (1 to Math.sqrt(n).toInt).foldLeft(0) { case(acc,i) =>
      if(n % i == 0){
        if(i % 2 ==0 && n/i % 2 == 0 && n/i!=i) acc+2
        else if(i % 2 ==0 || n/i % 2 == 0) acc+1
        else acc
      } else acc
    }
  }

  println(divisorOf2(16))
}
