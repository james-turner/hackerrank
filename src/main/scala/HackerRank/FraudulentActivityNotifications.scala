package HackerRank

object FraudulentActivityNotifications extends App {

  def freqCount(a: Array[Int], max: Int): Array[Int] = {

    a.foldLeft[Array[Int]](Array.fill(max)(0)) { case(freq, num) =>
      freq(num) = freq(num) + 1
      freq
    }
  }

  def adjustCountSort(a: Array[Int], oldNum: Int, newNum: Int) = {
    a(oldNum) = a(oldNum) - 1
    a(newNum) = a(newNum) + 1
    a
  }


  def median(a: Array[Int]) = {
    (a((a.length-1)/2) + a(a.length/2)).toDouble/2
  }

  def medianOfCountSort(a: Array[Int], d: Int) = {
    val mid1 = (d+1)/2
    val mid2 = (d+2)/2
    def inner(a: Array[Int], pos: Int, acc: Int, target: Int): (Int) = {
      val newAcc = acc + a(pos)
      if(newAcc >= target) pos
      else inner(a, pos+1, newAcc, target)
    }
    val first = inner(a, 0, 0, mid1)
    if(mid1 == mid2) first.toDouble
    else (first+inner(a, 0, 0, mid2)).toDouble/2

  }

  // Complete the activityNotifications function below.
  def activityNotifications(expenditure: Array[Int], d: Int): Int = {

    val countSort = freqCount(expenditure.take(d), 200)
    def inner(e: Array[Int], pos: Int, countSort: Array[Int], acc: Int): Int = {
      if (pos >= e.length) acc
      else {
        val m = medianOfCountSort(countSort, d)
        val v = e(pos)
        inner(e, pos + 1, adjustCountSort(countSort, e(pos - d), e(pos)), if (v >= m * 2) acc + 1 else acc)
      }
    }

    inner(expenditure, d, countSort, 0)

  }

//  val a = Array(2, 3, 4, 2, 3, 6, 8, 4, 5)
//  val res: Int = activityNotifications(a, 5)
//  assert(res == 2)
//
  val b = Array(1,2,3,4,4)
  val res2: Int = activityNotifications(b, 4)
  assert(res2 == 0)

  val c= Array(10,20 ,30 ,40, 50)
  val res3: Int = activityNotifications(c, 3)
  assert(res3 == 1)
//  val res2: Int = activityNotifications(Array(4,4,4,4,4,4,4,4,4,4,4), 5)
}
