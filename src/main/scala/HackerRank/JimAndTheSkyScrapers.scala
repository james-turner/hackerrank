package HackerRank

object JimAndTheSkyScrapers extends App {

  def solve(arr: Array[Int]): Long = {
    def inner(pos: Int, arr: Array[Int], stack: List[(Int,Int)], acc: Long): Long = pos match {
      case _ if pos >= arr.length => acc + stack.map{case (i,count) => count.toLong * (count-1).toLong}.sum
      case _ =>
        val nextV = arr(pos)
        stack match {
          case (i,count) :: tail if nextV > i => {
            val (add, remaining) = take(stack, nextV, 0)
            inner(pos, arr, remaining, acc + add)
          }
          case (i,count) :: tail if i == nextV => inner(pos+1, arr, (nextV,count+1) +: tail, acc)
          case _ => inner(pos+1, arr, (nextV,1) +: stack, acc)
        }
    }
    inner(0, arr, List(),0)
  }

  def take(l: List[(Int,Int)], v: Int, acc: Long): (Long,List[(Int,Int)]) =  l match {
    case head :: tail if v > head._1 => take(tail, v, acc + (head._2.toLong * (head._2.toLong-1)))
    case remaining => (acc,remaining)
  }

  assert(solve(Array(6,6,5,5,4,4,3,3,2,2,1,1,2,3,4,5,6))==2+6+6+6+6+6)
//  println((Stack(1) :+ 2 :+ 3 :+ 4).takeWhile(_ < 3))

}
