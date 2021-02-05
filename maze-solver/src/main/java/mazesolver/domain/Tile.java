
package mazesolver.domain;


public class Tile {
    int y;
    int x;
    
    public Tile(int y, int x) {
        this.y=y;
        this.x=x;
    }
    
    public String toString() {
        return this.y + ":" + this.x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    
    
}
