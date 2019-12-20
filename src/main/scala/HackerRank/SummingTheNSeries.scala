package HackerRank

object SummingTheNSeries extends App {

  def summingSeries(n: Long): Int = {
    (BigInt(n).pow(2) % (BigInt(10).pow(9)+7)).toInt
  }

  val res: Int = summingSeries(2)
  assert(4 == res)
}
