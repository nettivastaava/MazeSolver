package mazesolver.ui;

import mazesolver.domain.Maze;

public class Main {
    public static void main(String[] args) {
        Maze m = new Maze(7, 7, "maze3.txt");
        
        m.printMaze();
        m.solve();
        
        m.printMaze();
        
        
    
        
    }
}
