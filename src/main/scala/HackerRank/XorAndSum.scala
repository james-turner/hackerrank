package HackerRank

object XorAndSum extends App {

  val a = BigInt(Integer.parseInt("10", 2))
  val b = BigInt(Integer.parseInt("1010", 2))
  var sum = BigInt(0)
  (0 to 314159).foreach { i=>
    sum = sum + (a ^ (b << i))
  }

  println(sum % (Math.pow(10,9)+7).toInt)

}
