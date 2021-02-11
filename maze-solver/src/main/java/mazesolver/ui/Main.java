package mazesolver.ui;

import mazesolver.domain.BreadthFirst;
import mazesolver.domain.Maze;
import mazesolver.domain.Wallfollower;
import mazesolver.domain.ListStructure;

public class Main {
    public static void main(String[] args) { 
        
        Maze m = new Maze(6, 9, "maze1.txt");
        
        BreadthFirst bfs1 = new BreadthFirst();
        Wallfollower wf1 = new Wallfollower();
        ListStructure ls = new ListStructure();
        
        
        
        System.out.println("WF: " + wf1.searchPath(m.getMaze()));
        System.out.println("");
        System.out.println("BFS: " + bfs1.bfs(m.getMaze()));
        System.out.println("");
        
        m.printMaze();
        System.out.println(m.solve());
        System.out.println("");
        
        
        ls.addValue(1);
        ls.addValue(5);
        ls.addValue(-2);
        
        while(ls.isEmpty()) {
            System.out.println(ls.getNext());
        }
        
    
        
    }
}
