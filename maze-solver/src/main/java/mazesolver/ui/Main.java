package mazesolver.ui;

import mazesolver.domain.BreadthFirst;
import mazesolver.domain.Maze;
import mazesolver.domain.Wallfollower;
import mazesolver.domain.MazeQueue;

public class Main {
    public static void main(String[] args) { 
        
        Maze m = new Maze(10, 10, "maze2.txt");
                
        m.printMaze();
        BreadthFirst bfs1 = new BreadthFirst();
        Wallfollower wf1 = new Wallfollower();
        
        long start = System.nanoTime();
        System.out.println("WF: " + wf1.searchPath(m.getMaze()));
        long end = System.nanoTime();
        long elapsed = end - start;
        System.out.println(elapsed);
        System.out.println("");
        
        start = System.nanoTime();
        System.out.println("BFS: " + bfs1.bfs(m.getMaze()));
        end = System.nanoTime();
        elapsed = end - start;
        System.out.println(elapsed);
        System.out.println("");
        
        start = System.nanoTime();
        System.out.println(m.solve());
        end = System.nanoTime();
        elapsed = end - start;
        System.out.println(elapsed);
        System.out.println("");
        
        
    }
}
