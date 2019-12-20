package HackerRank

object BuildingAList extends App {

  // Complete the solve function below.
  def solve(s: String): Array[String] = {

    val splitted = s.split("").sorted
    (1 to s.length).flatMap { idx =>
      splitted.combinations(idx).map(_.mkString(""))
    }.toArray.sorted

  }

  println(solve("abc").mkString(","))

}
