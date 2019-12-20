package HackerRank

object Rotations extends App {


    def inner(a: Array[Int], d: Int, n: Int, pos: Int): Unit = {
      if (pos == n) {
        print("")
      } else {
        print(s"${a((d + pos) % n)} ")
        inner(a, d, n, pos + 1)
      }
    }
    inner(Array(1,2,3,4,5),4,5,0)


}
