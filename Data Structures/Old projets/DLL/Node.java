public class Node<E>
{
    public Node<E> next;
    public E value;
    public Node(E value) {
        this.value = value;
    }
    
    public static void main() {
        Node<Integer> x = new Node<>(10);
        Node<Double> y = new Node<>(15.5);
        System.out.println(x.value.intValue());
        System.out.println(y.value.doubleValue());
    }
}