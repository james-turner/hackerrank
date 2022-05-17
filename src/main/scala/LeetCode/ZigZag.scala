package LeetCode

import scala.collection.mutable

object ZigZag extends App {

  def convert(s: String, numRows: Int): String = {


    // 0 column and every X column is full,
    // X column is determined by depth - 2
    // e.g. if depth is 3, num of columns between full rows
    // is 3-2 = 1
    // therefore every other column is full
    // sort of want a to give each letter we're "putting in"
    // to be given a number appropriate to it's position
    // figure out a single value column by mod of the current col num?
    val buffer = mutable.ListBuffer[(Char, Int, Int)]()

    def inner(pos: Int, row: Int, col: Int): Unit = {
      if (pos >= s.length) return
      else {
        buffer.append((s(pos), row, col))
        if (row / numRows == 1 || col % Math.max(1,(numRows-1)) > 0) {
          // inc col
          // dec row
          inner(pos + 1, Math.max(1,row - 1), col + 1)
        } else {
          // inc row
          inner(pos + 1, row + 1, col)
        }
      }
    }

    inner(0, 1, 0)

    buffer.sortBy(elem => (elem._2, elem._3)).map(_._1).mkString

  }

  assert(convert("PAYPALISHIRING", 3)=="PAHNAPLSIIGYIR")
  assert(convert("PAYPALISHIRING", 4)=="PINALSIGYAHRPI")
  assert(convert("A", 1)=="A")
  assert(convert("ABC", 1)=="ABC")
}
