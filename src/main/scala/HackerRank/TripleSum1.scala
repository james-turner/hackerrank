package HackerRank

import scala.annotation.tailrec

object TripleSum1 extends App {

  def triplets(a: Array[Int], b: Array[Int], c: Array[Int]): Long = {
    val aDist = a.distinct.sorted
    val bDist = b.distinct.sorted
    val bLen = bDist.length
    val cDist = c.distinct.sorted

    @tailrec
    def inner(aPos: Int, bPos: Int, cPos: Int, acc: Long): Long = bPos match {
      case _ if bLen == bPos => acc
      case _ => {
        if(aPos < aDist.length && aDist(aPos) <= bDist(bPos)) inner(aPos +1, bPos, cPos, acc)
        else if(cPos < cDist.length && cDist(cPos) <= bDist(bPos)) inner(aPos, bPos, cPos+1, acc)
        else inner(aPos, bPos+1, cPos, acc = acc + (aPos.toLong*cPos.toLong))
      }
    }

    val res = inner(0,0,0,0)
    res
  }

  assert(triplets(Array(1,4,5), Array(2,3,3), Array(1,2,3)) == 5)

}
