package HackerRank

import scala.annotation.tailrec

object BackspaceStringCompare extends App {

  def backspaceCompare(s: String, t: String): Boolean = {

    // start at rear of both
    // for s and t
    //   while backspace move left
    // if char in s is in t then move left

    def inner(pos: Int, s: String, stack: List[Char]): String = {
      if(pos >= s.length) {
        println(stack.mkString)
        stack.mkString
      }
      else if(s(pos)=='#') {
        stack match {
          case Nil =>inner(pos+1, s, Nil)
          case _::tail => inner(pos+1, s, tail)
        }
      }
      else inner(pos+1, s, s(pos) +: stack)
    }

    inner(0, s, List()) == inner(0, t, List())

  }

  def backspaceCompare2(s: String, t: String): Boolean = {

    // start at rear of both
    // for s and t
    //   while backspace move left
    // if char in s is in t then move left

    s.length-1
    t.length-1
    false



  }

  @tailrec
  def nextValidChar(s: String, i: Int, counter: Int): Int = {
    if(i < 0) i
    else if(s(i)=='#') nextValidChar(s, i-1, counter+1)
    else if(counter > 0) nextValidChar(s, i-1, counter-1)
    else i
  }

//  assert(backspaceCompare("ab##", "c#d#"))
//  assert(!backspaceCompare("a#c", "b"))
//  assert(backspaceCompare("#a#c", "a##c"))

  println(nextValidChar("abcd###", 6, 0))
}
