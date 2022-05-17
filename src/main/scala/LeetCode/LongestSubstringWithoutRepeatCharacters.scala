package LeetCode

import scala.collection.mutable

object LongestSubstringWithoutRepeatCharacters extends App {

  def lengthOfLongestSubstring(s: String): Int = {
    def inner(startPos: Int, pos: Int, maxLength: Int, bag: Map[Char,Int]):Int = {
      if(pos >= s.length) maxLength
      else {
        val currentLength = pos - startPos + 1
        if(bag.contains(s(pos))){
          val newStartPos = Math.max(startPos, bag(s(pos))+1)
          val newCurrentLength = pos - newStartPos + 1
          inner(newStartPos, pos+1, Math.max(maxLength, newCurrentLength), bag + (s(pos)->pos))
        } else {
          inner(startPos, pos+1, Math.max(maxLength, currentLength), bag + (s(pos)->pos))
        }
      }
    }
    inner(0, 0, 0, Map())
  }

  assert(lengthOfLongestSubstring("abcabcbb") == 3)
  assert(lengthOfLongestSubstring("bbbbb") == 1)
  assert(lengthOfLongestSubstring("pwwkew") == 3)
  assert(lengthOfLongestSubstring("abba") == 2)

}
