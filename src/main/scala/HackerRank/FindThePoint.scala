package HackerRank

object FindThePoint extends App {


  def findPoint(px: Int, py: Int, qx: Int, qy: Int): Array[Int] = {
    /*
     * Write your code here.
     */
    Array(qx+(qx - px), qy+(qy-py))
  }


  assert(findPoint(0, 0, 1, 1) sameElements Array(2,2))
  assert(findPoint(1, 1, 2, 2) sameElements Array(3,3))
}
