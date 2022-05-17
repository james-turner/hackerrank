package HackerRank

import scala.collection.mutable

object Fibonacci extends App {

  def fibonacciDynamicProgramming(x:Int):BigInt = {
    val m = mutable.Map[Int,BigInt]()
    def inner(x: Int): BigInt ={
      if(x <= 1) x
      else
        m.getOrElseUpdate(x-2, inner(x-2)) +
        m.getOrElseUpdate(x-1, inner(x-1))

    }
    inner(x)
  }

  def fibonacciRecursive(i: Int): BigInt = {
    def inner(i: Int, pos: Int, acc: (Int,Int)): BigInt = {
      if(i <= 1) i
      else if(pos > i) acc._2
      else
        inner(i, pos+1, (acc._2,acc._1+acc._2))
    }
    inner(i,2,(0,1))
  }

  assert(fibonacciRecursive(0)==0)
  assert(fibonacciRecursive(1)==1)
  assert(fibonacciRecursive(2)==1) // (1,0)
  assert(fibonacciRecursive(3)==2) // (1,1)
  assert(fibonacciRecursive(4)==3) // (1,2)
  assert(fibonacciRecursive(5)==5) // (2,3)
  assert(fibonacciRecursive(6)==8)


}
