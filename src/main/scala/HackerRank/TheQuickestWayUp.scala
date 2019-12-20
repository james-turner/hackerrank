package HackerRank

import scala.collection.immutable.Queue
import scala.collection.mutable

object TheQuickestWayUp extends App {

  def bfs(skips: Map[Int, Int]): Int = {
    def inner(todo: Queue[(Int, Int)], seen: mutable.Set[Int]): Int = {
      if(todo.isEmpty) -1
      else {
        val ((head, d),tail) =  todo.dequeue
        if(head==100) d
        else if(seen.contains(head)) inner(tail, seen)
        else {
          val nexts = (head+1 to head+6)
            .filter(_ <= 100)
            .map(next => skips.getOrElse(next, next))
            .filterNot(seen.contains)
            .map(v => (v,d+1))
          inner(tail ++ nexts, seen + head)
        }
      }
    }
    inner(Queue((1, 0)), mutable.Set())
  }

  def quickestWayUp(ladders: Array[Array[Int]], snakes: Array[Array[Int]]): Int = {

    val edges = bfs(ladders.map(v => (v(0), v(1))).toMap ++ snakes.map(v => (v(0), v(1))).toMap)
    edges
  }

  println(quickestWayUp(Array(Array(32, 62), Array(42, 68), Array(12, 98)), Array(Array(95, 13), Array(97, 25), Array(79, 27), Array(75, 19), Array(49, 47), Array(67, 17))))

}
