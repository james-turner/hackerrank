package HackerRank

object SherlockAndQueries extends App {

  def solve(A: Array[Int], B: Array[Int], C: Array[Int]): Array[Int] = {
    B.indices.foreach { i =>
      A.indices.foreach { j =>
        if(j % B(i) == 0){
          A(j) = A(j) * C(i)
        }
      }
    }
    A.map(_ % 1000000007)
  }

  println(solve(Array(1,2,3,4), Array(1,2,3), Array(13,29,71)).mkString(","))

}
