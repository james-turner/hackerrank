package LeetCode

import scala.collection.mutable

object LRUCache extends App {

  case class Node(k: Int, v: Int, var prev: Node = null, var next: Node = null)

  class LRUCache(_capacity: Int) {
    var head: Node = null
    var tail: Node = null
    var stored = 0
    val m = mutable.Map[Int, Node]()
    var currentPos = 0

    def get(key: Int): Int = {
      val res = m.get(key).map(_.v).getOrElse(-1)
      // update LRU (k)
      if (res >= 0) put(key, res)
      res
    }

    def collapseChain(n: Node) {
      val prev = n.prev
      val next = n.next
      if (prev != null) {
        prev.next = next
      } else {
        head = next
      }
      if (next != null) {
        next.prev = prev
      } else {
        tail = prev
      }
    }

    def append(n: Node) {
      if (head == null) {
        head = n
        tail = n
      } else {
        tail.next = n
        n.prev = tail
        tail = n
      }
    }

    def truncate() {
      if (head != null) {
        m.remove(head.k)
        if (head.next != null) {
          head.next.prev = null
          head = head.next
        } else {
          head = null
        }
      }
    }

    def put(key: Int, value: Int) {
      val newNode = Node(key, value)
      if (m.contains(key)) {
        collapseChain(m(key))
      } else if (stored >= _capacity) {
        truncate()
      } else {
        stored = stored + 1
      }
      append(newNode)
      m.put(key, newNode)
    }

  }

  /**
   * Your LRUCache object will be instantiated and called as such:
   * var obj = new LRUCache(capacity)
   * var param_1 = obj.get(key)
   * obj.put(key,value)
   */


  val c = new LRUCache(2)
  c.put(1, 1)
  c.put(2, 2)
  assert(c.get(1) == 1)
  c.put(3, 3)
  assert(c.get(2) == -1)
  c.put(4, 4)
  assert(c.get(1) == -1)
  assert(c.get(3) == 3)
  assert(c.get(4) == 4)

}
