package mazesolver.domain;

/**
* This class imitates Java's ArrayDeque and is used to implement the breadth-first algorithm
*/
public class MazeQueue<T> {
    private T[] values;
    private int size;
    private int indexOfFirst;
    
    public MazeQueue() {
        this.values = (T[]) new Object[10];
        this.size = 0;
        this.indexOfFirst = 0;
    }
    
    /**
     * Adds a value to the end of the queue
     * 
     * @param value the value to be added to the queue
     */
    public void addLast(T value) {
        if (values[values.length - 1] != null) {
            increaseCapacity();
        }
        
        this.values[indexOfFirst + size] = value;
        size++;
        
        
    }
    
    /**
     * Copies the values of the queue to another, bigger array
     */
    public void increaseCapacity() {
        int newSize = values.length + values.length / 2;

        T[] newList = (T[]) new Object[newSize];
        
        int index = 0;
        for (int i = indexOfFirst; i < indexOfFirst + size; i++) {
            newList[index] = values[i];
            index++;
        }
        
        indexOfFirst = 0;
        
        this.values = newList;
    }
    
     /**
     * Copies the values of the queue to another, smaller array
     */
    public void decreaseCapacity() {
        int newSize = (indexOfFirst + 1);

        T[] newList = (T[]) new Object[newSize];
        int index = 0;
        for (int i = indexOfFirst; i < indexOfFirst + size; i++) {
            newList[index] = values[i];
            index++;
        }
        
        indexOfFirst = 0;
        
        this.values = newList;
    }
    
     /**
     * Removes the least recently added value from the queue
     * 
     * @return the value added to the queue least recently
     */
    public T removeFirst() {
        T first = this.values[indexOfFirst];
        this.values[indexOfFirst]=null;
        indexOfFirst++;
        size--;
        
        if (indexOfFirst >= this.values.length / 2 && indexOfFirst >= 10 ) {
            decreaseCapacity();
        }
        
        return first;
    }

    public T[] getValues() {
        return values;
    }

    public int getSize() {
        return size;
    }

    public int getIndexOfFirst() {
        return indexOfFirst;
    }
    
    /**
    *Checks whether the queue is empty or not
    * 
    *@return true is queue has values in it, and false if it is empty
    */
    public boolean isNotEmpty() {
        return this.size > 0;
    }
}
