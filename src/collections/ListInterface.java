package collections;

import java.util.Collection;

public interface ListInterface<T> {
    void add(T element);
    T get(int indexOfElement);
    boolean remove(T element);
    void addAll(Collection<? extends T> collection);
    int size();
    void clear();
    void bubbleSort();
}
