package HackerRank

import scala.util.Random

object LargestBlock extends App {

  val display = Array.fill(10,10){
    val v = Array("r","g","b")
    v(Random.nextInt(3))
  }


  display.foreach{ row =>
    println(row.mkString(" "))
  }
}
