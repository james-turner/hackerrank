package LeetCode

object HappyString extends App {

  def getHappyString(n: Int, k: Int): String = {

    def dfs(counter: Int, acc: List[Char], todo: List[(Char,Int)]): List[Char] = {
      if(counter >= k) acc
      else {
        todo match {
          case Nil => List()
          case (curChar,depth) :: tail =>
            val newacc = acc.drop((acc.length+1)-depth)
            val candidates = if(depth < n) makeNextCandidates(curChar).map(c => (c, depth+1)) else List()
            val newcounter = if(depth == n) counter+1 else counter
            dfs(newcounter, curChar +: newacc, candidates ++ tail)
        }
      }
    }
    dfs(0, List(), List(('a',1),('b',1),('c',1))).reverse.mkString
  }

  def makeNextCandidates(c: Char): List[Char] = {
    val curIdx = c.toInt - 97
    val next1 = ((curIdx+1)%3)+97
    val next2 = ((curIdx+2)%3)+97
    List(Math.min(next1,next2).toChar, Math.max(next1,next2).toChar)
  }

//  assert(makeNextCandidates('a')==List('b','c'))
//  assert(makeNextCandidates('b')==List('a','c'))
//  assert(makeNextCandidates('c')==List('a','b'))

//  assert(getHappyString(2, 6) == "bc")
//  assert(getHappyString(2, 7) == "c")
//  assert(getHappyString(2, 8) == "ca")
//  assert(getHappyString(2, 9) == "cb")
  assert(getHappyString(3, 9) == "cab")
  assert(getHappyString(1, 4) == "")
  assert(getHappyString(10, 100) == "abacbabacb")

}
