package mazesolver.ui;

import mazesolver.domain.BreadthFirst;
import mazesolver.domain.Maze;
import mazesolver.domain.Wallfollower;
import mazesolver.domain.DeadendFiller;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        Scanner s = new Scanner(System.in);
        Wallfollower wf = new Wallfollower();
        BreadthFirst bfs = new BreadthFirst();
        DeadendFiller df = new DeadendFiller();
        
        while(true) {
            System.out.println("Number of rows:");
            int rows = Integer.valueOf(s.nextLine());
            System.out.println("Number of columns:");
            int columns = Integer.valueOf(s.nextLine());
            System.out.println("Name of the file:");
            String name = s.nextLine();

            Maze m = new Maze(rows, columns, name);

            m.printMaze();

            System.out.println("Choose the algorithm used to solve the maze");
            System.out.println("1: Wall follower");
            System.out.println("2: Breadth first");
            System.out.println("3: Dead end filler (simply connected mazes only)");
            System.out.println("4: Dead end filler with breadth first");

            int algorithm = Integer.valueOf(s.nextLine());

            if (algorithm == 1) {
                long start = System.nanoTime();
                String path = wf.searchPath(m.getMaze());
                System.out.println("WF: " + path + " " + path.length());
                long end = System.nanoTime();
                long elapsed = end - start;
                System.out.println(elapsed/1e9);
                System.out.println("");
            } else if (algorithm == 2) {
                long start = System.nanoTime();
                String path = bfs.bfs(m.getMaze());
                System.out.println("BFS: " + path + " " + path.length());
                long end = System.nanoTime();
                long elapsed = end - start;
                System.out.println(elapsed/1e9);
                System.out.println("");
            } else if (algorithm == 3) {
                long start = System.nanoTime();
                String path = df.defCompleteMaze(m.getMaze());
                System.out.println("DEF: " + path + " " + path.length());
                long end = System.nanoTime();
                long elapsed = end - start;
                System.out.println(elapsed/1e9);
                System.out.println("");
            } else if (algorithm == 4) {
                long start = System.nanoTime();
                String path = df.defWithBFS(m.getMaze());
                System.out.println("DEF: " + path + " " + path.length());
                long end = System.nanoTime();
                long elapsed = end - start;
                System.out.println(elapsed/1e9);
                System.out.println("");
            } else {
                System.out.println("Invalid input");
                System.out.println("");
            }
            
            System.out.println("Solve another one? (type 'q' to quit or anything else to continue)");
            String quit = s.nextLine();
            
            if (quit.equals("q")) {
                break;
            }
            
            
        }
        
    }
}
