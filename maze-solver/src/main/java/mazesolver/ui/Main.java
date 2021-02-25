package mazesolver.ui;

import mazesolver.domain.BreadthFirst;
import mazesolver.domain.Maze;
import mazesolver.domain.Wallfollower;
import mazesolver.domain.DeadendFiller;

public class Main {
    public static void main(String[] args) { 
        
        Maze m = new Maze(40, 60, "maze6.txt");
                
        m.printMaze();
        BreadthFirst bfs1 = new BreadthFirst();
        Wallfollower wf1 = new Wallfollower();
        DeadendFiller df1 = new DeadendFiller();
        
     
        
        double start = System.nanoTime();
        System.out.println("BFS: " + bfs1.bfs(m.getMaze()));
        double end = System.nanoTime();
        double elapsed = end - start;
        System.out.println(elapsed);
        System.out.println("");
        
  
        
    }
}
