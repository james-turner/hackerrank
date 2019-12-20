package HackerRank

object SubSequenceWeighting {

  // Complete the solve function below.
  def solve(a: Array[Int], w: Array[Int]): Int = {
    a.zip(w).foldLeft(List[(Int,Int)]()){ case(acc,(a, w)) =>
      if(a <= acc.lastOption.map(_._1).getOrElse(0)){
        // reached new sequence
        acc
      } else {
        acc
      }
    }
    1
  }

  val res = solve(Array(1,2,3,4,1,2,3,4), Array(10, 20, 30, 40, 15, 15, 15, 50))
  assert(res == 110)
}
