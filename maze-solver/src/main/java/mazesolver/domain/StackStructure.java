
package mazesolver.domain;



public class StackStructure<T> {
    private T[] values;
    private int size;
    
    public StackStructure() {
        this.values = (T[]) new Object[10];
        this.size = 0;
    }
    
    public void addValue(T value) {
        this.values[size] = value;
        this.size++;
        if (this.values.length/2 < size)  {
            increaseCapacity();
        }
    }
    
    public void increaseCapacity() {
        int newSize = size * 2;
        
        T[] newList = (T[]) new Object[newSize];
        
        for (int i = 0; i < size; i++) {
            newList[i] = values[i];
        }
        
        this.values = newList;
    }
    
    public void decreaseCapacity() {
        int newSize = values.length / 2;
        
        T[] newList = (T[]) new Object[newSize];
        
        for (int i = 0; i < size; i++) {
            newList[i] = values[i];
        }
        
        this.values = newList;
    }
    
    public T getNext() {
        T next = values[size-1];
        values[size-1]=null;
        size--;
        
        if (this.values.length > 10 && this.values.length / 4 > size) {
            decreaseCapacity();
        }
        
        return next;
    }

    public int getSize() {
        return size;
    }
    
    public boolean isNotEmpty() {
        return this.size > 0;
    }
    
    
}
