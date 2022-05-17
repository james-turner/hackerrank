package HackerRank

import scala.annotation.tailrec

object StringSortingAlgo extends App {

  // so either sort letters within a string
  // or sort a bunch of strings

  // if string of letters need sorting, and fixed size of alphabet
  // use count sort
  val randomStr = "lskfjglskjeoesjvclkeklf"

  val sorted = randomStr.toCharArray.map(_.toInt - 97).foldLeft(Array.fill(26)(0)) { case (a, v) =>
    a(v) += 1
    a
  }.zipWithIndex.flatMap { case (v, idx) =>
    (0 until v).map(_ => (idx + 97).toChar);
  }

  println(sorted.mkString(","))

  // if array of strings (non-fixed size), O(logN)
  //
  def join(a: List[String], b: List[String]): List[String] = {
    @tailrec
    def inner(a: List[String], b: List[String], acc: List[String]): List[String] = (a,b) match {
      case (Nil, Nil) => acc
      case (Nil, remaining) => acc ++ remaining
      case (remaining, Nil) => acc ++ remaining
      case (head1::tail1, head2::_) if head1 < head2 => inner(tail1, b, acc :+ head1)
      case (head1::_, head2::tail2) if head1 >= head2 => inner(a, tail2, acc :+ head2)
    }
    inner(a, b, List())
  }

  def mergeSort(str: Array[String]): List[String] = {
    if(str.length > 1){
      val (l, r) = str.splitAt(str.length/2)
      join(mergeSort(l).toList, mergeSort(r).toList)
    } else str.toList
  }

  println(mergeSort(Array("a","b","d","c","e")).mkString(","))

}
