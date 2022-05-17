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

  val total = (0 until 1000).foldLeft(0L){ case(acc,_) =>
    val time = System.nanoTime()
    val allTheInts = List.fill(1000)(Random.nextInt(100))
    mergeSort(allTheInts)
    val finish = System.nanoTime()
    acc + (finish - time)
  }
  println(s"Average time: ${(total / 1000)/100000}ms")
}
