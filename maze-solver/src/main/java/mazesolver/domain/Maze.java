
package mazesolver.domain;

import java.awt.Point;
import java.io.File;
import mazesolver.domain.Tile;
import mazesolver.domain.SimpleStack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* The class that reads an ASCII maze from a file and creates a corresponding object (DeadendFiller will be moved into a separate class later)
*/
public class Maze {
    char[][] maze;
    SimpleStack deadends;
    int pathY;
    int pathX;
    StringBuilder route;
    
    public Maze(int n, int m, String file) {
        maze = new char[n][m];
        deadends = new SimpleStack();
        route=new StringBuilder();
        
        try {
            Scanner input = new Scanner(new File(file));

            for (int i = 0; i < n; i++) {
                String s = input.next();

                for (int j = 0; j < m; j++) {
                    maze[i][j] = s.charAt(j);
                    if (maze[i][j]=='S') {
                        pathY=i;
                        pathX=j;
                    }
                }
            }

        } catch (Exception e) {}
        
    }
    
    /**
     * The main method which invokes all the other method calls used to execute the algorithm.
     *
     * @return String that corresponds the transitions required to move from S to F.
     */
    public String solve() {
        findDeadends();
        fillDeadends();
        findPath(pathY, pathX);
        return "DEF: " + route.toString();
        
    }
    
    /**
     * Builds the string that corresponds the transitions needed to get from S to F
     * 
     * @param y indicates the row of the tile
     * 
     * @param x indicates the column of the tile
     * 
     */
    public void findPath(int y, int x) {
        if (maze[y][x]=='F') {
            return;
        } 
        maze[y][x]='@';
        
        if (y > 0 && maze[y - 1][x] != '@') {          
            route.append("Y");
            findPath(y - 1, x);
        } else if (x < maze[0].length - 1 && maze[y][x + 1] != '@') {
            route.append("O");
            findPath(y, x + 1);
        } else if (y < maze.length - 1 && maze[y + 1][x] != '@') {
            route.append("A");
            findPath(y + 1, x);
        } else if (x > 0 && maze[y][x - 1] != '@') {
            route.append("V");
            findPath(y, x - 1);
        }        
    }
    
    /**
     * Iterates through all the dead ends and invokes the method used to actually fill them.
     */
    public void fillDeadends() {
        while(deadends.isNotEmpty()) {
                Tile current = (Tile) deadends.getNext();   
                fillOne(current.y, current.x);              
        }
    }
    
    /**
     * Fills the tile with a wall and checks if its neighbours are dead ends as well.
     * 
     * @param i indicates the row of the tile
     * 
     * @param j indicates the column of the tile
     * 
     */
    public void fillOne(int i, int j) {
        maze[i][j] = '@';
        
        if (i > 1 && maze[i - 1][j] == '.' && isDeadend(i - 1, j)) {
            deadends.addValue(new Tile(i - 1, j));
        } 
        if (j < maze[0].length-2 && maze[i][j + 1] == '.' && isDeadend(i, j + 1)) {
            deadends.addValue(new Tile(i, j + 1));
        } 
        if (i < maze.length-2 && maze[i + 1][j] == '.' && isDeadend(i + 1, j)) {
            deadends.addValue(new Tile(i + 1, j));
        } 
        if (j > 1 && maze[i][j - 1] == '.' && isDeadend(i, j - 1)) {
            deadends.addValue(new Tile(i, j - 1));
        } 
        
    }
    
    /**
     * Locates all the dead ends from the maze and stores them in a stack
     */
    public void findDeadends() {
               
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == '.') {
                    if (isDeadend(i, j)) { 
                        deadends.addValue(new Tile(i, j));
                    }
                }
            }
        }
        
    }
    
    /**
     * Counts the neighbours of the tile and determines whether it is a dead end or not
     * 
     * @param i indicates the row of the tile
     * 
     * @param j indicates the column of the title
     * 
     * @return true if the tile is a dead end and false, if not
     */
    public boolean isDeadend(int i, int j) {
        int neighbors = 0;
        if (i > 0 && maze[i - 1][j] != '@') {
            neighbors++;
        } 
        if (j < maze[0].length - 1 && maze[i][j + 1] != '@') {
            neighbors++;
        } 
        if (i < maze.length - 1 && maze[i + 1][j] != '@') {
            neighbors++;
        } 
        if (j > 0 && maze[i][j - 1] != '@') {
            neighbors++;
        } 
        if (neighbors == 1) {
            return true;
        }
        return false;
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

    public SimpleStack getDeadends() {
        return deadends;
    }
    
        
    
    
}
