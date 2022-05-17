package Kickstart

object Allocation {

  def main(args: Array[String]): Unit = {

    val t = scala.io.StdIn.readLine().toInt

    (1 to t).foreach { i =>
      val Array(n, b) = scala.io.StdIn.readLine().split(' ').map(_.toInt)
      val as: Array[Int] = scala.io.StdIn.readLine().split(' ').map(_.toInt)
      System.out.println(s"Case #${i}: ${solve(0, as.sorted, b, 0)}")
      System.out.flush()
    }
  }

  def solve(pos: Int, a: Array[Int], b: Int, acc: Int): Int = {
    if(pos >= a.length) pos
    else if(acc + a(pos) > b) pos
    else solve(pos+1, a, b, acc+a(pos))
  }

}
