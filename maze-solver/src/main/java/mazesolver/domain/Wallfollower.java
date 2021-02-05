package mazesolver.domain;


public class Wallfollower {
    boolean[][] visited;
    char[][] maze;
    int iY;
    int iX;
    StringBuilder route;
    
    public Wallfollower() {
    }
    
    public String searchPath(char[][] laby) {
        this.maze = laby;
        this.visited = new boolean[laby.length][laby[0].length];
        route = new StringBuilder();
        
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
        
        return route.toString();
    }
    
    public void depthFirst(int y, int x) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x]=true;
        
        for(int i = 0; i <= 3; i++) {

                if (i == 0) {
                    if (y < maze.length-1 && maze[y + 1][x] != '@') {
                        route.append("A");
                        depthFirst(y + 1, x);
                    }

                } else if (i == 1) {

                    if (y > 0 && maze[y - 1][x]!= '@') {
                        route.append("Y");
                        depthFirst(y - 1, x);
                    }               
                } else if (i == 2) {
                    if (0 < x && maze[y][x - 1] != '@') {
                        route.append("V");
                        depthFirst(y, x - 1); 
                    }
                } else if (i == 3) {
                    if (x < maze[0].length - 1 && maze[y][x + 1] != '@') {
                        route.append("O");
                        depthFirst(y, x + 1);

                    }
                }

            }
    }
}
