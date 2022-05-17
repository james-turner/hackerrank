package Facebook

object ContigiousSubArrays extends App {

    // Call countSubarrays() with test cases here
    val ret = countSubarrays(Array(3,4,1,6,2))
    assert(ret == Array(1,3,1,5,1))

  def countSubarrays(arr: Array[Int]) : Array[Int] = {

    val lefts = Array.fill(arr.length)(0)
    val rights = Array.fill(arr.length)(0)

    (1 until arr.length).foreach { idx =>
      if(arr(idx) > arr(idx-1)) lefts(idx) = lefts(idx-1)+1
    }
    (arr.length-2 to 0 by -1).foreach { idx =>
      if(arr(idx) > arr(idx+1)) rights(idx) = rights(idx+1)+1
    }

    (0 until arr.length).map { idx =>
      lefts(idx) + rights(idx) + 1
    }.toArray

  }
}
