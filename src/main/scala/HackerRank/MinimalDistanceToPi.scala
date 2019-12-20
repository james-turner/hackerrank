package HackerRank

object MinimalDistanceToPi extends App {

  def distanceToPi(min: Long, max: Long) = {

    def inner(max: Long, denom: Long, candidates: List[(Long,Long)]): List[(Long,Long)] = {
      if(denom > max) candidates
      else {
        val lower = (Math.PI*denom).toLong
        val higher = lower+1
        inner(max, denom+1, candidates ++ List((lower,denom),(higher,denom)))
      }
    }

    val (_,n,d) = inner(max, 1, List()).map { case(n,d) =>
      (Math.abs(Math.PI - (n.toDouble/d.toDouble)), n,d)
    }.reduceLeft[(Double,Long,Long)]{ case (a,b) =>
        if(a._1 < b._1) a
        else if(a._1 == b._1)
          if(a._3 < b._3) a else b
        else b
    }

    (n,d)

  }


  def distanceToPiQuotients(min: Long, max: Long) = {
    def quotients(n: Int, u0: Double, qs: List[Long]): List[Long] = {
      if(n > 10) qs
      else {
        val newQ = u0.toLong
        val u = 1/(u0-newQ)
        quotients(n+1, u, qs :+ newQ)
      }
    }
    quotients(1, Math.PI, List())

  }

  def genFraction(qs: List[Long], frac: ((Long,Long),(Long,Long))): (Long,Long) = {
    qs match {
      case Nil => frac._2
      case head :: tail =>
        genFraction(tail, (frac._2,(frac._2._1 * head + frac._1._1, frac._2._2 * head + frac._1._2)))
    }
  }

  def distanceToPiQuotients2(min: Long, max: Long) = {
    def quotients(u0: BigDecimal, frac: ((BigInt,BigInt),(BigInt,BigInt))): (BigInt,BigInt) = {
      if(frac._2._2 > max) frac._1
      else {
        val head = u0.toBigInt()
        val u = 1/(u0-BigDecimal(head))
        quotients(u, (frac._2,(frac._2._1 * head + frac._1._1, frac._2._2 * head + frac._1._2)))
      }
    }
    quotients(1/(Math.PI-3), ((1L,0L),(3L,1L)))
  }

  def findGCD(a: BigInt, b: BigInt): BigInt = {
    if(b == 0) a
    else {
      val remainder: BigInt = a%b
      findGCD(b, remainder)
    }
  }

  val (n,d) = distanceToPiQuotients2(450214,458009)

  val gcd = findGCD(n,d)

  val a = n/gcd
  val b = d/gcd
  println(a,b)


  println(distanceToPiQuotients(1,10).mkString(" "))

//  val res: (Long, Long) = distanceToPi(1, 10)
//  println(s"${res._1}/${res._2}")

}
