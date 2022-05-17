package Facebook

object DigitIncrement extends App {

  def func(input: Array[Char]): Array[Char] = {
    def inner(pos: Int): Array[Char] = {
      if (pos < 0) {
        if (input(0) == '0') {
          // prepend output with 1
          Array('1') ++ input
        }
        else input
      } else if (input(pos) == '9') {
        input(pos) = '0'
        inner(pos - 1)
      }
      else {
        input(pos) = (input(pos).toInt + 1).toChar
        input
      }
    }

    inner(input.length - 1)
  }

  def func2(input: Array[Char]): Array[Char] = {
    var continue = true
    var pos = input.length -1
    while(continue && pos >= 0){
      if(input(pos)=='9'){
        input(pos) = '0'
        pos = pos -1
      } else {
        input(pos) = (input(pos)+1).toChar
        continue = false
      }
    }

    if(input(0)=='0') Array('1')++input
    else input
  }

  assert(func(Array('1','2','9')).sameElements(Array('1','3','0')))
  assert(func2(Array('1','2','9')).sameElements(Array('1','3','0')))
  assert(func(Array('9','9','9')).sameElements(Array('1','0','0','0')))
  assert(func2(Array('9','9','9')).sameElements(Array('1','0','0','0')))
}
