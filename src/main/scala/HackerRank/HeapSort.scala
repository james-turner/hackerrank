package HackerRank

object HeapSort extends App {


  class MaxHeap(val arr: Array[Int] = Array()) {

    private def parent(p: Int): Int = (p - 1) / 2
    private def child(p: Int): (Int,Int) = ((p*2)+1,(p*2)+2)

    def insert(v: Int): MaxHeap = {
      val newArray = arr ++ Array(v)
      var pos: Int = newArray.length - 1
      while(pos != 0 && (v > newArray(parent(pos)))){
        val tmp = newArray(parent(pos))
        newArray(parent(pos)) = v
        newArray(pos) = tmp
        pos = parent(pos)
      }
      new MaxHeap(newArray)
    }

    def peek(): Option[Int] = {
      arr.headOption
    }

    def take(): (Option[Int], MaxHeap) = {
      // heapify down
      val peeked = peek()
      val pos = 0

      (peeked, new MaxHeap())
    }
  }



  def loop(heap: MaxHeap, iters: Int): MaxHeap = {
    iters match {
      case 0 => heap
      case _ => {
        loop(heap.insert((Math.random()*1000).toInt), iters - 1)
      }
    }
  }


  val heap = loop(new MaxHeap(), 1000)
  println(heap.arr.mkString(","))

}
