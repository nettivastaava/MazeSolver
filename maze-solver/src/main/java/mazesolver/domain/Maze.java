
package mazesolver.domain;

import java.io.File;
import java.util.Scanner;

/**
* The class that reads an ASCII maze from a file and creates a corresponding object
*/
public class Maze {
    char[][] maze;
    
    public Maze(int n, int m, String file) {
        maze = new char[n][m];
        
        try {
            Scanner input = new Scanner(new File(file));

            for (int i = 0; i < n; i++) {
                String s = input.next();

                for (int j = 0; j < m; j++) {
                    maze[i][j] = s.charAt(j);
                }
            }

        } catch (Exception e) { 
        }
        
    }
    
    /**
     * Prints the ASCII visualization of the maze
     */
    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    public char[][] getMaze() {
        return maze;
    }

   
}
