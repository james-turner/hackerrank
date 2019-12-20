package HackerRank

object SwapNodesAlgo extends App {


  case class Node(index: Int) {
    var left: Node = _
    var right: Node = _
  }

  def swapNodes(indexes: Array[Array[Int]], queries: Array[Int]): Array[Array[Int]] = {
    /*
     * Write your code here.
     */
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)

    def traverseByLevel(todo: List[Node], depth: Int): Unit = {
      todo match {
        case Nil =>
        case h :: tail =>

          traverseByLevel(tail, depth+1)
      }

    }

    traverseByLevel(List(root), 0)

    Array()
  }

}
