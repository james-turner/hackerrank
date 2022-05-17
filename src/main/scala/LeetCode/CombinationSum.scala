package LeetCode
import scala.collection.mutable

object CombinationSum extends App {

    def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
      val l = mutable.ListBuffer[List[Int]]()
      def dfs(i: Int, cur: List[Int], total: Int): Unit = {
        if(total == target) l.addOne(cur)
        else if(i >= candidates.length || total > target) {}
        else {
          dfs(i, cur :+ candidates(i), total = total + candidates(i))
          dfs(i+1, cur, total)
        }
      }

      dfs(0, List(), 0)
      l.toList
    }

  println(combinationSum(Array(2,3,6,7), 7).map(_.mkString))

}
