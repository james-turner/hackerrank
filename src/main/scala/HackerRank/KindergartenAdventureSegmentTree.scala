package HackerRank

object KindergartenAdventureSegmentTree extends App {


  case class AugmentedTree() {
    var root: TreeNode = _
    def add(bounds: (Int,Int)): AugmentedTree = {
      if(root == null) root = TreeNode(bounds._1, bounds._2, bounds._2, null, null)
      else {
        def traverse(node: TreeNode, acc: List[TreeNode]): Unit = {
          val newAcc = acc :+ node
          if(bounds._1 < node.lower){
            if(node.left != null) traverse(node.left, newAcc)
            else {
              node.left = TreeNode(bounds._1, bounds._2, bounds._2, null, null)
              newAcc.foreach(v => v.maxUpper = Math.max(v.maxUpper, bounds._2))
            }
          }
          else {
            if(node.right != null) traverse(node.right, newAcc)
            else {
              node.right = TreeNode(bounds._1, bounds._2, bounds._2, null, null)
              newAcc.foreach(v => v.maxUpper = Math.max(v.maxUpper, bounds._2))
            }
          }
        }
        traverse(root, List())
      }
      this
    }

//    def overlap(i: Int): Int = {
//
//    }
  }
  case class TreeNode(lower: Int, upper: Int, var maxUpper: Int, var left: TreeNode, var right: TreeNode)

  val tree = AugmentedTree()
  tree.add((2,2))
  tree.add((3,4))
  tree.add((1,7))
  tree.add((5,6))
  tree.add((4,10))

  println(tree.root)

}
