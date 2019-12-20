package HackerRank

object MaxSubsetSum extends App {

  def maxSubsetSum(arr: Array[Int]): Long = {
    def inner(arr: Array[Int], pos: Int, acc: Array[Long]): Long = {
      if (pos >= arr.length) acc.max
      else {
        if(pos == 0) acc(0) = arr(0)
        else if(pos == 1) acc(1) = Math.max(acc(0),arr(1))
        else acc(pos) = Math.max(Math.max(arr(pos), acc(pos-2)+arr(pos)), acc(pos-1))
        inner(arr, pos+1, acc)
      }
    }
    inner(arr, 0, Array.fill(arr.length)(0))
  }

  assert(maxSubsetSum(Array(3,7,4,6,5)) == 13)
  assert(maxSubsetSum(Array(3,5,-7,8,10)) == 15)
  assert(maxSubsetSum(Array(1,2,3,4,5,6,7,8,9,10)) == 10+8+6+4+2)

}
