package HackerRank

object Candies {

  // Complete the candies function below.
  def candies(n: Int, arr: Array[Int]): Long = {


    var lastMax = 0
    val acc = Array.fill(arr.length)(1)
    var counter = 1
    (1 until arr.length).foreach { idx =>
      if(idx == arr.length-1 && arr(idx-1) >= arr(idx)) {
        acc(idx) = 1
        acc(lastMax) = Math.max(counter+1, acc(lastMax))
      }
      else if(idx == arr.length-1 && arr(idx-1) < arr(idx)) {
        acc(idx) = counter+1
      }
      else if(arr(idx-1) > arr(idx) && arr(idx+1) > arr(idx)){ // valley
        // flip last pos with latest counter and make current pos 1
        acc(lastMax) = Math.max(acc(lastMax), counter+1)
        acc(idx) = 1
        counter = 1
      } else if(arr(idx-1) < arr(idx) && arr(idx+1) < arr(idx)){ // peak
        lastMax = idx
        acc(idx) = counter + 1
        counter = 1
      } else { // continue trend, i.e. last value + 1
        counter = counter + 1
        acc(idx) = counter
      }
    }
    acc.map(_.toLong).sum
  }


  //    def inner(pos: Int, acc: (Int,Long)): Long = {
  //      if(pos >= arr.length) acc._2
  //      else if(arr(pos) > arr(pos-1)) inner(pos+1, (acc._1+1, acc._2+(acc._1+1)))
  //      else if(arr(pos) == arr(pos-1)) inner(pos+1, (acc._1, acc._2+(acc._1)))
  //      else inner(pos+1, (acc._1-1, acc._2+(acc._1-1)))
  //    }
  //    inner(0, (0,0))

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val arr = Array.ofDim[Int](n)

    for (i <- 0 until n) {
      val arrItem = stdin.readLine.trim.toInt
      arr(i) = arrItem
    }

    val result = candies(n, arr)
    println(result)
  }

}
