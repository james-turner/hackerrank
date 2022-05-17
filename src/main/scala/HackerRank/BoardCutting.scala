package HackerRank

import java.io.PrintWriter

object BoardCutting {

  def boardCutting(cost_y: Array[Int], cost_x: Array[Int]): Int = {

    //  [4,6] 1section  [3, 7, 7] 1section
    // pick the 7 over anything               -> 7
    //  [4,6] 1section  [3, X, 7] 2sections
    // choices are 4*2, 6*2, 3*1, 7*1         -> 14 (choice of 7)   vs 19 (choice of 6)
    //  [4,6] 1section  [3, X, X] 3sections
    // choices are 4*3, 6*3, 3*1              -> 14+18 (choice of 6) vs 19+14 (choice of 7)

    //    // for each cut
//    val sortedY = cost_y.zipWithIndex.sortBy(_._1).map(_._2).toList
//    val sortedX = cost_x.zipWithIndex.sortBy(_._1).map(_._2).toList
//
//    def inner(x_costs: List[Int], y_costs: List[Int], x_cuts: Int, y_cuts: Int, cost: Int): Int = {
//      (x_costs, y_costs) match {
//        case (Nil, Nil) => cost
//        case (head1::tail1, head2::tail2) =>
//          if(head1 * x_cuts < head2 * y_cuts) inner(tail1, y_costs, x_cuts+1, y_cuts, cost + (x_cuts*cost_x(head1)))
//        case (Nil, head2::tail2) =>
//        case (head1::tail1, Nil) =>
//      }
//    }
//
//    // return/break loop
//    inner(sortedX, sortedY, 0, 0, 0)
    0
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val mn = stdin.readLine.split(" ")

      val m = mn(0).trim.toInt

      val n = mn(1).trim.toInt

      val cost_y = stdin.readLine.split(" ").map(_.trim.toInt)

      val cost_x = stdin.readLine.split(" ").map(_.trim.toInt)
      val result = boardCutting(cost_y, cost_x)

      printWriter.println(result)
    }

    printWriter.close()
  }

  /**
   * Sample input
   * 1
   * 2 2
   * 2
   * 1
   *
   * Expected output
   * 4
   *
   * Sample input
   * 1
   * 6 4
   * 2 1 3 1 4
   * 4 1 2
   *
   * Expected output
   * 42
   */
}
