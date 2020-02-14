package HackerRank

import scala.annotation.tailrec

object ReducedString extends App {

  def superReducedString(s: String): String = {

    @tailrec
    def inner(pos: Int, str: String, stack: List[Char]): String = {
      if(pos >= str.length) stack.reverse.mkString
      else {
        val c = str(pos)
        stack match {
          case Nil => inner(pos+1, str, c +: stack)
          case head :: tail =>
            if(head == c) inner(pos+1, str, tail)
            else inner(pos+1, str, c +: stack)
        }

      }
    }

    val r = inner(0, s, List())
    if(r.length == 0) "Empty String"
    else r

  }

  assert(superReducedString("aaaabbbbccbbdddd") == "Empty String")
  assert(superReducedString("abccba") == "Empty String")

}
