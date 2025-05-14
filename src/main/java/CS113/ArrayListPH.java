/**
 * A custom implementation of an ArrayList, dynamically resizing when necessary.
 * This class implements the ListInterface<E> interface, providing core list functionalities.
 *
 * @param <E> The type of elements stored in this list.
 */
package CS113;

import java.util.Arrays;

public class ArrayListPH<E> implements ListInterface<E> {

    private E[] array;
    private int count;

    final static int DEFAULT_SIZE = 10;

    /**
     * Constructs an empty ArrayListPH with an initial capacity of 10.
     */
    @SuppressWarnings("unchecked")
    public ArrayListPH() {
        array = (E[]) new Object[DEFAULT_SIZE];
        count = 0;
    }

    /**
     * Doubles the capacity of the array when it is full.
     */
    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    /**
     * Adds an element to the end of the list.
     * @param element The element to be added.
     * @return true if the element was added successfully.
     */
    @Override
    public boolean add(E element) {
        if (count == array.length) resize();
        array[count++] = element;
        return true;
    }

    /**
     * Adds an element at a specific index, shifting subsequent elements.
     * @param index The index where the element should be added.
     * @param element The element to be added.
     */
    @Override
    public void add(int index, E element) {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException();
        if (count == array.length) resize();
        System.arraycopy(array, index, array, index + 1, count - index);
        array[index] = element;
        count++;
    }

    /**
     * Clears the list, removing all elements.
     */
    @Override
    public void clear() {
        Arrays.fill(array, null);
        count = 0;
    }

    /**
     * Checks if the list contains a specific element.
     * @param element The element to search for.
     * @return true if the element is found.
     */
    @Override
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    /**
     * Returns the index of the first occurrence of a specified element.
     * @param object The element to search for.
     * @return The index of the element, or -1 if not found.
     */
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < count; i++) {
            if (object == null ? array[i] == null : object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Retrieves the element at the specified index.
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return array[index];
    }

    /**
     * Checks if the list is empty.
     * @return true if the list is empty.
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Removes the element at the specified index.
     * @param index The index of the element to remove.
     * @return true if removal is successful.
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= count) return false;
        System.arraycopy(array, index + 1, array, index, count - index - 1);
        array[--count] = null;
        return true;
    }

    /**
     * Removes the first occurrence of a specified element.
     * @param element The element to remove.
     * @return true if the element is removed.
     */
    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        return index != -1 && remove(index);
    }

    /**
     * Returns the current size of the list.
     * @return The number of elements in the list.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Sets the element at the specified index.
     * @param index The index to set.
     * @param element The new element.
     */
    @Override
    public void set(int index, E element) {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        array[index] = element;
    }

    /**
     * Returns a string representation of the list.
     * @return A string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(array[i]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
