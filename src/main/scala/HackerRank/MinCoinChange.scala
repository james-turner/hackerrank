package HackerRank

object MinCoinChange extends App {

  val dp = Array.fill(100)(Int.MaxValue)
  dp(0) = 0
  val coins = Array(1,2,5)
//  coins.foreach(c => dp(c) = 1)
  val n = 11

  (1 to n).foreach(value => {
    coins.foreach { coin =>
      if(value - coin >= 0)
        dp(value) = Math.min(dp(value), dp(value - coin) +1)
    }
  })

  println(dp(n))





}
