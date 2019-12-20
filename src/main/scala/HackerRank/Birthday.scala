package HackerRank

object Birthday extends App {

  // Complete the birthday function below.
  def birthday(s: Array[Int], d: Int, m: Int): Int = {

    def inner(s: Array[Int], sum: Int, len: Int, pos: Int, running:BigInt, acc: Int): Int = {
      if(pos >= s.length) acc
      else if(pos < len-1)
        inner(s, sum, len, pos+1, running + s(pos), acc)
      else {
        val cur = running + s(pos)
        inner(s, sum, len, pos+1, cur - s(pos-len+1), if(cur == sum) acc+1 else acc)
      }
    }

    inner(s,d,m,0,0,0)
  }

//  assert(birthday(Array(),10,10) == 0)
  assert(birthday(Array(2,2,1,3,2,2),4,2) == 3)

}
