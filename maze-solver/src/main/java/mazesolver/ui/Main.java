package mazesolver.ui;

import mazesolver.domain.BreadthFirst;
import mazesolver.domain.Maze;

public class Main {
    public static void main(String[] args) {
        Maze m = new Maze(10, 10, "maze2.txt");
        
        BreadthFirst bfs1 = new BreadthFirst();
        System.out.println(bfs1.bfs(m.getMaze()));
        
        m.printMaze();
        m.solve();
        
        m.printMaze();
        
        
    
        
    }
}
