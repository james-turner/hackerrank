package LeetCode

object StringToIntegerAtoi extends App {
  def myAtoi(s: String): Int = {
    if(s.length == 0) return 0

    def readUntilNonWhitespace(pos: Int): Int = {
      if(pos >= s.length) pos
      else if(s(pos) == ' ') readUntilNonWhitespace(pos+1)
      else pos
    }

    val p1 = readUntilNonWhitespace(0)
    // read until + or - or digit
    def readSign(pos: Int): (Int,Int) = {
      if(pos >= s.length) (pos, 1)
      else if(s(pos)=='-') (pos+1, -1)
      else if(s(pos)=='+') (pos+1, 1)
      else (pos,1)
    }
    val (p2,sign) = readSign(p1)

    def stripLeadingZeros(pos: Int): Int = {
      if(pos >= s.length) pos
      else if(s(pos)=='0') stripLeadingZeros(pos+1)
      else pos
    }

    val p3 = stripLeadingZeros(p2)

    // read until non-digit or end of string
    def readUntilNonDigit(pos: Int, acc: List[Char]): List[Char] = {
      if(pos >= s.length) acc
      else if(s(pos).toInt < 48 || s(pos).toInt > 57) acc
      else readUntilNonDigit(pos+1, acc :+ s(pos))
    }

    val res = readUntilNonDigit(p3, List())
    if(res.isEmpty) 0
    else if(res.length > 11 && sign == 1) Int.MaxValue
    else if(res.length > 11 && sign == -1) Int.MinValue
    else Math.max(Math.min(Int.MaxValue, res.mkString.toLong * sign), Int.MinValue).toInt
  }

//  assert(myAtoi("42") == 42)
//  assert(myAtoi("-42") == -42)
//  assert(myAtoi("-42") == -42)
//
//  assert(myAtoi("words and 987") == 0)

  assert(myAtoi("  0000000000012345678") == 12345678)
}
