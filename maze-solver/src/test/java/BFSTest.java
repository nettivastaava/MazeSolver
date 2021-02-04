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
            bfs = new BreadthFirst();
        }
        
        @Test
        public void correctPathIsFound() {
            assertEquals("AAAOO", bfs.bfs(maze.getMaze()));
        }
        
        @After
        public void tearDown() {
            asciiFile.delete();
        }
}
