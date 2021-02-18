
import mazesolver.domain.SimpleStack;
import mazesolver.domain.Maze;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class SimpleStackTest {
    SimpleStack s;
    
    @Before
    public void setUp() {
        s = new SimpleStack();
    }
    
    @Test
    public void sizeIsZeroAtStart() {
        assertEquals(0, s.getSize());
    }
    
    @Test
    public void addingValuesIncreaseSize() {
        s.addValue(2);
        assertEquals(1, s.getSize());
        
        s.addValue(1);
        assertEquals(2, s.getSize());
    }
    
    @Test
    public void topValueIsRemoved() {
        s.addValue(2);
        s.addValue(1);
        
        assertEquals(1, s.getNext());
        assertEquals(2, s.getNext());
    }
    
    @Test
    public void sizeIsDoubled() {
        assertEquals(s.getValues().length, 10);
        
        s.increaseCapacity();
        
        assertEquals(s.getValues().length, 20);
    }
    
    @Test
    public void sizeIsHalved() {
        assertEquals(s.getValues().length, 10);
        
        s.decreaseCapacity();
        
        assertEquals(s.getValues().length, 5);
    }
}
