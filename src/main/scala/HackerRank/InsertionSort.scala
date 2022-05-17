package HackerRank

object InsertionSort extends App {

  // Complete the insertionSort2 function below.
  def insertionSort2(n: Int, arr: Array[Int]) {

    // at index i
    // lift the value from i
    // keep going backwards until you discover its appropriate position
    // then shuffle everything else up to i (from appropriate pos to i)
    // then shove in value from i
    // continue from i
    (1 until n).foreach { i =>
      val v = arr(i)
      val newpos = findPos(v, arr)
      shuffleFrom(newpos,i, arr)
      arr(newpos) = v
      println(arr.mkString(" "))
    }

  }

  def shuffleFrom(start: Int,end: Int, arr: Array[Int]): Array[Int] = {
    var pos = end
    while(pos > start){
      arr(pos) = arr(pos-1)
      pos = pos - 1
    }
    arr
  }

  def findPos(v: Int, arr: Array[Int]): Int = {
    def inner(pos: Int): Int = {
      if(v > arr(pos)) inner(pos+1)
      else pos
    }
    inner(0)
  }

//  println(shuffleFrom(2, 4, Array(0,1,2,3,4,5)).mkString(", "))
//  println(findPos(2, Array(0,1,2,3,4,5)))

  insertionSort2(6, Array(0,1,2,3,4,5))
  insertionSort2(6, Array(4,0,3,2,1,5))

}
