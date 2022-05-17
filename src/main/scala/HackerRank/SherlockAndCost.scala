package HackerRank

object SherlockAndCost extends App {


  val b = Array(2, 23,4,5)

  val a = Array(1, 1-23, 1-4, 1-5)

  val a1 = Array(1,1,1,1)

  val diff = Array(0,0,0) // 0?

  val bestA1 = Array(1,23,1,5)
  val max = Array(22,22,4) // 48


  // naive version
  // produce all valid combinations of a values (with diffs and sums)
  // and pick the biggest
  // worst case (25^n) (given B is 25 in all positions)


//  1 -> 1
//
//       23    -> 1
//
//
//                4    ->  1
//                         5
//
//  2 -> 1
//
//       23

//  now + max(1, B)
//
//
//  df[posI] = ?
//

  def algo(b: Array[Int]): Int  = {
    var maxWhenEndsWith1, maxWhenEndsWithB  = 0
    (1 until b.length).foreach { bIdx =>
      val currentB = b(bIdx)
      val prev = b(bIdx-1)

      val maxWhenEndsWith1Tmp = Math.max(maxWhenEndsWith1 + Math.abs(1 - prev), maxWhenEndsWithB + Math.abs(1 - prev))
      val maxWhenEndsWithBTmp = Math.max(maxWhenEndsWith1 + Math.abs(1 - currentB), maxWhenEndsWithB + Math.abs(prev - currentB))

      maxWhenEndsWith1 = maxWhenEndsWith1Tmp
      maxWhenEndsWithB = maxWhenEndsWithBTmp

    }
    Math.max(maxWhenEndsWithB, maxWhenEndsWith1)
  }


  println(algo(Array(100, 2, 100, 2, 100)))



  def pick1OrB(b: Array[Int]): Int = {
    println(b.mkString(","))
    val pick1 = Array.fill(b.length)(0)
    val pickB = Array.fill(b.length)(0)

    (1 until b.length).foreach{ idx =>
      val choose1 = Math.abs(1 - b(idx - 1))
      val chooseB = Math.abs(b(idx) - b(idx - 1))
      pick1(idx) = Math.max(pickB(idx-1) + choose1, pick1(idx-1) + choose1)
      pickB(idx) = Math.max(pickB(idx-1) + chooseB, pick1(idx-1) + chooseB)
    }
    println(pick1.mkString(","))
    println(pickB.mkString(","))
    Math.max(pick1.last, pickB.last)
  }

  println(pick1OrB(Array(100, 2, 100, 2, 100)))
  /**
   * [pick1,pickB]
   * [1, 23]
   *    /\
   * [0, 23]
   */
}
