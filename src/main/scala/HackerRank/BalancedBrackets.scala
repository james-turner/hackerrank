package HackerRank

object BalancedBrackets extends App {


  // Complete the isBalanced function below.
  def isBalanced(s: String): String = {
    val m: Map[Char, Char] = Map('}'->'{',')'->'(',']'->'[')
    val closing = m.keySet
    val opening = m.values.toSet
    def inner(pos: Int, s: String, stack: List[Char]): String = pos match {
      case _ if pos >= s.length && stack.nonEmpty => "NO"
      case _ if pos >= s.length && stack.isEmpty => "YES"
      case _ =>
        val c = s.charAt(pos)
        c match {
          case _ if opening.contains(c) => inner(pos+1,s,stack :+ c)
          case _ if closing.contains(c) && m(c) == stack.lastOption.getOrElse("") => inner(pos+1,s,stack.dropRight(1))
          case _ => "NO"
        }
    }
    inner(0, s, List())
  }

  println(isBalanced("}][}}(}][))]"))

}
