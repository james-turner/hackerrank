package LeetCode

object MaximumLengthOfRepeatedSubarray extends App {

  def findLength(nums1: Array[Int], nums2: Array[Int]): Int = {
    val dp: Array[Array[Int]] = Array.fill(nums1.length)(Array.fill(nums2.length)(-1))

    def inner(y: Int, x: Int): Int = {
      if (y >= nums1.length || x >= nums2.length) 0
      else if (dp(y)(x) >= 0) dp(y)(x)
      else {
        if (nums1(y) == nums2(x)) {
          val res = inner(y + 1, x + 1) + 1
          dp(y)(x) = res
          res
        } else {
          dp(y)(x) = 0
          inner(y, x + 1)
          0
        }
      }
    }

    var max = 0
    nums1.indices.foreach { y =>
      nums2.indices.foreach { x =>
        max = Math.max(inner(y, x),max)
      }
    }
    // find max value
    max

  }

  //
    assert(findLength(Array(1,2,3,2,1), Array(3,2,1,4,7)) == 3)
    assert(findLength(Array(0,1,1,1,1), Array(1,0,1,0,1)) == 2)

  // [1,2,3,2,1]
  // [3,2,1,4,7]


  //   [1,2,3,2,1]
  //[3] 0 0 3 0 0
  //[2] 0 1 0 2 0
  //[1] 1 0 0 0 1
  //[4] 0 0 0 0 0
  //[7] 0 0 0 0 0

  //   [1,0,1,0,1]
  //[0] 0 2 0 2 0
  //[1] 0 0 1 0 1
  //[1] 0 0 0 0 0
  //[1] 0 0 0 0 0
  //[1] 0 0 0 0 0

  // [1,2,3,2,1]
  // [1]
  // [1,2]
  // [1,2,3]
  // [1,2,3,2]
  // [1,2,3,2,1]
  // [2]
  // [2,3]
  // [2,3,2]
  // [2,3,2,1]
  // [3]
  // [3,2]
  // [3,2,1]


  // [3,2,1,4,7]
  // [3]
  // [3,2]
  // [3,2,1]
  // [3,2,1,4]
  // [3,2,1,4,7]


  // 1,
  // max[1]
  // _,_,1,
  // _,_,_,_,_ ...

  // _,_,3,2,1
  // 3,2,1,


  // _,2
  // _,2
}
