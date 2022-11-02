package linkedList;

import linkedList.interfaces.ILinkedList;
import linkedList.interfaces.ILinkedListIterator;

//public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
public class LinkedList<T extends Comparable<T>> implements ILinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
       head = new Node<T>();
       tail = head;
    }

    public LinkedList(Node<T> head) {
        this.head = head;
    }

    public int length() {
        var cp = head;
        int counter = 0;

        // dunno why I have nodes that should be null
        // except they have a next or prev field initialized
        while (cp.next != null && cp.next.value != null) {
            cp = cp.next;
            counter += 1;
        }
        return counter + 1;
    }

    public void add(T val) {
       if (head == null) {
           head = new Node<T>(val);
       } else {
          var lastNode = getLastNode();
          var newNode = new Node<T>(val);

          lastNode.next = newNode;
          newNode.prev = lastNode;

       }
    }

    public void addAtHead(T val) {
        if(head == null) {
            head = new Node<T>(val);
        } else {
            Node<T> tempPointer = new Node<T>(val, head);
            head.prev = tempPointer;
            head = tempPointer;
        }
    }

    public T get(int index) {
        return getNodeAtIndex(index).value;
    }

    public void set(int index, T value) {
        getNodeAtIndex(index).value = value;
    }

    public void remove(int index) {
       var nodeToRemove = getNodeAtIndex(index);
       var prevNode = nodeToRemove.prev;
       var nextNode = nodeToRemove.next;

       prevNode.next = nextNode;
       nextNode.prev = prevNode;
    }

    public ILinkedListIterator<T> iterator() {
        if(head == null) {
            throw new IllegalStateException("head is null");
        }
        return new LinkedListIterator<T>(head);
    }

    private Node<T> getNodeAtIndex(int index) {
        int counter = 0;
        var tp = head;

        while (tp != null) {
            if (counter == index) {
                break;
            } else {
                counter++;
                tp = tp.next;
            }
        }
        return tp;
    }

    private Node<T> getLastNode() {
        var tp = head;

        while(tp.next != null) {
            tp = tp.next;
        }

        return tp;
    }


}
