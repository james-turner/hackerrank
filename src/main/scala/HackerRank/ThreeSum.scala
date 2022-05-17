package HackerRank

object ThreeSum extends App {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if(nums.length < 3) List()
    else {
      val sorted = nums.sorted

      sorted.indices.flatMap { idx =>
        if(idx > 0 && sorted(idx) == sorted(idx-1)) List()
        else {
          val t = twoSum(sorted, idx+1, 0-sorted(idx))
          t.map(l => {
            List(l._1, l._2, sorted(idx)).sorted
          })
        }
      }.toList
    }
  }

  def twoSum(sorted: Array[Int], low: Int, target: Int): List[(Int, Int)] = {
    def inner(low: Int, high: Int, acc: List[(Int,Int)]): List[(Int,Int)] = {
      if(low >= high) acc
      else {
        if(sorted(low) + sorted(high) < target) inner(low+1, high, acc)
        else if(sorted(low) + sorted(high) > target) inner(low, high-1, acc)
        else {
          var newLow = low
          var newHigh = high
          while(sorted(newLow) == sorted(low) && newLow < high) newLow = newLow+1
          while(sorted(newHigh) == sorted(high) && newHigh > low) newHigh = newHigh-1
          inner(newLow, newHigh, acc :+ (sorted(low),sorted(high)))
        }
      }
    }
    inner(low, sorted.length-1, List())

  }

  //  println(twoSum(Array(-1,4,4,-4,0,1,4,2,-1,-4), 0))
//    println(threeSum(Array(-1,0,1,2,-1,-4)))
//    println(threeSum(Array(0, 0, 0)))
//    println(threeSum(Array(0, -1, 1)))
    println(threeSum(Array(3,0,-2,-1,1,2)))

}
