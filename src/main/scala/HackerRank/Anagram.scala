package HackerRank

object Anagram extends App {

  def anagram(s: String): Int = {
    // Write your code here
    if(s.length() % 2 == 1) -1
    else {
      //split in half
      val front = s.substring(0,s.length/2)
      val tail = s.substring(s.length/2)
      // bag the letters
      val bag = front.foldLeft(Map[Char,Int]()){ (acc, v) =>
        acc ++ Map(v-> (acc.getOrElse(v,0)+1))
      }
      val reducedBag = tail.foldLeft(bag)((acc,c) => {
        acc ++ Map(c -> (acc.getOrElse(c,1)-1))
      })
      println(reducedBag)
      // compare missing character counts, that's the needed change
      reducedBag.foldLeft(0)((acc,r)=> acc+Math.max(0,r._2))
    }
  }

  assert(anagram("xaxbbbxx")==1)

}
