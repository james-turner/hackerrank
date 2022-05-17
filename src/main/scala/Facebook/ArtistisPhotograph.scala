package Facebook

import scala.collection.mutable.ListBuffer

object ArtistisPhotograph extends App {

  def exploreRight(C: String, search: Char, start: Int, X: Int, Y: Int) = {
    val count = ListBuffer[Int]()
    for (i <- X to Y) {
      if (start+i < C.length && C.charAt(start + i) == search) count.append(start + i)
    }
    count
  }

  def getArtisticPhotographCount(N: Int, C: String, X: Int, Y: Int) = { // Write your code here
    //.    "P.A.B"     "B.AAAAA.P"
    //    "APABA"
    //    N = 5
    //    X = 1
    //    Y = 2
    //    distance = 20
    val distance = Y - X
    var count = 0
    for (i <- 0 until C.length) {
      if (C.charAt(i) == 'P') { // explore right all As and then Bs within distance
        val As = exploreRight(C, 'A', i, X, Y)
        var j = 0
        while ( {
          j < As.length;
        }) {
          count += exploreRight(C, 'B', As(j), X, Y).length

          j += 1
        }
      }
      else if (C.charAt(i) == 'B') { // explore right all  As and then Ps within distance
        val As = exploreRight(C, 'A', i, X, Y)
        var j = 0
        while ( {
          j < As.length
        }) {
          count += exploreRight(C, 'P', As(j), X, Y).length

          j += 1
        }
      }
    }
    count
  }


  println(getArtisticPhotographCount(5, "APABA", 1, 2))
  println(getArtisticPhotographCount(5, "APABA", 2, 3))
  println(getArtisticPhotographCount(8, ".PBAAP.B", 1, 3))

}
