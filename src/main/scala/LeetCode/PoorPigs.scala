package LeetCode

import scala.annotation.tailrec
import scala.collection.mutable

object PoorPigs extends App {

  def poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int = {
    val rounds = minutesToTest/minutesToDie

    // ----
    //
    // ----------
    //
    // ----------
    //
    // ----------
    //    ^^
    //     ^^
    // ----------
    // ^^
    //  ^^

    // -----
    // ^^
    //  ^^
    //   ^^
    // 1210

1
  }

//0  1
//1  1 1
//2  1 2 1
//3  1 3 3 1
//4  1 4 6 4 1
//5  1 5 10 10 5 1

  def pascal(depth: Int, indent: Int, dp: mutable.Map[(Int,Int), Int]): Int = {
    if(indent > depth) throw new RuntimeException("Out of bounds indent")
    if(dp.contains((depth, indent))) dp((depth,indent))
    else if(depth == 0 || indent == 0 || indent == depth) 1
    else {
      val v = pascal(depth-1, indent-1, dp) + pascal(depth-1, indent, dp)
      dp((depth, indent)) = v
      v
    }
  }

//  println(pascal(0, 0, mutable.Map()))

  def pascalBuildUp(depth: Int): Map[(Int,Int),Int] = {
    @tailrec
    def inner(currentDepth: Int, acc: Map[(Int,Int), Int]): Map[(Int,Int), Int] = {
      if(currentDepth > depth) acc
      else {
        val m = (1 until currentDepth).map { indent =>
          (currentDepth, indent) -> (acc(currentDepth-1, indent-1) + acc(currentDepth-1, indent))
        }.toMap
        inner(currentDepth+1, Map((currentDepth,0)->1, (currentDepth,currentDepth)->1) ++ m ++ acc)
      }
    }
    inner(1, Map((0,0)->1))
  }

  val m = pascalBuildUp(5)
  println(m.get(5,2))




//  assert(poorPigs(1000, 15, 60) == 5)
//  assert(poorPigs(4, 15, 15) == 2)
//  assert(poorPigs(4, 15, 30) == 2)
}
