package HackerRank

object NumOfSubsetsTotal extends App {

  def countSets(arr: Array[Int], total: Int): Int = {
    def inner(arr: Array[Int], pos: Int, total: Int): Int = {
      total match {
        case 0 => 1
        case _ if pos < 0 => 0
        case _ if total < arr(pos) => inner(arr, pos-1, total)
        case _ =>
          inner(arr, pos-1, total - arr(pos)) + inner(arr, pos-1, total)
      }
    }
    inner(arr, arr.length - 1, total)
  }

  println(countSets(Array(2,4,6,10), 8))

  Array(2,4,6,10).toSet.subsets
  Array.ofDim(1,1)

}
