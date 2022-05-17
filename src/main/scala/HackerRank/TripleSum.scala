package HackerRank

object TripleSum extends App {

  // Complete the triplets function below.
  def triplets(a: Array[Int], b: Array[Int], c: Array[Int]): Long = {
    var aPointer, cPointer = 0
    val aSorted = a.distinct.sorted
    val bSorted = b.distinct.sorted
    val cSorted = c.distinct.sorted
    var sum = 0L
    bSorted.foreach { bVal =>
      while (aPointer < aSorted.length && aSorted(aPointer) <= bVal) aPointer = aPointer + 1
      while (cPointer < cSorted.length && cSorted(cPointer) <= bVal) cPointer = cPointer + 1
      sum = sum + (aPointer.toLong * cPointer.toLong)
    }
    sum
  }

  val arra = Array(1, 3, 5, 7)
  val arrb = Array(5, 7, 7, 7, 7, 7, 7, 9)
  val arrc = Array(7, 9, 11, 11, 13, 13)
  val ans = triplets(arra, arrb, arrc)

  println(ans)

}
