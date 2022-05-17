package HackerRank

import scala.collection.mutable.ListBuffer

object Encryption extends App {

  def encryption(s: String): String = {

    var row, col = 0
    val sqrt = Math.sqrt(s.length)
    if (Math.floor(sqrt) == Math.ceil(sqrt)) {
      row = sqrt.toInt
      col = row
    } else if (Math.floor(sqrt) * Math.ceil(sqrt) >= s.length) {
      row = Math.floor(sqrt).toInt
      col = Math.ceil(sqrt).toInt
    } else {
      row = Math.ceil(sqrt).toInt
      col = row
    }

    println(s"$row, $col")


    val l = ListBuffer[Char]()
    (0 until col).foreach { c=>
      (0 until row).foreach { r =>
        if(c + col*r < s.length)
          l += s(c + col*r)
      }
      l += ' '
    }
    l.mkString("").trim
  }


  assert(encryption("haveaniceday") == "hae and via ecy")
  private val str: String = encryption("feedthedog")
  assert(str == "fto ehg ee dd")


}
