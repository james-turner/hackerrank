package HackerRank

object FibonacciQMatrix extends App {


  // fib(x) = fib(x-1) + fib(x-2)   (0,1)

  // (6,-1,1,0) . (3,1) => (17,3)

  // identity
//  (1,0)  .  (0)  =   (0)
//  (0,1)     (1)      (1)
//
//  // something
//  (0,1)  .  (0)  =   (1)
//  (1,1)     (1)      (1)
//
//  (0,1)  .  (1)  =   (1)
//  (1,1)     (1)      (2)
//
//  (0,1)  .  (1)  =   (2)
//  (1,1)     (2)      (3)
//
//  (0,1)  .  (2)  =   (3)
//  (1,1)     (3)      (5)

  def qMatrix(n: Int) = {
    val m = Array(Array(0,1), Array(1,1))
    val initial = Array(0,1)
    def inner(n: Int, m: Array[Array[Int]], i: Array[Int]): Array[Int] = n match {
      case 0 => i
      case _ =>
        inner(n-1, m, dotProd(m,i))
    }
    inner(n,m, initial)
  }

  def dotProd(m1: Array[Array[Int]], m2: Array[Int]) = {
    m1.map { row =>
      row.zip(m2).map(t => t._1*t._2).sum
    }
  }

  val q = qMatrix(5)
  println(q.mkString(","))

}
