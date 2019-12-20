package HackerRank

object JourneyToTheMoon extends App {

  def journeyToMoon(n: Int, astronaut: Array[Array[Int]]): Long = {
    // Complete this function
    val map: Map[Int, Set[Int]] = (0 until n).map { i =>
      i -> Set[Int](i)
    }.toMap[Int, Set[Int]]
    val mutable = collection.mutable.Map(map.toSeq: _*)

    astronaut.foreach {
      case Array(a, b) =>
        val newSet = mutable.getOrElse(a, Set.empty[Int]) ++ mutable.getOrElse(b, Set.empty[Int])
        newSet.foreach(mutable.put(_, newSet))
      case _ =>
    }
    val distinctSets = mutable.map(_._2).toSet[Set[Int]]
    distinctSets.foldLeft[(Long, Long)]((0L, 0L)) {
      case ((answer,acc), set) =>
        (answer+(acc.toLong*set.size.toLong),acc.toLong + set.size.toLong)
    }._1
  }

  //  val n = 5
  //  //  val p = 3
  //  val pairs = List(
  //    (0, 1),
  //    (2, 3),
  //    (0, 4)
  //  ).toArray.map {
  //    case (a, b) => Array(a, b)
  //  }

  val n = 4
  //  val p = 3
  val pairs = List(
    (0, 2),
      (0,1),
      (0,3)
  ).toArray.map {
    case (a, b) => Array(a, b)
  }
  //  val sc = new java.util.Scanner(System.in);
  //  var n = sc.nextInt()
  //  var p = sc.nextInt()
  //  var astronaut = Array.ofDim[Int](p, 2);
  //  for (astronaut_i <- 0 until p) {
  //    for (astronaut_j <- 0 until 2) {
  //      astronaut(astronaut_i)(astronaut_j) = sc.nextInt();
  //    }
  //  }
  val result = journeyToMoon(n, pairs)
  assert(result == 0, s"$result does not equal 0")
  println(result)
}
