package HackerRank

object MaximumElement extends App {

  var stack = List[(Int,Int)]()

  def push(v: Int) = {
    val prevMax = stack.headOption.map(_._2).getOrElse(0)
    (v,Math.max(prevMax, v)) +: stack
  }

  def pop() = stack match {
    case Nil => Nil
    case _ :: Nil => Nil
    case _ :: tail => tail
  }

  def max() = stack match {
    case Nil => 0
    case head :: tail => head._2
  }

  val numofLines = scala.io.StdIn.readLine().toInt
  (0 until numofLines).foreach { i =>
    val split = scala.io.StdIn.readLine().split(" ")
    val op = split(0)
    if(op == "1") stack = push(split(1).toInt)
    if(op == "2") stack = pop()
    if(op == "3") println(max())
  }

}
