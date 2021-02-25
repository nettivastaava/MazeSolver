
package mazesolver.domain;


public class DeadendFiller {
    char[][] maze;
    SimpleStack deadends;
    int pathY;
    int pathX;
    String route;
    
    public DeadendFiller() {
        deadends = new SimpleStack();
    }
    
    public String findPath(char[][] laby) {
        this.maze = laby;
        this.pathY = -1;
        this.pathX = -1;
        
        route = "";
        
        for (int i = 1; i < maze.length; i++) {
            for (int j = 1; j < maze[0].length; j++) {
                String s = Character.toString(maze[i][j]);         
                if (s.equals("S")) {
                    pathY = i;
                    pathX = j;
                    break;
                }
            }
        }
        
        if (pathX == -1 || pathY == -1) {
            return null;
        }
        
        return solve();
    }
    
    public String solve() {
        findDeadends();
        fillDeadends();
        findPath(pathY, pathX);
        return route;
        
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
        if (maze[y][x] == 'F') {
            return;
        } 
        maze[y][x] = '@';
        
        if (y > 0 && maze[y - 1][x] != '@') {          
            route = route + "Y";
            findPath(y - 1, x);
        } else if (x < maze[0].length - 1 && maze[y][x + 1] != '@') {
            route = route + "O";
            findPath(y, x + 1);
        } else if (y < maze.length - 1 && maze[y + 1][x] != '@') {
            route = route + "A";
            findPath(y + 1, x);
        } else if (x > 0 && maze[y][x - 1] != '@') {
            route = route + "V";
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
        if (j < maze[0].length - 2 && maze[i][j + 1] == '.' && isDeadend(i, j + 1)) {
            deadends.addValue(new Tile(i, j + 1));
        } 
        if (i < maze.length - 2 && maze[i + 1][j] == '.' && isDeadend(i + 1, j)) {
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
        } else {
            return false;
        }
    }

    public char[][] getMaze() {
        return maze;
    }

    public SimpleStack getDeadends() {
        return deadends;
    }
 
    public void setMaze(char[][] maze) {
        this.maze = maze;
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
    
}
