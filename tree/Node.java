public class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;
    Node<T> parent;

    public Node(T data) {
        this.data = data;
    }
}

