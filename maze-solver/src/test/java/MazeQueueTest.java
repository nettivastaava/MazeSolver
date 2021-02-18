import mazesolver.domain.MazeQueue;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MazeQueueTest {
    private MazeQueue queue;
    
    @Before
    public void setUp() {
        queue = new MazeQueue();
    }
    
    @Test
    public void sizeIsZeroAtStart() {
        assertEquals(queue.getSize(), 0);
    }
    
    @Test
    public void addingValuesIncreaseSize() {
        queue.addLast(2);
        assertEquals(queue.getSize(), 1);
        
        queue.addLast(3);
        assertEquals(queue.getSize(), 2);
    }
    
    @Test
    public void firstValueIsRemoved() {
        queue.addLast(1);
        queue.addLast(2);
        assertEquals(queue.removeFirst(), 1);
        
        queue.addLast(3);
        assertEquals(queue.removeFirst(), 2);
    }
    
    @Test
    public void indexOfFirstChangesProperly() {
        queue.addLast(1);
        queue.addLast(2);
        assertEquals(queue.getIndexOfFirst(), 0);
        
        queue.removeFirst();
        assertEquals(queue.getIndexOfFirst(), 1);
    }
    
    @Test
    public void sizeIsDoubled() {
        assertEquals(queue.getValues().length, 10);
        
        queue.increaseCapacity();
        
        assertEquals(queue.getValues().length, 20);
    }
    
    @Test
    public void sizeIsHalved() {
        assertEquals(queue.getValues().length, 10);
        
        queue.decreaseCapacity();
        
        assertEquals(queue.getValues().length, 5);
    }
}
