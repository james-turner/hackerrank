package HackerRank

object KindergartenAdventure extends App {


  def solve(t: Array[Int]): Int = {
    val counters = Array.fill(t.length)(0)

    t.zipWithIndex.foreach { case (v,idx) =>
      val decIdx = (idx - v + t.length + 1) % t.length
      val incIdx = (idx + 1) % t.length
      counters(incIdx) = counters(incIdx) + 1
      counters(decIdx) = counters(decIdx) - 1
    }

    def inner(counters: Array[Int], pos: Int, acc: Int, max: (Int,Int)): Int = {
      if(pos >= counters.length) max._1
      else {
        val newAcc = acc  + counters(pos)
        if(newAcc > max._2) inner(counters, pos+1, newAcc, (pos,newAcc))
        else inner(counters, pos+1, newAcc, max)
      }

    }

    inner(counters, 0, 0, (0,counters(0)))+1
  }

  val res: Int = solve(Array(7, 1, 2, 0, 0, 1, 2, 3, 3, 3, 6))
  assert(res == 4)
}
