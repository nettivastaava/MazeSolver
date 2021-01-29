
package mazesolver.domain;


public class Node {
    int y;
    int x;
    Node parent;
    Node destination;
    
    public Node(int y, int x, Node des) {
        this.y=y;
        this.x=x;
        this.destination=des;
    }
}
