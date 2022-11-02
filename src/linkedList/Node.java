package linkedList;

public class Node<T> {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node() {}
    public Node(T val) {
        this.value = val;
        this.next = null;
        this.prev = null;
    }

    public Node(T val, Node next) {
        this.value = val;
        this.next = next;
        this.prev = null;
    }

    public Node(T val, Node next, Node prev) {
        this.value = val;
        this.next = next;
        this.prev = prev;
    }
}
