package LeetCode

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object NumberOfMatchingSubsequences extends App {
  def numMatchingSubseq(s: String, words: Array[String]): Int = {
    val bag = makeBag(s)
    @tailrec
    def inner(pos: Option[Int], chrPos: Int, s: String): Boolean = pos match {
      case None => false
      case Some(_) if chrPos >= s.length => true
      case Some(p) => {
        val nextPos = traverseBag(bag, (p, s(chrPos))).map(_ + 1)
        inner(nextPos, chrPos+1, s)
      }
    }

    val c = words.foldLeft(0){ case(counter, word) =>
      inner(Option(0), 0, word) match {
        case true => {
          println(word)
          counter+1
        }
        case false => counter
      }
    }
    c
  }


  def makeBag(s: String): Map[Char, Array[Int]] = {
    s.zipWithIndex.foldLeft(mutable.Map[Char, ArrayBuffer[Int]]()) { case (m, (chr,idx)) =>
      if(!m.contains(chr)) m.put(chr, new ArrayBuffer[Int]())
      m.get(chr).map(_.addOne(idx))
      m
    }.view.mapValues(_.toArray).toMap
  }

  def traverseBag(bag: Map[Char, Array[Int]], c: (Int, Char)): Option[Int] = {
    if(!bag.contains(c._2)) None
    else {
      binarySearch(bag.getOrElse(c._2, Array()), c._1)
    }
  }

  def binarySearch(a: Array[Int], pos: Int): Option[Int] = {
    @tailrec
    def inner(left: Int, right: Int): Option[Int] = {
      val midPoint = (left+right)/2
      if(pos > a(right)) None
      else if(pos <= a(left)) Some(a(left))
      else if(pos == a(midPoint)) Some(pos)
      else if(pos > a(midPoint)) inner(midPoint+1, right)
      else inner(left, midPoint)
    }

    inner(0, a.length-1)
  }


  assert(binarySearch(Array(0,2,4,5,6), 4)== Some(4))
  assert(binarySearch(Array(5,6,7), 4)== Some(5))
  assert(binarySearch(Array(1,2,3), 4)== None)
  assert(binarySearch(Array(1,2,3,4), 4)== Some(4))
  assert(binarySearch(Array(4,6,7), 4)== Some(4))

  assert(numMatchingSubseq("abcdef", Array("ab", "cde", "ace", "aa", "bg", "bf", "fb")) == 4) // should be 3 ab, cde, ace
  assert(numMatchingSubseq("kguhsugfxvwxakdcovjeczhqvbevkhlixsrhumxykbkihjdfxxxwragzcbhngbzgasxysxdtwntvbpdihtvkffacmxhbxxqniyqm",
    Array(
      "ykbkihjdfxxxwragzcbhngbzgasxysxdtwn",
      "wxakdcovjeczhqvbevkhlixsrhumxykbkihj",
      "diht",
      "covjeczhqvbevkhlixsrhumxykbkihjdfxxxwragzcbhngbz",
      "ovjeczhqvbevkhlixsrhumxykbkihjdfxxxwragzcbhng",
      "qhzucvqxalfrtlrdjverseuldzymzbunhugekoyyghmkpkfqmd",
      "eydmbsorvjnnifqxsyuypsrijzrosukrhtbneprpyyoawbvoki",
      "uanfzlfmmtvhzzebrazyuslbapsfzwtlvqbhqxsfmqagwxetro",
      "fffaawedchlcyqvzzxbzczbwyfjkllpsjhoozyresqemmawban",
      "astrknwzefcmuswdxalooatmiduspjuofthtomoqilgdojwhon")
        ) ==0 ) // should be 3 ab, cde, ace


}
