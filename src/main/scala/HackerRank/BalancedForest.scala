package HackerRank

import scala.collection.mutable.ListBuffer

object BalancedForest extends App {


  // Complete the balancedForest function below.
  def balancedForest(c: Array[Int], edges: Array[Array[Int]]): Int = {
    1
  }

  def buildTree(c: Array[Int], edges: Array[Array[Int]]): Array[List[Int]] = {
    val graph = Array.fill(c.length+1)(ListBuffer[Int]())
    edges.foreach { edge =>
      val Array(a,b) = edge
      graph(a).append(b)
      graph(b).append(a)
    }
    graph.map(_.toList)
  }

  val c = Array(1,2,2,1,1)
  val edges = Array(Array(1,2),Array(1,3),Array(3,5),Array(1,4))
//  val result = balancedForest(c, edges)


  buildTree(c, edges).zipWithIndex.map{case(v,idx) => s"$idx -> ${v.mkString(",")}"}.foreach(println)
}
