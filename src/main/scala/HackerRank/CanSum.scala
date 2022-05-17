package HackerRank

import scala.collection.mutable

object CanSum extends App {

  def canSum(total: Int, nums: Array[Int]): Boolean = {
    val cache = Array.fill(total+1)(false)
    cache(0) = true
    (1 to total).foreach( i =>
      cache(i) = nums.foldLeft(false){ case (t,n) =>
        t||((i-n >= 0)&&(cache(i-n)))
      }
    )
    cache(total)
  }


  def canSum(total: Int, nums: Array[Int], memo: mutable.Map[Int,Boolean]): Boolean = {
    if(total == 0) true
    else if(total < 0) false
    else if(memo.contains(total)) memo(total)
    else {
      nums.foreach{ i =>
        val remainder = total - i;
        if(canSum(remainder, nums, memo)){
          memo.put(remainder, true)
          return true
        }
      }
      memo.put(total, false)
      false
    }

  }


  println(canSum(300, Array(7,14), mutable.Map()))

}
