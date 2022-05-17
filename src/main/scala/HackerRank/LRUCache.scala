package HackerRank

import scala.collection.mutable

object LRUCache {

  val cache: Cache = new CacheImpl(2)

  cache.get(1) // -1
  cache.put(1,1) // nil
  cache.get(1) // 1

  cache.put(2,2)
  cache.put(3,3) // purge 1
  cache.get(2)
  cache.put(4,4) // purge 3


}

class CacheImpl(capacity: Int) extends Cache {

  type Key = Int
  type Time = Long
  val cache = mutable.Map[Key,Int]()
  val q = mutable.PriorityQueue[(Key,Time)]()(Ordering.by(_._2))

  override def get(k: Int): Int = {
    val v = cache.getOrElse(k, -1)
    // update time? shuffle around in queue?
    v
  }

  override def put(k: Int, v: Int): Unit = {
    cache.put(k, v)
    q.enqueue((k, System.nanoTime()))
    // update time for this value?
    // remove last recently used
    q.dequeue()
  }
}


trait Cache {
  def get(k: Int): Int
  def put(k: Int, v: Int): Unit

}
