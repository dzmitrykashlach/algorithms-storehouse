package arrays

import com.algorithms.storehouse.graphs.dfs.maze.MazeEscape
import kotlin.test.Test

class MazeTest {

    @Test
    fun mazeTest(){
        val startRow = 1
        val startCol = 1
        val mazeEscape = MazeEscape()
        mazeEscape.findExit(mazeEscape.maze, startRow, startCol)
    }
}