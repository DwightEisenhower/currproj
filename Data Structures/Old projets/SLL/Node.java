/**
 * Contains a piece of data and any number of references to other nodes
 */
public class Node
{
    public Integer value;
    public Node next;
    public Node(Integer value) {
        this.value = value;
    }
    
    public String toString() {
        return value + ", ";
    }
}