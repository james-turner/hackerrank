package HackerRank

object SherlockAndValidString extends App {

  def isValid(s: String): String = {
    val counts = s.toCharArray.groupBy(identity).map{case(c, a) => (c,a.length)}
    val freqs: Map[Int, Int] = counts.groupBy{ case(_, i) => i}.map{case (freq, c) => (freq, c.size)}

    if(freqs.size <= 1) "YES"
    else if(freqs.size > 2) "NO"
    else {
      freqs.get(1) match {
        case Some(v) if v==1 => "YES"
        case _ => {
          val Array(k1, k2) = freqs.keys.toArray
          val k = Math.max(k1,k2)
          if(k-1 == Math.min(k1,k2) && freqs.getOrElse(k, 0) == 1) "YES"
          else "NO"
        }
      }

    }
  }

  assert(isValid("abbc") == "YES")
  assert(isValid("abccc") == "NO")
  assert(isValid("aabbcd") == "NO")
  assert(isValid("aabbccddeefghi") == "NO")

}
