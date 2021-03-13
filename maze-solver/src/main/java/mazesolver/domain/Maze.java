
package mazesolver.domain;

import java.io.File;
import java.util.Scanner;

/**
* The class that reads an ASCII maze from a file and creates a corresponding object
*/
public class Maze {
    char[][] maze;
    
    /**
    * The class that reads an ASCII maze from a file and creates a corresponding object
    * 
    * @param file name of the file containing the ASCII maze
    */
    public Maze(String file) {
        
        try {
            Scanner input = new Scanner(new File(file));
            int n = 0;
            int m = 0;
            
            while (input.hasNextLine()) {
                m = input.nextLine().length();
                n++;
            }
            
            maze = new char[n][m];
            
            input = new Scanner(new File(file));
            
            int i = 0;
            
            while (input.hasNextLine()) {
                String s = input.nextLine();
                
                for (int j = 0; j < s.length(); j++) {
                    maze[i][j] = s.charAt(j);
                }
                i++;
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
