package HackerRank

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object CountTriplets1 {

  // Complete the countTriplets function below.
//  def countTriplets(arr: Array[Long], r: Long): Long = {
//    val bag = arr.groupBy(identity).map{case(k,v) => (k,v.length) }
//    var acc = 0L
//    (0 until bag.size-2).foreach{ i =>
//      acc = acc + (bag(Math.pow(r,i).toLong) * bag(Math.pow(r,i+1).toLong) * bag(Math.pow(r,i+2).toLong))
//    }
//    acc
//  }

  def countTriplets(arr: Array[Long], r: Long): Long = {
    // 1 1 1 4 4 16 64 64 64 16 16 64 256
    // 1*3 4*2, 16*1
    // ((1,3), (4,2), (16,1)) * 6
    val buffer = new ArrayBuffer[(Long,Long)]()
    def collect(posA: Int, lastVal: Long, bufferPos: Int): Unit = {
      if(posA >= arr.length) return
      if(arr(posA) != lastVal){
        buffer.append((arr(posA), 1))
        collect(posA+1, arr(posA), bufferPos+1)
      } else {
        val prev = buffer(bufferPos)
        buffer(bufferPos) = (prev._1, prev._2+1)
        collect(posA+1, arr(posA), bufferPos)
      }
    }
    collect(0, 0, -1)
    val newArr = buffer.toArray
    var acc = 0L
    (0 until newArr.length-2).foreach { idx =>
      val v = newArr(idx)._1
      if(newArr(idx+1)._1 == v*r && newArr(idx+2)._1 == v*r*r){
        acc  = acc + (newArr(idx)._2 * newArr(idx+1)._2 * newArr(idx+2)._2)
      }
    }
    acc
  }

  def main(args: Array[String]) {

    val nr = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = nr(0).toInt

    val r = nr(1).toLong

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toLong)
    val ans = countTriplets(arr, r)

    println(ans)
  }
}
