package HackerRank

import scala.annotation.tailrec
import scala.collection.mutable

object DigitalIslands extends App {

  // given an island in matrix form
  // determine a) how many continents there are
  // determine b) which points border the box (by proxy)


  val m = Array(
    Array(0,1,0,0,0,0),
    Array(0,0,1,0,1,0),
    Array(1,1,0,1,1,0),
    Array(0,0,0,1,0,0),
    Array(0,0,0,1,0,0)
  ) // there are 4 continents
  // there is 1 pixel that does not border by proxy
  val visited = mutable.Set[(Int, Int)]() // catalogue whether we've seen this item or not
  val n = Array.fill(m.length)(Array.fill(m(0).length)(0))

  // both require graph solutions

  def isBorder(x: Int, y: Int) = (x < 0 || x >= m(0).length) || (y < 0 || y >= m.length)
  def findNeighbours(x: Int, y: Int): List[(Int,Int)] = {
    List((x-1, y),
    (x+1, y),
    (x, y+1),
    (x, y-1)).filterNot{case(x,y) => isBorder(x,y)}.filterNot(visited.contains)
  }

  def dfs(m: Array[Array[Int]], pos: (Int, Int)): List[(Int,Int)] = {
    @tailrec
    def inner(todo: List[(Int,Int)], acc: List[(Int,Int)]): List[(Int,Int)] = todo match {
      case Nil => acc
      case head :: tail =>
        if(m(head._2)(head._1) == 0 || visited.contains(head)) {
          inner(tail, acc)
        } else {
          visited.add(head._1, head._2)
          inner(tail ++ findNeighbours(head._1, head._2), acc :+ head)
        }
    }
    inner(List(pos), List())
  }

  m.indices.foreach{ y =>
    m(y).indices.foreach { x =>
      val res = dfs(m, (x,y)).mkString(",")
      if(res.length > 0){
        println(res)
      }
    }
  }

  val sign = if(-2147483648 < 0 ^ -1 < 0) -1 else 1
  println(sign)

}
