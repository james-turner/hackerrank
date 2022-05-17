package HackerRank

object GameOfTwoStacks extends App {

  def twoStacks(x: Int, a: Array[Int], b: Array[Int]): BigInt = {
    def inner(posA: Int, posB: Int, acc: (BigInt,BigInt)): BigInt = {
      if(posA >= a.length && posB >= b.length) acc._1
      else {
        val (newAcc, incA, incB) = if(posA >= a.length) (acc._2 + b(posB), 0, 1) else if(posB >= b.length)  (acc._2 + a(posA), 1, 0) else {
          if(a(posA) < b(posB)) (acc._2 + a(posA),1,0) else (acc._2 + b(posB),0,1)
        }
        if(newAcc > x) acc._1
        else inner(posA+incA, posB+incB, (acc._1+1, newAcc))
      }

    }
    inner(0, 0, (0,0))
  }

}
