package HackerRank

import scala.collection.mutable

object DownToZero2 extends App {

  val top = 1000000/2
  val range1 = (2 to top).toArray
  val range2 = (2 to top).toArray
  val m = mutable.Map[Int,Int]()
  range1.foreach { i1 =>
    range2.foreach { i2 =>
      val n = i1*i2
      m.getOrElseUpdate(n, Math.min(Math.max(i1,i2),m.getOrElse(n,top)))
    }
  }

  m.toList.sortBy(_._1).foreach(println)

  val builder = Array.fill(1000000+1)(0)
  (1 until 1000000+1).foreach{ idx =>
    m.get(idx) match {
      case Some(v) => builder(idx) = 1+ builder(v)
      case None => builder(idx) = 1+ builder(idx-1)
    }
  }

  def downToZero(n: Int): Int = {

    builder(n)

  }






  assert(downToZero(8) == 4)


}
