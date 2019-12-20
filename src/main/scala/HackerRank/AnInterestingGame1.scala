package HackerRank

object AnInterestingGame1 extends App {

  def gamingArray(arr: Array[Int]): String = {
    // Write your code here
    def inner(pos: Int, arr: Array[Int], max: Int, acc: Int): Int = {
      pos match {
        case _ if pos >= arr.length => acc
        case _ =>
          val newMax = Math.max(arr(pos),max)
          inner(pos+1,arr,newMax,if(newMax > max) acc+1 else acc)
      }

    }

    inner(0, arr, 0, 0) % 2 match {
      case 0 => "ANDY"
      case 1 => "BOB"
    }
  }


  assert(gamingArray(Array(5, 2, 6, 3, 4)) == "ANDY")
  assert(gamingArray(Array(1, 3, 5, 7, 9)) == "BOB")
  assert(gamingArray(Array(7, 4, 6, 5, 9)) == "ANDY")


}
