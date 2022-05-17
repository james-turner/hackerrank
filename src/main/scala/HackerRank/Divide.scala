package HackerRank

import scala.annotation.tailrec

object Divide extends App {

  def divide(dividend: Int, divisor: Int): Int = {
    if(dividend == 0) return 0
    if(divisor == 1) return dividend

    val sign = if(dividend < 0 ^ divisor < 0) -1 else 1;

    def inner(num: Int, divisor: Int, quotient: Int): Int = {
      if(num < divisor) quotient
      else inner(num - divisor, divisor, quotient + 1)
    }

    val fixedDividend = if(dividend == Int.MinValue) dividend+1 else dividend // boundary case
    val res = inner(Math.abs(fixedDividend), Math.abs(divisor), 0)
    res * sign
  }

  println (divide(-2147483648,-2147483648))
}
