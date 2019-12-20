package HackerRank

import scala.collection.mutable

object RoadsAndLibraries extends App {

  // Complete the roadsAndLibraries function below.
  def roadsAndLibraries(n: Int, c_lib: Long, c_road: Long, cities: Array[Array[Int]]): Long = {
    if(c_road >= c_lib) n * c_lib
    else {
      val adjList = buildAdjList(cities)
      def inner(pos: Int, seen: Set[Int], acc: Long): Long = {
        if(pos > n) acc
        else if(seen.contains(pos)) inner(pos+1, seen, acc)
        else {
          val collected = dfs(adjList, Set(), Set(pos))
          inner(pos+1, seen ++ collected, acc + (collected.size-1)*c_road + c_lib)
        }
      }
      inner(1, Set(), 0L)
    }
  }

  def dfs(adjList: Map[Int, Set[Int]], seen: Set[Int], todo: Set[Int]): Set[Int] = {
    todo match {
      case _ if todo.isEmpty => seen
      case _ =>
        val neighbours = adjList.getOrElse(todo.head, mutable.Set[Int]())
        dfs(adjList, seen + todo.head, (todo - todo.head) ++ neighbours.diff(seen))
    }
  }

  def buildAdjList(cities: Array[Array[Int]]): Map[Int, Set[Int]] = {
//    val m  = mutable.Map[Int,mutable.Set[Int]]()
    cities.foldLeft(Map[Int,Set[Int]]()){ case (map, v) =>
      map + (v(0)->(map.getOrElse(v(0), Set()) + v(1))) + (v(1)->(map.getOrElse(v(1), Set()) + v(0)))
    }
//    cities.foreach { a =>
//      m.getOrElseUpdate(a(0), mutable.Set[Int]()).add(a(1))
//      m.getOrElseUpdate(a(1), mutable.Set[Int]()).add(a(0))
//    }
//    m
  }


  assert(roadsAndLibraries(8, 3, 2, Array(Array(1,2),Array(2,3),Array(1,3),Array(1,1),Array(4,5),Array(5,6),Array(6,7))) == 19)

}
