import mazesolver.domain.Maze;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import mazesolver.domain.BreadthFirst;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class BFSTest {
    @Rule   
    public TemporaryFolder testFolder = new TemporaryFolder();
    Maze maze;
    BreadthFirst bfs;
    File asciiFile;
        
    Maze bigMaze;
    File asciiFile2;
        
    @Before
    public void setUp() throws Exception {
        asciiFile = testFolder.newFile("asciiFile.txt");
        asciiFile2 = testFolder.newFile("asciiFile2.txt");
            
        try (FileWriter file = new FileWriter(asciiFile.getAbsolutePath())) {
            file.write("@@@@@@@@@\n");
            file.write("@S......@\n");
            file.write("@.@@.@@.@\n");
            file.write("@.@@@@@.@\n");
            file.write("@..F@@..@\n");
            file.write("@@@@@@@@@\n");
        }
        
        try (FileWriter file = new FileWriter(asciiFile2.getAbsolutePath())) {
            file.write("@@@@@@@@@@@@@@@@@@@@\n");
            file.write("@.@........@.....@.@\n");
            file.write("@...@.@.@@...@@@...@\n");
            file.write("@@.@@.@.@@@@@@@@@.@@\n");
            file.write("@..@..@S......@@...@\n");
            file.write("@.@@@@@@@@@@.@@@@.@@\n");
            file.write("@.....@@.....@.@...@\n");
            file.write("@.@.@.@@.@@@@@.@@.@@\n");
            file.write("@.@.@.@@.@...@.@...@\n");
            file.write("@@@.@.@@.@.@...@@.@@\n");
            file.write("@.@.@.@@.@.@.@@@@.@@\n");
            file.write("@.@.@.@@.@.@.@....@@\n");
            file.write("@...@.@@...@.@.@@.@@\n");
            file.write("@.@@@.@@@@@@.@.@@..@\n");
            file.write("@.@...@@.....@.@@@@@\n");
            file.write("@.@@@@@..@@@@@@@@@.@\n");
            file.write("@....@@@@@@@....@@.@\n");
            file.write("@@@@.......@.@@@@..@\n");
            file.write("@....@@@@@..F.....@@\n");
            file.write("@@@@@@@@@@@@@@@@@@@@\n");
        }
            
            
        maze = new Maze(asciiFile.getAbsolutePath());
        bigMaze = new Maze(asciiFile2.getAbsolutePath());
        bfs = new BreadthFirst();
    }
        
    @Test
    public void correctPathIsFound() {
        assertEquals("AAAOO", bfs.bfs(maze.getMaze()));
    }
    
    @Test
    public void correctPathIsFoundFromBigMaze() {
        assertEquals("YYYVVVVAVAAVAAOOAAAAAAVVAAAAOOOAOOOOOOAOO", bfs.bfs(bigMaze.getMaze()));
    }
        
    @After
    public void tearDown() {
        asciiFile.delete();
    }
}
