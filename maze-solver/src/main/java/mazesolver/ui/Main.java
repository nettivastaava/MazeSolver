package mazesolver.ui;

import mazesolver.domain.Maze;

public class Main {
    public static void main(String[] args) {
        Maze m = new Maze(6, 9, "maze1.txt");
        
        System.out.println(m.getMaze()[1][1]);
        
        m.printMaze();
        m.solve();
        
        m.printMaze();
        
        
    
        
    }
}
