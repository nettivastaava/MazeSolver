import mazesolver.domain.Maze;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import mazesolver.domain.Wallfollower;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


public class WFTest {
    @Rule   
        public TemporaryFolder testFolder = new TemporaryFolder();
        Maze maze;
        Maze bigMaze;
        Wallfollower wf;
        File asciiFile;
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
                      
            maze = new Maze(6, 9, asciiFile.getAbsolutePath());
            wf = new Wallfollower();
            bigMaze = new Maze(20, 20, asciiFile2.getAbsolutePath());
        }
        
        @Test
        public void correctPathIsFound() {
            assertEquals("AAAOO", wf.searchPath(maze.getMaze()));
        }
        
        @Test
        public void correctPathIsFoundBigMaze() {
            assertEquals("YYYVVVVAVAAVAAOOAAAAAAVVAAAAOOOAOOOOOOAOO", wf.searchPath(bigMaze.getMaze()));
        }
        
        @After
        public void tearDown() {
            asciiFile.delete();
            asciiFile2.delete();
        }
}
