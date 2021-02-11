package mazesolver.domain;


public class Wallfollower {
    boolean[][] visited;
    char[][] maze;
    int iY;
    int iX;
    String route;
    private String[][] routes;


    
    public Wallfollower() {
    }
    
    public String searchPath(char[][] laby) {
        this.maze = laby;
        this.visited = new boolean[laby.length][laby[0].length];
        this.routes = new String[laby.length][laby[0].length];
        
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
        
        depthFirst(iY, iX);
        
        return route;
    }
    
    public void depthFirst(int y, int x) {                
        visited[y][x]=true;
        
        if (maze[y][x]=='F') {
            route=routes[y][x];
            return;
        }
        
        

                
            if (y < maze.length-1 && maze[y + 1][x] != '@' && !visited[y + 1][x]) {
                routes[y + 1][x] = routes[y][x] + "A";
                depthFirst(y + 1, x);
            }

            if (y > 0 && maze[y - 1][x]!= '@' && !visited[y - 1][x]) {
                routes[y - 1][x] = routes[y][x] + "Y";
                depthFirst(y - 1, x);
            }               
                
            if (0 < x && maze[y][x - 1] != '@' && !visited[y][x -1]) {
                routes[y][x - 1]=routes[y][x] + "V";
                depthFirst(y, x - 1); 
            }
                
            if (x < maze[0].length - 1 && maze[y][x + 1] != '@' && !visited[y][x + 1]) {
                routes[y][x + 1] = routes[y][x] + "O";
                depthFirst(y, x + 1);
            }
                

            
    }
}
