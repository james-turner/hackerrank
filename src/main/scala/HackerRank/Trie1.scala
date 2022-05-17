package HackerRank
import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}


object Trie1 extends App {

  type Trie = mutable.Map[Char, (Int,Any)]

  mutable.Map()

  @tailrec
  def add(pos: Int, value: String, trie: Trie): Unit = {
    if(pos < value.length) {
      val (count,subTrie) = trie.getOrElseUpdate(value(pos), (0, mutable.Map[Char,(Int,_)]()))
      trie.put(value(pos), (count+1, subTrie))
      add(pos+1, value, subTrie.asInstanceOf[Trie])
    }

  }

  val acc = ListBuffer[String]()
  BigInt(1).bitCount


  @tailrec
  def find(pos: Int, value: String, trie: Trie): Int = {

    trie.get(value(pos)) match {
      case None => 0
      case Some((counter, subTrie)) =>
        if(pos == value.length-1){
          counter
        } else {
          find(pos+1, value, subTrie.asInstanceOf[Trie])
        }
    }

  }

  def contacts(queries: Array[Array[String]]): Array[Int] = {

    val trie: Trie = mutable.Map[Char,(Int,_)]()

    queries.foldLeft(List[Int]())((acc,q) => {
      val op = q(0)
      val value = q(1)

      op match {
        case "add" =>
          add(0, value, trie)
          acc
        case "find" =>
          acc :+ find(0, value, trie)
      }

    }).toArray
  }

  val Array(howMany) = contacts(Array(
    Array("add", "ed"),
    Array("add", "eddie"),
    Array("add", "edward"),
    Array("find", "ed")
  ))

  assert(howMany==3)

}
