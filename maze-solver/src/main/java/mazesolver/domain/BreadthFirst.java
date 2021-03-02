package mazesolver.domain;

import java.util.ArrayDeque;

/**
* This class solves a maze using the breadth first search
*/
public class BreadthFirst {
    char[][] maze;
    String route;
    boolean[][] visited;
    MazeQueue que;
    String[][] routes;
    
    public BreadthFirst() {   
    }
    
    /**
    * This class can be thought as constructor that also invokes the methods used to solve the maze
    * 
    * @param maze 2d array that contains the maze to be solved
    * 
    * @return The string that corresponds the transitions needed to get from S to F
    */
    public String bfs(char[][] maze) {
        this.maze = maze;
        this.route = "no path available";
        this.visited = new boolean[maze.length][maze[0].length];
        this.routes = new String [maze.length][maze[0].length];

        que = new MazeQueue();
        
        int iX = -1;
        int iY = -1;

        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze[0].length; j++) {
                String s = Character.toString(maze[i][j]);        
                if (s.equals("S")) {
                    iY = i;
                    iX = j;
                    break;
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

     /**
     *Traverses the tiles in the maze until "F" is reached using breadth first search.
     * 
     *@param y indicates the row of the tile
     * 
     *@param x indicates the column of the tile
     */
    public void searchNeighbors(int y, int x) {
        que.addLast(new Tile(y, x));
        while (que.isNotEmpty()) {
            Tile t = (Tile) que.removeFirst();
            y = t.getY();
            x = t.getX();
            visited[y][x] = true;
            String s = Character.toString(maze[y][x]);

            if (s.equals("F")) {           
                this.route = routes[y][x];
                return;          
            }

            if (isUncharted(y + 1, x) && y < maze.length - 1) {
                que.addLast(new Tile(y + 1, x));
                routes[y + 1][x] = routes[y][x] + "A";
            }

            if (isUncharted(y - 1, x) && y > 0) {
                que.addLast(new Tile(y - 1, x));
                routes[y - 1][x] = routes[y][x] + "Y";
            }               
               
            if (isUncharted(y, x - 1) && 0 < x) {
                que.addLast(new Tile(y, x - 1));
                routes[y][x - 1] = routes[y][x] + "V";
            }
                
            if (isUncharted(y, x + 1) && x < maze[0].length - 1) {
                que.addLast(new Tile(y, x + 1));
                routes[y][x + 1] = routes[y][x] + "O";
            }            
        }
    }
  
    /**
     * Checks if the corresponding tile is unvisited and that it is not a wall
     * 
     * @param y indicates the row of the tile
     * 
     * @param x indicates the column of the tile
     * 
     * @return true if the tile is yet unvisited and false, if not
     */
    public boolean isUncharted(int y, int x) {
        String s = Character.toString(maze[y][x]);
        if (s.equals("@") || visited[y][x]) {
            return false;
        } else  {
            return true;
        }
    }
}
