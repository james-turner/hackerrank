package HackerRank

object LongestSequence extends App {


  def longestSequence(s: String): (Char, Int) = {
    def inner(pos: Int, acc: (Char, Int), max: (Char, Int)): (Char, Int) = {
      if(pos >= s.length) if(acc._2 > max._2) acc else max
      else {
        if(s(pos) == acc._1) inner(pos+1, (acc._1, acc._2+1), max)
        else {
          val newMax = if(acc._2 > max._2) acc else max
          inner(pos+1, (s(pos),1), newMax)
        }
      }
    }
    inner(1, (s(0), 1), (s(0), 1))
  }

//  assert(longestSequence("abbbadddadd") == ('b', 3))
  assert(longestSequence("abbbaddddd") == ('d', 5))
  assert(longestSequence("dghhhmhmx") == ('h', 3))
  assert(longestSequence("dhkkhhkkkt") == ('k', 3))
  assert(longestSequence("abba") == ('b', 2))
}
