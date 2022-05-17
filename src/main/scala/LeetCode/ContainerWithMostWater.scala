package LeetCode

object ContainerWithMostWater extends App {

  def maxArea(height: Array[Int]): Int = {
    val left = 0
    val right = height.length-1
    def inner(left: Int, right: Int, max: Int): Int = {
      if(left==right) max
      else if(height(left) < height(right)) inner(left+1, right, Math.max(max,Math.min(height(left), height(right)) * (right-left)))
      else inner(left, right-1, Math.max(max,Math.min(height(left), height(right)) * (right-left)))
    }
    inner(left, right, 0)
  }

  assert(maxArea(Array(1,8,6,2,5,4,8,3,7))==49)
  assert(maxArea(Array(2,3,4,5,18,17,6))==17)

}
