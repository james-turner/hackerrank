package LeetCode

object BoatsToSavePeople extends App {

    def numRescueBoats(people: Array[Int], limit: Int): Int = {

      val buffer = Array.fill(30000)(0)
      people.foreach(v => buffer(v) = buffer(v)+1)
      var front = 0
      var back = limit
      var boats = 0
      while(front < back){
        if(buffer(front)==0) front = front+1
        else if(buffer(back)==0) back = back-1
        else if(front + back <= limit){
          // we can only add the buffer(back) to the total
          val remove = Math.min(buffer(front), buffer(back))
          buffer(front) = buffer(front)-remove
          buffer(back) = buffer(back)-remove
          boats = boats + remove
        } else {
          boats = boats + buffer(back)
          back = back - 1
        }
      }
      if(front==back && front*2 <= limit) boats = boats+(1+buffer(front))/2
      else if(front==back) boats = boats+buffer(front)
      boats

    }


  println(numRescueBoats(Array(3,5,3,4), 5))
}
