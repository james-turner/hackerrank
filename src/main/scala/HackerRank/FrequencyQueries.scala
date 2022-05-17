package HackerRank


import java.util

import scala.io.StdIn

object FrequencyQueries {

  val bag = new util.HashMap[Int, Int](100000)
  val idx = new util.HashMap[Int, Int](100000)

  // Complete the freqQuery function below.
  def freqQuery(op: Int, v: Int): Unit = {
    op match {
      case 1 =>
        val oldCounter = if (bag.containsKey(v)) bag.get(v) else 0
        incIdx(oldCounter + 1, idx)
        decIdx(oldCounter, idx)
        bag.put(v, oldCounter + 1)
      case 2 =>
        if (bag.containsKey(v) && bag.get(v) > 0) {
          val old = bag.get(v)
          bag.put(v, old - 1)
          decIdx(old, idx)
          incIdx(old - 1, idx)
        }
      case 3 =>
        if (idx.containsKey(v) && idx.get(v) > 0) println("1")
        else println("0")
    }
  }

  def incIdx(k: Int, m: util.HashMap[Int, Int]) = if(m.containsKey(k)) m.put(k, m.get(k)+1) else m.put(k, 1)

  def decIdx(k: Int, m: util.HashMap[Int, Int]) = if(m.containsKey(k)) m.put(k, m.get(k)-1) else m.put(k, 0)

  def main(args: Array[String]) {

    val q = StdIn.readLine.trim.toInt

    for (i <- 0 until q) {
      val Array(op, v) = StdIn.readLine.split(" ").map(_.toInt)
      freqQuery(op, v)
    }


  }
}
