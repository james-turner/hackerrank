package HackerRank

object CountingSort4 extends App {


  // Complete the countSort function below.
  def countSort(arr: Array[Array[String]]): Array[String] = {
    val (a,b) = arr.zipWithIndex.splitAt(arr.length/2)
    val newA = a.map{case (arr,idx) => (arr(0).toInt,idx,"-")}
    val newB = b.map{case (arr,idx) => (arr(0).toInt,idx,arr(1))}
    (newA ++ newB).sortBy(r => (r._1,r._2)).map(_._3)
  }

  def countSortB(arr: Array[Array[String]]) = {

    val builder = Array.fill[StringBuilder](arr.length)(StringBuilder.newBuilder)
    var i = 0
    val s = "-"
    val spacer = " "
    val half = arr.length/2
    arr.foreach { a =>
      val index = a(0).toInt
      builder(index).append(if(i < half) s else a(1)).append(spacer)
      i = i+1
    }
    builder.foreach { strB =>
      print(strB.mkString)
    }
  }

  def normalCountSort(arr: Array[Int]): Array[Int] = {

    val builder = Array.fill(Math.max(arr.max+1,arr.length))(0)
    arr.foreach { i =>
      builder(i) = builder(i) + 1
    }
    def inner(a: Array[Int], pos: Int, acc: Int): Array[Int] = pos match {
      case _ if pos >= a.length => a
      case _ =>
        val v = a(pos)
        a(pos) = v+acc
        inner(a, pos+1, v+acc)
    }
    val index = inner(builder, 0, 0)
    println(index.mkString(","))
    val ret = Array.fill(arr.length+1)(0)
    arr.foreach { v =>
      val idx = index(v)
      ret(idx) = v
      index(v) = idx-1
    }
    ret

  }

  def simpleCountSort(arr: Array[Int]): Array[Int] = {
    val builder = Array.fill(arr.max+1)(0)
    arr.foreach { i =>
      builder(i) = builder(i) + 1
    }
    builder.zipWithIndex.foldLeft(Array[Int]()){ case (acc,(count, i)) =>
      acc ++ Array.fill(count)(i)
    }
  }

  println(simpleCountSort(Array(4,2,2,2,2,2,5,1)).mkString(","))
  val strings: Array[String] = countSort(Array(Array("0", "ab"),Array("0","to")))
  println(strings.mkString(","))
  assert(strings sameElements Array("-", "to"))


  val data = Array(Array("0","ab"),
  Array("6","cd"),
  Array("0","ef"),
  Array("6","gh"),
  Array("4","ij"),
  Array("0","ab"),
  Array("6","cd"),
  Array("0","ef"),
  Array("6","gh"),
  Array("0","ij"),
  Array("4","that"),
  Array("3","be"),
  Array("0","to"),
  Array("1","be"),
  Array("5","question"),
  Array("1","or"),
  Array("2","not"),
  Array("4","is"),
  Array("2","to"),
  Array("4","the"))

  countSortB(data)
}
