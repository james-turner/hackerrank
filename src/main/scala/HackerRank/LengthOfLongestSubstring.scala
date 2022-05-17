package HackerRank

object LengthOfLongestSubstring extends App {

  def lengthOfLongestSubstring(s: String): Int = {
    def inner(current: (Int, Int), best: Int, seen: Map[Char,Int]): Int = {
      val pos = current._2
      if(pos >= s.length) return Math.max(best, current._2-current._1)
      val chr = s(pos)
      if(seen.contains(chr)){
        val lastPos = seen.getOrElse(chr, pos)
        inner((lastPos+1,pos+1), Math.max(best, current._2-current._1), seen + (chr->pos))
      } else inner((current._1, current._2+1), best, seen + (chr->pos))
    }

    inner((0, 0), 0, Map())
  }

  println(lengthOfLongestSubstring("abcdabcdefabcdeddf"))

}
