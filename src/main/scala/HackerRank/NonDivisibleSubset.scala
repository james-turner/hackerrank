package HackerRank

object NonDivisibleSubset extends App {


  val s = Array(19,10,12,10,24,25,22)
  val k = 4

  /*
   * Complete the 'nonDivisibleSubset' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY s
   */
  def nonDivisibleSubset(k: Int, s: Array[Int]): Int = {
    // Write your code here

    // make a subset, where ANY 2 numbers when summed are NOT divisible by k
//    [19,10] // sum ! divisible
//    [19,10,12] // when i add in 12 i need to know that 19+12 and 10+12 are not divisible, then yes
//       [10,12] //
    val arr = Array.fill(k)(0) // an array of size k
    // fill the array
    s.foreach(v => {
      arr(v % k) += 1
    })

    println(arr.mkString(","))


    (0 to k/2).foldLeft(0) { (acc,key) =>
      key
    }


  }


  assert(nonDivisibleSubset(k, s) == 3)

}
