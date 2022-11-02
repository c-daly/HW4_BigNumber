package linkedList.interfaces;

public interface ILinkedList<T extends Comparable<T>> extends Iterable<T> {
    int length();

    void add(T val);

    void addAtHead(T val);

    T get(int index);

    void set(int index, T value);

    void remove(int index);

    ILinkedListIterator<T> iterator();
}
