package LeetCode

object LongestPalindromicSubstring extends App {

  def longestPalindrome(s: String): String = {
    //   [0,1,2,3,4,5]
    //[0] 1
    //[1]   1
    //[2]     1
    //[3]       1
    //[4]         1
    //[5]           1


    var continue = true
    var start = 0
    var end = 0
    var max = (start, end)
    while(continue){
      if(end >= s.length && start == 0){
        // we've gone beyond the max window which is 0,s.length-1
        continue = false
      } else if(end >= s.length) {
        val diff = end-start
        start = 0
        end = diff+1
      } else {
        if(check(start, end, s)){
          if(end-start > (max._2 - max._1)){
            max = (start,end)
          }
        }
        start = start+1
        end = end+1
      }

    }

    s.slice(max._1, max._2+1).mkString

  }

  def check(start: Int, end: Int, s:String): Boolean = {
    if(start > end) true
    else {
      if(s(start) == s(end)) check(start+1, end-1, s)
      else false
    }
  }

  assert(longestPalindrome("babad") == "bab")

}
