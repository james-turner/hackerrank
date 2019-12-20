package HackerRank

object ClimbingTheLeaderboard extends App {

  def climbingLeaderboard(scores: Array[Int], alice: Array[Int]): Array[Int] = {

    val uniqueScores = Stream(scores:_*).distinct.toArray

    def inner(scoresPos: Int, scores: Array[Int], alicePos: Int, alice: Array[Int], acc: Array[Int]): Array[Int] = {
      if(alicePos >= alice.length) acc
      else if(scoresPos < 0){
        acc(alicePos) = 1
        inner(scoresPos, scores, alicePos+1, alice, acc)
      }
      else {
        if(alice(alicePos)>=scores(scoresPos)){
          inner(scoresPos-1, scores, alicePos, alice, acc)
        } else {
          acc(alicePos) = scoresPos+2
          inner(scoresPos, scores, alicePos+1, alice, acc)
        }
      }
    }

    inner(uniqueScores.length-1, uniqueScores, 0, alice, Array.fill(alice.length)(0))

  }

  climbingLeaderboard(Array(100,90,90,80,75,60), Array(50,65,77,90,102)).foreach(println)

}
