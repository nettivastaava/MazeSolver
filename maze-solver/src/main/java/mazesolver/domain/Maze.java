
package mazesolver.domain;

import java.awt.Point;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Maze {
    char[][] maze;
    List deadends;
    int pathY;
    int pathX;
    StringBuilder route;
    
    public Maze(int n, int m, String file) {
        maze = new char[n][m];
        deadends = new ArrayList<Point>();
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
    
    public String solve() {
        findDeadends();
        fillDeadends();
        printMaze();
        findPath(pathY, pathX);
        return "DEF: " + route.toString();
        
    }
    
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
    
    public void fillDeadends() {
        while(!deadends.isEmpty()) {
            for(int i = 0; i < deadends.size(); i++) {
                Point current = (Point) deadends.get(i);        
                deadends.remove(i);
                fillOne(current.x, current.y);
                
            }
        }
    }
    
    public void fillOne(int i, int j) {
        maze[i][j] = '@';
        
        if (i > 1 && maze[i - 1][j] == '.' && isDeadend(i - 1, j)) {
            deadends.add(new Point(i - 1, j));
        } 
        if (j < maze[0].length-2 && maze[i][j + 1] == '.' && isDeadend(i, j + 1)) {
            deadends.add(new Point(i, j + 1));
        } 
        if (i < maze.length-2 && maze[i + 1][j] == '.' && isDeadend(i + 1, j)) {
            deadends.add(new Point(i + 1, j));
        } 
        if (j > 1 && maze[i][j - 1] == '.' && isDeadend(i, j - 1)) {
            deadends.add(new Point(i, j - 1));
        } 
        
    }
    
    public void findDeadends() {
               
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == '.') {
                    if (isDeadend(i, j)) { 
                        deadends.add(new Point(i, j));
                    }
                }
            }
        }
        
    }
    
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

    public List getDeadends() {
        return deadends;
    }
    
        
    
    
}
