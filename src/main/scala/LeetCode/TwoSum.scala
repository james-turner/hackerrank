package LeetCode

object TwoSum extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val s = nums.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2))
    def inner(pos: Int): Array[Int] = {
      val look = target - nums(pos)
      if(nums(pos)==look && s(look).length> 1) Array(s(look)(0),s(look)(1))
      else if(nums(pos)!=look && s.contains(look)) Array(pos, s(look)(0))
      else inner(pos+1)
    }
    inner(0)
  }

}
