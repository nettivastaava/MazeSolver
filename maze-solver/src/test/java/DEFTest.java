import mazesolver.domain.Maze;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import mazesolver.domain.DeadendFiller;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class DEFTest {
    @Rule   
    public TemporaryFolder testFolder = new TemporaryFolder();
    Maze maze;
    File asciiFile;   
    Maze bigMaze;
    File asciiFile2;
    DeadendFiller def;
    File asciiFile3;
    Maze cycledMaze;
        
    @Before
    public void setUp() throws Exception {
        asciiFile = testFolder.newFile("asciiFile.txt");
        asciiFile2 = testFolder.newFile("asciiFile2.txt");
        asciiFile3 = testFolder.newFile("asciiFile3.txt");
                   
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
        
         try (FileWriter file = new FileWriter(asciiFile3.getAbsolutePath())) {
            file.write("@@@@@@@@@@\n");
            file.write("@S.......@\n");
            file.write("@.@@.@@@.@\n");
            file.write("@.@@@@.@.@\n");
            file.write("@.@F@@...@\n");
            file.write("@.@.@@.@.@\n");
            file.write("@.@......@\n");
            file.write("@.@@@@@@.@\n");
            file.write("@........@\n");
            file.write("@@@@@@@@@@\n");
        }
           
        def = new DeadendFiller();
        maze = new Maze(asciiFile.getAbsolutePath());
        bigMaze = new Maze(asciiFile2.getAbsolutePath());       
        cycledMaze = new Maze(asciiFile3.getAbsolutePath());
        
    }
        
    @Test
    public void correctAmountOfDeadends() {
        def.setMaze(maze.getMaze());
        def.findDeadends();
                    
        assertEquals(def.getDeadends().getSize(), 2);       
    }
        
    @Test
    public void noDeadendsAfterFilling() {
        def.fillDeadends();
        assertEquals(0, def.getDeadends().getSize());
    }
        
    @Test
    public void correctPathIsFound() {
        assertEquals("AAAOO", def.defCompleteMaze(maze.getMaze()));            
    }
    
    @Test
    public void correctPathIsFoundBigMaze() {
        assertEquals("YYYVVVVAVAAVAAOOAAAAAAVVAAAAOOOAOOOOOOAOO", def.defCompleteMaze(bigMaze.getMaze()));
    }
    
    @Test
    public void correctPathIsFoundCycled() {
        assertEquals("OOOOOOOAAAVVAAVVVYY", def.defWithBFS(cycledMaze.getMaze()));
    }

        
    @After
    public void tearDown() {
        asciiFile.delete();
        asciiFile2.delete();
        asciiFile3.delete();
    }
    
    
}
