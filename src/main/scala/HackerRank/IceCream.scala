package HackerRank

object IceCream extends App {

  def icecreamParlor(m: Int, arr: Array[Int]): Array[Int] = {
    val map = arr.zipWithIndex.groupBy(_._1).map(t => (t._1, t._2.map(_._2 + 1)))
    def inner(m: Int, arr: Array[Int], pos: Int): Array[Int] = {
      val diff = m - arr(pos)
      map.contains(diff) match {
        case true if diff == arr(pos) && map.getOrElse(diff, Array()).length > 1 => map.getOrElse(diff,Array()).take(2)
        case true if diff != arr(pos) => Array(map.getOrElse(diff, Array()).head, map.getOrElse(arr(pos), Array()).head)
        case _ => inner(m, arr, pos+1)
      }
    }
    inner(m,arr,0).sorted
  }

  assert(icecreamParlor(4, Array(1, 4, 5, 3, 2)) sameElements Array(1, 4))
  assert(icecreamParlor(4, Array(2, 2, 1, 4)) sameElements Array(1, 2))
}
