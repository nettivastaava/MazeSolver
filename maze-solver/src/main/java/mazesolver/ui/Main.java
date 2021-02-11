package mazesolver.ui;

import mazesolver.domain.BreadthFirst;
import mazesolver.domain.Maze;
import mazesolver.domain.Wallfollower;
import mazesolver.domain.StackStructure;

public class Main {
    public static void main(String[] args) { 
        
        Maze m = new Maze(10, 10, "maze2.txt");
        
        BreadthFirst bfs1 = new BreadthFirst();
        Wallfollower wf1 = new Wallfollower();
        
        
        
        System.out.println("WF: " + wf1.searchPath(m.getMaze()));
        System.out.println("");
        System.out.println("BFS: " + bfs1.bfs(m.getMaze()));
        System.out.println("");
        
        m.printMaze();
        System.out.println(m.solve());
        System.out.println("");
        

        
        
    
        
    }
}
