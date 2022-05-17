package HackerRank

object MinHeap extends App {

  val heap = new MinHeap(Array(7, 6, 5, 4, 3, 2, 1))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))
  println(heap.dequeue().getOrElse(-1))
  println(heap.a.mkString(","))

}

class MinHeap(val a: Array[Int]) {


  var lastPos = a.length - 1
  val parent = (n: Int) => (n - 1) / 2
  val children = (n: Int) => (n * 2 + 1, n * 2 + 2)

  (0 until a.length).foreach { idx =>
    pushDown(idx, lastPos, a)
  }

  def pushDown(pos: Int, lastPos: Int, a: Array[Int]): Array[Int] = {
    if (pos > lastPos) a
    else {
      val (l, r) = children(pos)
      if (l > lastPos) a
      else {
        val candidate = if (a(l) <= a(r)) l else if (r > lastPos) l else r
        if (a(candidate) < a(pos)) {
          swap(candidate, pos)
          pushDown(candidate, lastPos, a)
        }
        else a
      }
    }
  }

  def swap(idx1: Int, idx2: Int) = {
    val tmp = a(idx1)
    a(idx1) = a(idx2)
    a(idx2) = tmp
  }

  def dequeue(): Option[Int] = {
    if (lastPos < 0) None
    else {
      val r = a(0)
      a(0) = a(lastPos)
      lastPos = lastPos - 1
      pushDown(0, lastPos, a)
      Some(r)
    }
  }

}
