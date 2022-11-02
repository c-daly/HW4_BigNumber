package linkedList;

import linkedList.interfaces.ILinkedListIterator;

import java.util.Iterator;

public class LinkedListIterator<T> implements ILinkedListIterator<T> {
    private Node<T> current;
    private Node<T> head;

    // initialize pointer to head of the list for iteration
    public LinkedListIterator(Node<T> head)
    {
        this.head = head;
        this.current = head;
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        if (current == null || current.value == null) {
            return false;
        }
        return current.next != null;
    }

    // return current data and update pointer
    public T next() {
        if (current == null) {
            return null;
        }
        T data = current.value;
        current = current.next;
        return data;

    }

    public T prev() {
        T data = current.value;
        current = current.prev;
        return data;
    }

   // implement if needed
    public void remove()
    {
        Node<T> prev = current.prev;
        Node<T> next = current.next;

        next.prev = prev;
        prev.next = next;

        current = next;
    }

    public void set(T value) {
        current.value = value;
    }
}
