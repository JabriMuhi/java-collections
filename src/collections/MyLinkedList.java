package collections;

import java.util.Collection;

public class MyLinkedList<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public MyLinkedList() {
    }

    public MyLinkedList(Collection<? extends T> collection) {
        addAll(collection);
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int indexOfElement) {
        checkIndex(indexOfElement);
        Node<T> current = getNode(indexOfElement);
        return current.data;
    }

    @Override
    public boolean remove(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void addAll(Collection<? extends T> collection) {
        for (T element : collection) {
            add(element);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    private Node<T> getNode(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bubbleSort() {
        if (size < 2) return;
        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            while (current != null && current.next != null) {
                if (((Comparable<T>) current.data).compareTo(current.next.data) > 0) {
                    // Swap data
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
