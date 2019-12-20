package HackerRank

import scala.collection.mutable

object KunduAndTree extends App {


  def disjointSets(totalNodes: Int, edges: List[(Int,Int,Char)]): Int = {

    val factMap = factorialMap(totalNodes)
    val combinations: (BigInt,BigInt) => BigInt = buildCombinations(n => {
      val v = factMap.getOrElse(n,BigInt(0))
      v
    })
    val k = 3
    val totalCombinations: BigInt = combinations(k, totalNodes)
    val blacks = edges.filter(_._3=='b')
    val m = mutable.Map[Int,mutable.Set[Int]]()
    blacks.foreach { case(a,b,_) =>
      (m.get(a),m.get(b)) match {
        case (Some(a1),Some(b1)) =>
          val newSet = a1 ++ b1
          newSet.foreach(m.put(_,newSet))
        case (None,Some(b1)) =>
          b1.add(a)
          m.put(a, b1)
        case (Some(a1),None) =>
          a1.add(b)
          m.put(b, a1)
        case (None,None) =>
          val newSet = mutable.Set(a,b)
          m.put(a,newSet)
          m.put(b,newSet)
      }
    }

    val distinctRemovals = m.values.toList.distinct
    distinctRemovals.foreach(println)
    println("========")
    m.values.toList.distinct.foreach(println)
    println("========")


    val h = mutable.HashSet[Set[Int]]()
    m.values.foreach { s=> h.add(s.toSet)}
    h.foreach(println)


    val sumRemovals = h.map{ c =>
      choose3from(c.size) + (choose2from(c.size) * (totalNodes-c.size))
    }.sum
    (totalCombinations - sumRemovals).mod(1000000007).toInt
  }

  // optimized calculation of binom(n, 3)
  def choose3from(n: Int): Long = {
    if (n < 3) return 0
    // k = 3
    // n! / ( k! (n-k)! ) = (n-k+1) * ... * n / k! = (n - 2) * ... * n / 6
    var res = 1
    var x = n - 2
    while ( {
      x <= n
    }) {
      res *= x

      {
        x += 1; x - 1
      }
    }
    res / 6
  }

  // optimized calculation of binom(n, 2)
  def choose2from(n: Int): Long = {
    if (n < 2) return 0
    // k = 2
    // n! / (k! (n-k)!) = (n-k+1) * ... * n / k! = (n - 1) * ... * n / 2
    var res = 1
    var x = n - 1
    while ( {
      x <= n
    }) {
      res *= x

      {
        x += 1; x - 1
      }
    }
    res / 2
  }

  def buildCombinations(factorial: BigInt=>BigInt)(k: BigInt, n: BigInt) = {
    factorial(n) / (factorial(k) * factorial(n-k))
  }

  def factorialMap(n: BigInt): Map[BigInt,BigInt] = {
    def inner(pos: BigInt, last: BigInt, m: Map[BigInt,BigInt]): Map[BigInt,BigInt] = {
      if(pos > n) m
      else {
        val newAcc = last*pos
        inner(pos+1, newAcc, m + (pos->newAcc))
      }
    }
    inner(1, 1, Map(BigInt(0)->BigInt(1)))
  }

  val totalNodes = scala.io.StdIn.readLine().toInt
  val edges = (0 until totalNodes-1).map { i =>
    val line = scala.io.StdIn.readLine()
    val Array(a,b,c) = line.split(" ")
    (a.toInt,b.toInt,c.toCharArray()(0))
  }.toList

//  val totalNodes = 7
//  val edges = List((2,7,'b'),(2,1,'r'),(1,3,'r'),(4,1,'b'),(1,5,'b'),(5,6,'b'))
//  val combos = List(1,2,3,4,5,6,7).combinations(3)
//  combos.map(_.mkString(",")).foreach(println)

  println(disjointSets(totalNodes, edges))

//7
//2 7 b
//2 1 r
//1 3 r
//4 1 b
//1 5 b
//5 6 b


//  1,2,3
//  1,3,7
//  2,3,4
//  2,3,5
//  2,3,6
//  3,4,7
//  3,5,7
//  3,6,7

//1,2,3
//1,2,4
//1,2,5
//1,2,6
//1,2,7
//1,3,4
//1,3,5
//1,3,6
//1,3,7
//1,4,5
//1,4,6
//1,4,7
//1,5,6
//1,5,7
//1,6,7
//2,3,4
//2,3,5
//2,3,6
//2,3,7
//2,4,5
//2,4,6
//2,4,7
//2,5,6
//2,5,7
//2,6,7
//3,4,5
//3,4,6
//3,4,7
//3,5,6
//3,5,7
//3,6,7
//4,5,6
//4,5,7
//4,6,7
//5,6,7
}
