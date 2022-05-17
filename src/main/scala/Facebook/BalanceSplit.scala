package Facebook

object BalanceSplit {
  // We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!

    def main(args: Array[String]) {
      // Call balancedSplitExists() with test cases here
//      assert(balancedSplitExists(Array(1,5,7,1)))
      assert(!balancedSplitExists(Array(12, 7, 6, 7, 6)))
    }

    def balancedSplitExists(arr: Array[Int]) : Boolean = {
      // Write your code here
      val sorted = arr.sorted
      val total = sorted.sum
      val half = total/2
      var sum = 0
      var pos = 0
      if(total % 2 == 0){
        // might be possible
        while(sum < half){
          sum = sum +sorted(pos)
          pos = pos + 1
        }
        sum == half && sorted(pos) > sorted(pos-1)
      } else false
  }
}
