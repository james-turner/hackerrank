package HackerRank

import scala.collection.mutable

object ManasaAndPizza extends App {


  def f(v: Int) = {

    def inner(v: Int, mem: mutable.Map[Int,Long]): Long = v match {
      case _ if mem.contains(v) => mem.getOrElse(v, 0)
      case _ =>
        val newv = (6*inner(v-1, mem)) - inner(v-2, mem)
        mem.put(v, newv)
        newv

    }

    inner(v, mutable.Map(0->1,1->3))
  }

  def run(arr: Array[Long]) = {
    val s = arr.sum
    val m = fBottomUp(s)
    val v = (0 to arr.length)
      .flatMap(arr.combinations(_))
      .map(a => Math.abs(a.sum - Math.abs(s-a.sum)))
      .map(m.getOrElse(_,BigInt(0)))
      .sum % 1000000007
//    val v = (0 to arr.length).flatMap(arr.combinations(_)).map(a => Math.abs(a.sum - Math.abs(s-a.sum))).map(m.getOrElse(_,0L)).sum % 1000000007
    println(v)
    // val matrix = Array.ofDim(arr.length, arr.sum.toInt)
    //println(matrix.length)
  }

  def fBottomUp(v: BigInt): Map[BigInt,BigInt] = {
    val m: Map[BigInt, BigInt] = Map(BigInt(0)->BigInt(1),BigInt(1)->BigInt(3))
    def inner(v: BigInt, pos: BigInt, acc: (BigInt, BigInt), m: Map[BigInt,BigInt]): Map[BigInt,BigInt] = v match {
      case _ if pos > v => m
      case _ =>
        val newV = 6 * acc._2 - acc._1
        inner(v, pos+1, (acc._2, newV), m + (pos->newV))
    }
    inner(v, 2, (1,3), m)
  }

  def genMask(arr: Array[Long]) = {
    val n = arr.length
    val allMasks = BigInt(1) << n
    val total = BigInt(arr.sum)
    val v = (0 until allMasks.toInt).map{ i => {
        var s = BigInt(0)
        (0 until n).foreach { j  =>
          if((i & 1<<j) > 0){
            s = s+arr(j)
          }
        }
        (s - (total - s).abs).abs
      }
    }
    v
  }

  genMask(Array(1,2,3)).map(subsetSum => fBottomUp(6)(subsetSum)).sum % 1000000007

  val m = fBottomUp(32)

  assert(m.getOrElse(32,0) == BigInt("1572584048032918633353217"))

  assert(m.getOrElse(1,0)==3)
  assert(m.getOrElse(0,0)==1)
  assert(m.getOrElse(2,0)==17)
  assert(m.getOrElse(4,0)==577)

}
