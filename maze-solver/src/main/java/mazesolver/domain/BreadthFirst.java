package mazesolver.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirst {
    char[][] maze;
    String route;
    boolean[][] visited;
    ArrayList<Integer>[] net;
    ArrayDeque<Integer> yj;
    ArrayDeque<Integer> xj;
    String[][] routes;
    
    public BreadthFirst() {
    
    }
    
    public String bfs(char[][] maze) {
        this.maze = maze;
        this.route=null;
        this.visited = new boolean[maze.length][maze[0].length];
        this.routes = new String [maze.length][maze[0].length];

        int n = 9998;

        this.net = new ArrayList[9999];

        for (int i = 1; i <= n; i++) { 
            net[i] = new ArrayList<>();
        }

        yj = new ArrayDeque<Integer>();
        xj = new ArrayDeque<Integer>();

        
        int iX =- 1;
        int iY =- 1;

        for (int i = 1; i < maze.length; i++) {
            for (int j = 1 ;j < maze[0].length; j++) {
                String s = Character.toString(maze[i][j]);
          
                if (s.equals("S")) {
                    iY = i;
                    iX = j;
                }
            }
        }
     
        if (iX == -1 || iY == -1) {
            return null;

        }

        routes[iY][iX] = "";       
        searchNeighbors(iY, iX);

        return this.route;

    }

    public void searchNeighbors(int y, int x) {
        yj.addFirst(y);
        xj.addFirst(x);

        while (!xj.isEmpty() && !yj.isEmpty()) {

            y = yj.removeFirst();

            x = xj.removeFirst();

            visited[y][x] = true;

            String s = Character.toString(maze[y][x]);

            if (s.equals("F")) {           
                this.route = routes[y][x];
                return;          
            }

            if (y < maze.length-1 && isUncharted(y + 1, x)) {
                yj.addLast(y + 1);
                xj.addLast(x);  
                routes[y + 1][x] = routes[y][x] + "A";
            }

            if (y > 0 && isUncharted(y - 1, x)) {
                yj.addLast(y - 1);
                xj.addLast(x);
                routes[y - 1][x] = routes[y][x] + "Y";
            }               
               
            if (0 < x && isUncharted(y, x - 1)) {
                yj.addLast(y);
                xj.addLast(x - 1);
                routes[y][x - 1] = routes[y][x] + "V";
            }
                
            if (x < maze[0].length - 1 && isUncharted(y, x + 1)) {
                yj.addLast(y);
                xj.addLast(x + 1);
                this.routes[y][x + 1]=routes[y][x] + "O";
            }            
        }
    }
  

    public boolean isUncharted(int y, int x) {

        String s = Character.toString(maze[y][x]);

        if (s.equals("@") || visited[y][x] == true) {

            return false;

        } else 
            visited[y][x] = true;
            return true;

    }
}
