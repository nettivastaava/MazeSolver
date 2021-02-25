package mazesolver.domain;


public class Wallfollower {
    boolean[][] visited;
    char[][] maze;
    int iY;
    int iX;
    String route;
    String[][] routes;

    public Wallfollower() {
    }
    
    public String searchPath(char[][] laby) {
        this.maze = laby;
        this.visited = new boolean[laby.length][laby[0].length];
        this.routes = new String[laby.length][laby[0].length];
        this.route = "no path available";
        this.iY = -1;
        this.iX = -1;
        
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
        
        depthFirst(iY, iX);       
        return this.route;
    }
    
    public void depthFirst(int y, int x) {                
        visited[y][x] = true;
        
        if (maze[y][x] == 'F') {
            route = routes[y][x];
            return;
        }
                
        if (isUncharted(y + 1, x) && y < maze.length - 1) {
            routes[y + 1][x] = routes[y][x] + "A";
            depthFirst(y + 1, x);
        }

        if (isUncharted(y - 1, x) && y > 0) {
            routes[y - 1][x] = routes[y][x] + "Y";
            depthFirst(y - 1, x);
        }               
                
        if (isUncharted(y, x - 1) && 0 < x) {
            routes[y][x - 1] = routes[y][x] + "V";
            depthFirst(y, x - 1); 
        }
                
        if (isUncharted(y, x + 1) && x < maze[0].length - 1) {
            routes[y][x + 1] = routes[y][x] + "O";
            depthFirst(y, x + 1);
        }    
    }
    
    public boolean isUncharted(int y, int x) {
        String s = Character.toString(maze[y][x]);
        if (s.equals("@") || visited[y][x]) {
            return false;
        } else {
            return true;
        }
    }
}
