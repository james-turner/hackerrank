package HackerRank

import scala.collection.mutable

object QueueUsingTwoStacks extends App {

  val stack1 = mutable.Stack[Int]()
  val stack2 = mutable.Stack[Int]()

  def enqueue(i: Int) = {
    stack1.push(i)
  }
  def dequeue() = {
    if(stack2.isEmpty){
      while(stack1.nonEmpty){
        stack2.push(stack1.pop())
      }
    }
    stack2.pop()
  }
  def peek() = {
    if(stack2.isEmpty){
      while(stack1.nonEmpty){
        stack2.push(stack1.pop())
      }
    }
    stack2.top
  }


  val num = scala.io.StdIn.readLine().toInt
  (0 until num).foreach { i=>
    scala.io.StdIn.readLine().split(' ') match {
      case Array(op, n) => enqueue(n.toInt)
      case Array(op) => op match {
        case "2" => dequeue()
        case "3" => println(peek())
      }
    }

  }

}
