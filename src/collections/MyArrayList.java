package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MyArrayList<T> implements ListInterface<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int CAPACITY_MULTIPLIER = 2;
    private static final double THRESHOLD = 0.75;

    private T[] array;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(Collection<? extends T> collection) {
        array = collection.toArray((T[]) new Object[collection.size()]);
        size = collection.size();
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    @Override
    public T get(int indexOfElement) {
        checkIndex(indexOfElement);
        return array[indexOfElement];
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                removeAt(i);
                return true;
            }
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

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void ensureCapacity() {
        if (size >= array.length * THRESHOLD) {
            int newCapacity = array.length * CAPACITY_MULTIPLIER;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void bubbleSort() {
        boolean swapped;
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> void sortCollection(Collection<T> collection) {
        T[] array = collection.toArray((T[]) new Comparable[collection.size()]);
        boolean swapped;
        int size = array.length;

        // bubble
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        int i = 0;
        for (T element : array) {
            if (collection instanceof List) {
                ((List<T>) collection).set(i++, element);
            }
        }
    }
}