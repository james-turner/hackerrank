package LeetCode

object BinarySearches extends App {


  def binarySearch(sortedArray: Array[Int], value: Int):Boolean = {
    def inner(left: Int, right: Int):Boolean = {
      if(right == left) sortedArray(left) == value
      else {
        val midPoint = (left+right)/2
        if(value <= sortedArray(midPoint)) inner(left, midPoint)
        else inner(midPoint+1, right)
      }
    }
    inner(0, sortedArray.length-1)
  }

  assert(binarySearch(Array(1, 2, 3, 4, 5), 4))
  assert(!binarySearch(Array(1, 3, 3, 3, 4, 5), 2))

}
