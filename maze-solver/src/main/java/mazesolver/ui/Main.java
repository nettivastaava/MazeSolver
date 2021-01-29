package mazesolver.ui;

import java.awt.Point;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import mazesolver.domain.Maze;

public class Main {
    public static void main(String[] args) {
        Maze m = new Maze(6, 9, "maze1.txt");
        
        m.printMaze();
        m.solve();
        
        m.printMaze();
        
        
    
        
    }
}
