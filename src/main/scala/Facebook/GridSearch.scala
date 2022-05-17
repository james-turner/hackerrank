package Facebook

object GridSearch {

  /*
You are given a game board represented as a 2D array of zeroes and ones. Zero stands for passable positions and one stands for impassable positions. Design an algorithm to find a path from top left corner to bottom right corner.

For example, for the following board:
entrance -> 0 0 0 0 0 0 0
            0 0 1 0 0 1 0
            0 0 1 0 1 1 0
            0 0 1 0 1 0 1
            1 1 1 0 0 0 0 -> exit

a possible path is:
entrance -> + + + + 0 0 0
            0 0 1 + 0 1 0
            0 0 1 + 1 1 0
            0 0 1 + 1 0 1
            1 1 1 + + + + -> exit
Assuming a zero-indexed grid of rows and columns, with (0, 0) at left top corner (entrance), we'd return:

(0, 0) -> (0, 1) -> (0, 2) -> (0, 3) -> (1, 3) -> (2, 3) ->
  (3, 3) -> (4, 3) -> (4, 4) -> (4, 5) -> (4, 6)
  */

  // basically a DFS and build a tree of exploration

}
