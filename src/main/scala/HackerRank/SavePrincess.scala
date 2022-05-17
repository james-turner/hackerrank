package HackerRank

import scala.collection.mutable

/**
 * There's a weird bit missing from the description for this as I
 * think it wants you to minimize the distance between you and the princess on each move.
 * e.g.
 * p-------
 * --------
 * -----m--
 * --------
 * --------
 * --------
 * --------
 * --------
 *
 * In order to minimize the distance on the first move i think you need to move left
 */
object SavePrincess extends App {

  /* Refer to Output format section for more details */
  def displayPathtoPrincess(n:Int,grid:Array[String])={
    // find m
    // find p
    // figure out optimal movement for m -> p
    var mX, mY = n/2

  }


  val n = scala.io.StdIn.readLine.toInt
  val grid = new Array[String](n)
  for (i <- 0 until n) {
    grid.update(i, scala.io.StdIn.readLine)
  }
  displayPathtoPrincess(n,grid)

}
