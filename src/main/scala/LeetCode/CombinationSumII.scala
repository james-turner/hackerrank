package LeetCode

import scala.collection.mutable

object CombinationSumII extends App {

    def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
      val newcandidates = candidates.sorted
      val l = mutable.ListBuffer[List[Int]]()
      def dfs(i: Int, cur: List[Int], total: Int): Unit = {
        if(total == target) l.addOne(cur)
        else if(i >= newcandidates.length || total > target) {}
        else {
          dfs(i+1, cur :+ newcandidates(i), total+newcandidates(i) )
          dfs(i+1, cur, total)
        }
      }

      dfs(0, List(), 0)
      l.toList.distinct
    }

  println(combinationSum2(Array(10,1,2,7,6,1,5), 8).map(_.mkString))

//  println(Set(Map(1->1,7->1), Map(7->1,1->1)))

//
//                       .
//            [10]                []
//     [10,1]       [10]   [1]          []


}
