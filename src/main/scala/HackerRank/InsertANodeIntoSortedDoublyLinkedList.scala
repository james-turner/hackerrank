package HackerRank

import java.io.{OutputStream, PrintWriter}

import scala.annotation.tailrec

object InsertANodeIntoSortedDoublyLinkedList {

  class DoublyLinkedListNode(var data: Int, var next: DoublyLinkedListNode = null, var prev: DoublyLinkedListNode = null) {
  }

  class DoublyLinkedList(var head: DoublyLinkedListNode = null, var tail: DoublyLinkedListNode = null) {
    def insertNode(nodeData: Int) = {
      val node = new DoublyLinkedListNode(nodeData)

      if (this.head == null) {
        this.head = node
      } else {
        this.tail.next = node
        node.prev = this.tail
      }

      this.tail = node
    }
  }

  def printDoublyLinkedList(head: DoublyLinkedListNode, sep: String, printWriter: PrintWriter) = {
    var node = head

    while (node != null) {
      printWriter.print(node.data)

      node = node.next

      if (node != null) {
        printWriter.print(sep)
      }
    }
  }


  def sortedInsert(llist: DoublyLinkedListNode, data: Int): DoublyLinkedListNode = {
    val newNode = new DoublyLinkedListNode(data)
    def inner(cur: DoublyLinkedListNode, prev: DoublyLinkedListNode): DoublyLinkedListNode = {
      if(cur == null && prev == null) newNode
      else if(cur == null) {
        prev.next = newNode
        llist
      } else {
        if(data < cur.data){
          // insert into list here and exi
          newNode.next = cur
          newNode.prev = prev
          cur.prev = newNode
          if(prev != null) {
            prev.next = newNode
          }
          if(prev == null) newNode
          else llist
        } else inner(cur.next, cur)
      }
    }
    inner(llist, llist.prev)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(scala.sys.process.stdout)

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val llist = new DoublyLinkedList()

      val llistCount = stdin.readLine.trim.toInt

      for (_ <- 0 until llistCount) {
        val llistItem = stdin.readLine.trim.toInt
        llist.insertNode(llistItem)
      }

      val data = stdin.readLine.trim.toInt

      val llist1 = sortedInsert(llist.head, data)

      printDoublyLinkedList(llist1, " ", printWriter)
      printWriter.println()
    }

    printWriter.close()
  }
}
