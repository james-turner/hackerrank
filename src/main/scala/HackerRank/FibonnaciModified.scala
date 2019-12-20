package HackerRank

object FibonnaciModified extends App {

  def fibonacciModified(t1: Int, t2: Int, n: Int): BigInt = {
    // Complete this function
    def inner(t1: BigInt, t2: BigInt, n: Int): BigInt = {
      n match {
        case 0 => t2
        case _ => inner(t2, t1 + t2.pow(2), n - 1)
      }
    }

    n match {
      case 1 => t1
      case 2 => t2
      case _ => inner(t1, t2, n-2)
    }
  }

  val result = fibonacciModified(0, 1, 6)
  println(result)
}
