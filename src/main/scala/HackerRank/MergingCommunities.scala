package HackerRank

import scala.collection.mutable

object MergingCommunities extends App {

  val Array(n,q) = scala.io.StdIn.readLine().split(" ").map(_.toInt)
  val communities: Array[mutable.Set[Int]] = (0 to n).map { c => mutable.Set(c) }.toArray
  val ops = (0 until q).map { idx =>
    scala.io.StdIn.readLine().split(" ")
  }

  ops.foreach{ op =>
    if(op(0)=="M"){
      val setA = communities(op(1).toInt)
      val setB = communities(op(2).toInt)
      if(!(setA eq setB)){
        if(setA.size > setB.size){
          setB.foreach(setA.add)
          setB.foreach(i => communities(i) = setA)
        } else {
          setA.foreach(setB.add)
          setA.foreach(i => communities(i) = setB)
        }
      }
//      newSet.foreach(idx => communities(idx) = newSet)
    }
    if(op(0)=="Q"){
      println(communities(op(1).toInt).size)
    }
  }

}

// Input example
//3 6
//Q 1
//M 1 2
//Q 2
//M 2 3
//Q 3
//Q 2
