package HackerRank

object NumWaysToN extends App {

  val dp = Array.fill(100)(0L)
  val n = 4
  val nums = Array(1,2,3)

//  dp(0) = 1
  def inner(target: Int): Long = {
    if(target == 0) 1
    else if(target > 0 && dp(target) > 0) dp(target)
    else if(target > 0){
      nums.foreach { n =>
          dp(target) = dp(target) + inner(target - n)
      }
      dp(target)
    }
    else 0
  }

  println(inner(n))


//  (1 to n).foreach(idx => {
//    nums.foreach { num =>
//      if(idx - num >= 0)
//        dp(idx) = dp(idx) + dp(idx - num)
//    }
//  })

  println(dp(n))


}
