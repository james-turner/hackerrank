package HackerRank

object Abbreviation {


  def abbreviation(a: String, b: String): String = {
    // Complete this function
    def inner(a: List[String],b: List[String]): Boolean = {
      a match {
        case Nil if b.nonEmpty => false
        case Nil if b.isEmpty => true
        case first :: tail if b.isEmpty && first.toLowerCase == first => inner(tail,b)
        case _ if b.isEmpty => false
        case first :: _ if first.toUpperCase == first && first != b.head => false
        case first :: tail if first.toUpperCase == first && first.toUpperCase == b.head => inner(tail,b.tail)
        case first :: tail if first.toLowerCase == first && first.toUpperCase == b.head => inner(tail,b) || inner(tail,b.tail)
        case _ :: tail => inner(tail,b)
      }
    }
    inner(a.split("").toList,b.split("").toList) match {
      case false => "NO"
      case true => "YES"
    }
  }

  def main(args: Array[String]) {
//    val a = "AbcDE"
//    val b = "ABDE"
//    println(abbreviation(a,b))
    List(
      ("KXzQ","K","NO"),
      ("ABCD","ABCDE","NO"),
      ("AbCd","ABCD","YES"),
      ("AAAAAAAaaaaaaaBbBbBbCcCCCCCCcccccDDDD","ABCD","NO"),
      ("AaaaaaaaBbbbbbCccccccDdddd","ABCD","YES"),
      ("AAAAAAAaaaaaaaBbBbBbCcCCCCCCcccccDDDDeeee","ABCD","NO"),
      ("aaaaAbbbbbBccccCddddD", "ABCD","YES"),
      ("abcd","ABCDEF","NO")
    ).foreach {
      case(a,b,res) =>
        val abbr = abbreviation(a, b)
        assert(abbr == res, s"$a -> $b was $abbr but should have been $res")
    }
  }

}
