package prj5;

/**
 * Group 69
 * 
 * LinkedList Interface
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 * @param <T> Object
 */
public interface LinkedListInterface<T> {
    /**
     * Adds the object to the end of the list.
     * 
     * @precondition anEntry cannot be null.
     * @param anEntry The object to add.
     * @throws IllegalArgumentException if anEntry is null.
     */
    public void add(T anEntry);

    /**
     * Gets the number of elements in the list.
     * 
     * @return The number of elements in the list.
     */
    public int size();

    /**
     * Gets the object at the index in the list.
     * 
     * @param index The index in the list
     * @return The object at the specified index.
     */
    public T get(int index);

    /**
     * Gets the first index of the given object in the list.
     * 
     * @param anEntry The object to look for.
     * @return The index of the given entry
     */
    public int indexOf(T anEntry);

    /**
     * Returns an array of the objects that the list contains. For example if
     * the list contains 1, 2, 3 the array will be [1, 2, 3].
     * 
     * @return The array of objects that the list contains
     */
    public Object[] toArray();

    /**
     * Returns a string representation of the list. For example, the string "{1,
     * 2, 3}" (without quotations) will re returned if the list contains 1, 2,
     * 3.
     * 
     * @return The string representation of the list
     */
    public String toString();

    /**
     * Determines if the list and another object are equal. They are considered
     * equal if both are lists that contain the same objects in the same order.
     * 
     * @param other The other object to determine if equal to.
     * @return True if the two objects have the same objects in the same order,
     *         false otherwise
     */
    public boolean equals(Object other);
}
