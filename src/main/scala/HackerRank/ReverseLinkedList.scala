package HackerRank

import scala.collection.mutable

object ReverseLinkedList extends App {

  case class Node(data: Int, var next: Node)

  def reverse(node: Node): Node ={
    var cur = node
    var prev: Node = null
    while(cur != null && cur.data % 2 != 1){
      val next = cur.next
      cur.next = prev
      prev = cur
      cur = next
    }
    prev
  }

  val h = Node(2, Node(4,Node(6,null)))

  val res = reverse(h)
  var v = res
  while(v != null){
    println(v.data)
    v = v.next;
  }
}
//24 3
//4 6 8
