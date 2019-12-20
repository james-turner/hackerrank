package HackerRank

object KaprekarNumbers extends App {

  // Complete the kaprekarNumbers function below.
  def kaprekarNumbers(p: Int, q: Int) {
    val k = (p to q).map { i =>
      val len = i.toString.length
      val pow = Math.pow(i,2).toLong.toString
      val r = pow.takeRight(len)
      val l = pow.take(pow.length-len)
      val corrected = if(l=="") 0 else l.toLong
      if((corrected.toLong + r.toLong) == i) Some(i) else None
    }
    val r = k.collect{case Some(i) => i}
    if(r.isEmpty)
      println("INVALID RANGE")
    else
      println(r.mkString(" "))
  }


  kaprekarNumbers(1, 100)

}
