package mazesolver.domain;

public class MazeQueue<T> {
    private T[] values;
    private int size;
    private int indexOfFirst;
    
    public MazeQueue() {
        this.values = (T[]) new Object[10];
        this.size = 0;
        this.indexOfFirst = 0;
    }
    
    public void addLast(T value) {
        this.values[indexOfFirst + size] = value;
        size++;
        
        if (size > values.length / 2) {
            increaseCapacity();
        }
    }
    
    public void increaseCapacity() {
        int newSize = values.length * 2;
        T[] newList = (T[]) new Object[newSize];
        
        int index = 0;
        for (int i = indexOfFirst; i < indexOfFirst+size; i++) {
            newList[index] = values[i];
            index++;
        }
        
        indexOfFirst = 0;
        
        this.values = newList;
    }
    
    public void decreaseCapacity() {
        int newSize = values.length / 2;
        
        T[] newList = (T[]) new Object[newSize];
        
        int index = 0;
        for (int i = indexOfFirst; i < indexOfFirst + size; i++) {
            newList[index] = values[i];
            index++;
        }
        
        indexOfFirst = 0;
        
        this.values = newList;
    }
    
    public T removeFirst() {
        T first = this.values[indexOfFirst];
        this.values[indexOfFirst]=null;
        indexOfFirst++;
        size--;
        
        if (indexOfFirst > this.values.length / 2) {
            decreaseCapacity();
        }
        
        return first;
    }
    
    public boolean isNotEmpty() {
        return this.size > 0;
    }
}
