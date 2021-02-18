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
        this.values[size] = value;
        size++;
    }
    
    public T removeFirst() {
        T first = this.values[indexOfFirst];
        this.values[indexOfFirst]=null;
        indexOfFirst++;
        size--;
        
        return first;
    }
    
    public boolean isNotEmpty() {
        return this.size > 0;
    }
}
