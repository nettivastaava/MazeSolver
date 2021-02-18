
package mazesolver.domain;


public class SimpleStack<T> {
    private T[] values;
    private int size;
    
    public SimpleStack() {
        this.values = (T[]) new Object[10];
        this.size = 0;
    }
    
     /**
     * Adds an object to the top of the stack
     * 
     * @param value The element to be added
     */
    public void addValue(T value) {
        this.values[size] = value;
        this.size++;
        if (this.values.length / 2 < size)  {
            increaseCapacity();
        }
    }
    
    public void increaseCapacity() {
        int newSize = values.length * 2;
        
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
        T next = values[size - 1];
        values[size - 1] = null;
        size--;
        
        if (this.values.length > 10 && this.values.length / 4 > size) {
            decreaseCapacity();
        }
        
        return next;
    }

    public T[] getValues() {
        return values;
    }

    public int getSize() {
        return size;
    }
    
     /**
     * The method used to check if the stack has any values in it
     *
     * @return True if the stack has any values in it, otherwise returns false
     */
    public boolean isNotEmpty() {
        return this.size > 0;
    }  
}
