/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazesolver.domain;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vaxandst
 */
public class Maze {
    char[][] maze;
    List deadends;
    
    public Maze(int n, int m, String file) {
        maze = new char[n][m];
        deadends = new ArrayList<Point>();
        
        try {
            Scanner input = new Scanner(new File("maze1.txt"));

            for (int i = 0; i < n; i++) {
                String s = input.next();

                for (int j = 0; j < m; j++) {
                    maze[i][j] = s.charAt(j);
                }
            }

        } catch (Exception e) {}
        
    }
    
    public void solve() {
        findDeadends();
        fillDeadends();
    }
    
    public void fillDeadends() {
        while(!deadends.isEmpty()) {
            for(int i=0;i<deadends.size();i++) {
                Point current = (Point) deadends.get(i);
                deadends.remove(i);
                fillOne(current.x, current.y);
                
            }
        }
    }
    
    public void fillOne(int i, int j) {
        if (i>0 && maze[i-1][j]=='.') {
            deadends.add(new Point(i-1, j));
        } else if (j<maze[0].length-1 && maze[i][j+1]=='.') {
            deadends.add(new Point(i, j+1));
        } else if (i<maze.length-1 && maze[i+1][j]=='.') {
            deadends.add(new Point(i+1, j));
        } else if (j>0 && maze[i][j-1]=='.') {
            deadends.add(new Point(i, j-1));
        } 
        maze[i][j]='@';
    }
    
    public void findDeadends() {
               
        for (int i=0;i<maze.length;i++) {
            for (int j=0;j<maze[i].length;j++) {
                if (maze[i][j]=='.') {
                    isDeadend(i, j); 
                }
            }
        }
        
    }
    
    public void isDeadend(int i, int j) {
        int neighbors=0;
        if (i>0 && maze[i-1][j]=='.') {
            neighbors++;
        } else if (maze[i-1][j]=='S' || maze[i-1][j]=='F') {
            return;
        }
        if (j<maze[0].length-1 && maze[i][j+1]=='.') {
            neighbors++;
        } else if (maze[i][j+1]=='S' || maze[i][j+1]=='F') {
            return;
        }
        if (i<maze.length-1 && maze[i+1][j]=='.') {
            neighbors++;
        } else if (maze[i+1][j]=='S' || maze[i+1][j]=='F') {
            return;
        }
        if (j>0 && maze[i][j-1]=='.') {
            neighbors++;
        } else if (maze[i][j-1]=='S' || maze[i][j-1]=='F') {
            return;
        }
        if (neighbors==1) {
            deadends.add(new Point(i, j));
        }
    }

    public void printMaze() {
        for (int i=0;i<maze.length;i++) {
            for (int j=0;j<maze[i].length;j++) {
                System.out.print(maze[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
}
