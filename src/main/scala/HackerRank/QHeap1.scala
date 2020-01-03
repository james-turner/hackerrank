package HackerRank

import scala.collection.mutable

object Op extends Enumeration {
  type Op = Value
  val Add, Delete, Peek = Value
}

object QHeap1 {

  import Op._

  def main(args: Array[String]) = {
    val numQueries = scala.io.StdIn.readLine().trim.toInt
    val ops = (0 until numQueries).map { i =>
      val opAndMaybeValue = scala.io.StdIn.readLine().trim.split(" ")
      opAndMaybeValue(0).toInt match {
        case 1 => (Add, Some(opAndMaybeValue(1).toInt))
        case 2 => (Delete, Some(opAndMaybeValue(1).toInt))
        case 3 => (Peek, None)
      }
    }

    val heap = Array.fill(ops.length)(0)
    val index = mutable.Map[Int, Int]()
    var end = 0

    def parent(idx: Int) = (idx - 1) / 2

    def children(idx: Int) = ((idx * 2 + 1), (idx * 2 + 2))

    def swap(idx1: Int, idx2: Int) = {
      val tmp1 = heap(idx1)
      val tmp2 = heap(idx2)
      updateIndex(idx1, tmp2)
      updateIndex(idx2, tmp1)
      heap(idx1) = tmp2
      heap(idx2) = tmp1
    }

    def updateIndex(idx: Int, value: Int) = {
      index.put(value, idx)
    }

    def deleteIndex(value: Int) = {
      index.remove(value)
    }

    def bubbleUp(idx: Int) = {
      def inner(idx: Int): Int = {
        if (idx <= 0) idx
        else {
          val pIdx = parent(idx)
          if (heap(idx) < heap(pIdx)) {
            swap(idx, pIdx)
            inner(pIdx);
          } else idx
        }
      }

      inner(idx)
    }

    def pushDown(idx: Int) = {
      def inner(idx: Int): Int = {
        if (idx >= end) idx
        else {
          val (left, right) = children(idx)
          val candidate = if (heap(left) < heap(right)) left else right
          if (candidate < end && heap(idx) > heap(candidate)) {
            swap(idx, candidate)
            inner(candidate)
          } else idx
        }
      }

      inner(idx)
    }

    def add(num: Int): Unit = {
      heap(end) = num
      updateIndex(end, num)
      bubbleUp(end)
      end = end + 1
    }

    def delete(num: Int) = {
      // swap last element into deleted position
      val idx = index(num)
      deleteIndex(num)
      val last = heap(end - 1)
      end = end - 1
      heap(idx) = last
      updateIndex(idx, last)
      pushDown(idx)
    }

    def peek() = {
      heap.headOption.getOrElse(0)
    }

    ops.foreach { case (op, maybeInt) => {
      op match {
        case Add => add(maybeInt.getOrElse(0))
        case Delete => delete(maybeInt.getOrElse(0))
        case Peek => println(peek())
      }
    }
    }
  }
}
