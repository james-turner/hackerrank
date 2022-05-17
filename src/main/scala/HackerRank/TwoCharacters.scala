package HackerRank
import scala.collection.mutable

object TwoCharacters extends App {
  def alternate(s: String): Int = {
    val m = mutable.Map[Char, (List[Set[Char]], Set[Char])]()
    s.foreach(c => {
      if(c == 'a'){
        val (_, omit) = m.getOrElse(c, (List[Set[Char]](),Set[Char]()))
        m.put(c, (List[Set[Char]](), omit))
      } else {
        val (keep, omit) = m.getOrElse('a', (List[Set[Char]](),Set[Char]()))

      }
    })
    print(m)
    1

  }


//  assert(alternate("ababababababababa")==17)
//  assert(alternate("abcabcabcabc")==17)
  assert(alternate("abcddbabddbacbabbd")==17)

}
