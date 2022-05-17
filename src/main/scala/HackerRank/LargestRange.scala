package HackerRank
import scala.collection.mutable
import scala.collection.mutable.BitSet
object LargestRange extends App {

//  def largestRange(a: Array[Int]): Array[Int] = {
//
//    val bs = BitSet()
//    a.foreach { v =>
//      bs.add(v)
//    }
//    var max = 0L
//    var acc = 0L
//    var last = -1
//    bs.foreach { v =>
//      println(v)
//      if(v != last+1){
//        if(acc > max) max = acc
//        acc = 0
//        last = v
//      } else {
//        last = v
//        acc = acc+1
//      }
//    }
//    if(acc > max) max = acc
//    Array(1,1)
//
//  }

//  def largestRange(a: Array[Int]): Array[Int] = {
//
//    val bs = mutable.Map[Int,Int]()
//    a.foreach { v =>
//      bs.put(v, 0)
//    }
//
//    var maxLeft, maxRight = 0
//    a.foreach {
//      var left, right = 0
//      while(left >= 0){
//        left = left+1
//      }
//      while(right < a.length){
//        right = right+1
//      }
//    }
//
//    Array(1,1)
//
//  }
//
//  largestRange(Array(1,11,3,0,15,5,2,4,10,7,12,6))

}
