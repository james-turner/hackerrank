package HackerRank

import scala.util.Random

object MergeSort extends App {

  private def merge[T](sortedListA: List[T], sortedListB: List[T])(implicit ordering: Ordering[T]) = {
    import ordering._
    def inner(listA: List[T], listB: List[T], acc: List[T]): List[T] = {
      (listA, listB) match {
        case (Nil, Nil) => acc
        case (Nil, remaining) => acc ++ remaining
        case (remaining, Nil) => acc ++ remaining
        case (h1::tail1, h2::tail2) =>
          if(h1 <= h2) inner(tail1, listB, acc:+h1)
          else inner(listA, tail2, acc:+h2)
      }
    }
    inner(sortedListA, sortedListB, List())
  }


  def mergeSort[T](list: List[T])(implicit ordering: Ordering[T]): List[T] = {
   if(list.length > 1){
     val (l, r) = list.splitAt(list.length/2)
     merge(mergeSort(l), mergeSort(r))
   } else list
  }

  val allTheInts = List.fill(100)(Random.nextInt(100))
  val res = mergeSort(allTheInts)
  res.foreach(println)
}
