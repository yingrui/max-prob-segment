package websiteschema.mpsegment.hmm

import websiteschema.mpsegment.util.ISerialize
import websiteschema.mpsegment.util.SerializeHandler
import collection.mutable

class NodeRepository extends ISerialize {

  private var repo = List[Node]()
  private var indexMap = mutable.HashMap[String, Int]()

  def add(node: Node): Node = {
    val name = node.getName()
    if (!indexMap.contains(name)) {
      val index = repo.size
      node.setIndex(index)
      repo = repo ++ List(node)
      indexMap += (name -> index)
      return node
    } else {
      return repo(indexMap(name))
    }
  }

  def get(name: String): Node = {
    if (indexMap.contains(name)) {
      val index = indexMap(name)
      return repo(index)
    } else {
      return null
    }
  }

  def get(index: Int): Node = {
    if (repo.size > index) {
      return repo(index)
    } else {
      return null
    }
  }

  def keySet() = indexMap.keys


  override def save(writeHandler: SerializeHandler) {
    val length = if (null != repo) repo.size else 0
    writeHandler.serializeInt(length)
    for (i <- 0 until length) {
      val node = repo(i)
      node.save(writeHandler)
    }
  }

  override def load(readHandler: SerializeHandler) {
    val length = readHandler.deserializeInt()
    if (length > 0) {
      for (i <- 0 until length) {
        val node = new Node()
        node.load(readHandler)
        repo = repo ++ List(node)
        indexMap += (node.getName() -> node.getIndex())
      }
    }
  }
}
