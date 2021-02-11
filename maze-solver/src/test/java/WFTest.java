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
        Wallfollower wf;
        File asciiFile;
        
        @Before
        public void setUp() throws Exception {
            asciiFile = testFolder.newFile("asciiFile.txt");
            
            try (FileWriter file = new FileWriter(asciiFile.getAbsolutePath())) {
                file.write("@@@@@@@@@\n");
                file.write("@S......@\n");
                file.write("@.@@.@@.@\n");
                file.write("@.@@@@@.@\n");
                file.write("@..F@@..@\n");
                file.write("@@@@@@@@@\n");
            }
                      
            maze = new Maze(6, 9, asciiFile.getAbsolutePath());
            wf = new Wallfollower();
        }
        
        @Test
        public void correctPathIsFound() {
            assertEquals("AAAOO", wf.searchPath(maze.getMaze()));
        }
        
        @After
        public void tearDown() {
            asciiFile.delete();
        }
}
