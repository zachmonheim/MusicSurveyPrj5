/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Group 69
 * 
 * LinkedList 
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * @param <T> Object
 */
public class LinkedList<T> implements LinkedListInterface<T> {

    private Node<T> head;
    private int size;

    /**
     * LinkedList constructor
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Adds object to end
     * 
     * @param anEntry T
     * @throws IllegalArgumentException
     */
    public void add(T anEntry) {
        Node<T> newNode = new Node<T>(anEntry);
        if (size != 0) {
            Node<T> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
        else {
            head = newNode;
        }
        size++;
    }

    /**
     * Gets number of elements
     * 
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Gets object at index
     * 
     * @throws IllegalArgumentException 
     * @param index 
     * @return T
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException();
        }
        int currentIndex = 0;
        T data = null;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentIndex == index) {
                data = currentNode.getData();
            }
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
        return data;
    }

    /**
     * Gets index of object
     * 
     * @param anEntry T
     * @throws IllegalArgumentException
     * @return int index (-1 if not found)
     */
    public int indexOf(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
        int frontIndex = -1;
        int currentIndex = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(anEntry)) {
                return currentIndex;
            }
            currentIndex++;
        }
        return frontIndex;
    }

    /**
     * Sorts by song title
     * 
     * @param <T> Object
     */
    @SuppressWarnings("hiding")
    public <T extends Comparable<Song>> void sortByTitle() {
        sort(SortEnum.TITLE);
    }

    /**
     * Sorts by artist name
     * 
     * @param <T> Object
     */
    @SuppressWarnings("hiding")
    public <T extends Comparable<Song>> void sortByArtistName() {
        sort(SortEnum.ARTIST);
    }

    /**
     * Sorts by release year
     * 
     * @param <T> The objects in the list
     */
    @SuppressWarnings("hiding")
    public <T extends Comparable<Song>> void sortByReleaseYear() {
        sort(SortEnum.YEAR);
    }

    /**
     * Sorts by genre
     * 
     * @param <T> object
     */
    @SuppressWarnings("hiding")
    public <T extends Comparable<Song>> void sortByGenre() {
        sort(SortEnum.GENRE);
    }

    /**
     * Sort
     * @param sortBy
     */
    private void sort(SortEnum sortBy) {
        if (size > 1) { // Lists size 0 or 1 do not need to be sorted.
            Node<T> lastSorted = head;
            Node<T> unsorted = head.getNextNode();
            lastSorted.setNextNode(null);
            while (unsorted != null) { // inserts everything in unsorted into
                                       // sorted in correct position.
                Node<T> nextToInsert = unsorted;
                unsorted = unsorted.getNextNode();
                nextToInsert.setNextNode(null);
                insertInOrder(sortBy, nextToInsert);
            }
        }
    }

    /**
     * sort in order
     */
    private void insertInOrder(SortEnum sortBy, Node<T> nextToInsert) {
        Node<T> currentNode = head;
        Node<T> nodeBefore = null;
        Song currentNodeData = (Song) currentNode.getData();
        Song nextToInsertData = (Song) nextToInsert.getData();

        int result = updateResult(sortBy, nextToInsertData, currentNodeData);

        while (currentNode != null && result > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
            if (currentNode != null) {
                currentNodeData = (Song) currentNode.getData();
            }
            result = updateResult(sortBy, nextToInsertData, currentNodeData);
        }

        if (nodeBefore != null) {
            nodeBefore.setNextNode(nextToInsert);
            nextToInsert.setNextNode(currentNode);
        }
        else {
            nextToInsert.setNextNode(head);
            head = nextToInsert;
        }
    }

    /**
     * Comparing based on what it's sorted by
     * 
     * @param sortBy
     * @param insertSong
     * @param currentSong
     * @return comparison result
     */
    private int updateResult(SortEnum sortBy, Song insertSong,
            Song currentSong) {
        int result;
        if (sortBy == SortEnum.TITLE) {
            result = insertSong.compareTitleTo(currentSong);
        }
        else if (sortBy == SortEnum.ARTIST) {
            result = insertSong.compareArtistTo(currentSong);
        }
        else if (sortBy == SortEnum.YEAR) {
            result = insertSong.compareReleaseYearTo(currentSong);
        }
        else {
            result = insertSong.compareGenreTo(currentSong);
        }
        return result;
    }

    /**
     * Iterator to iterate
     * 
     * @return Iterator<T>
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * To array
     * 
     * @return Object[] array
     */
    public Object[] toArray() {
        Iterator<T> iterator = iterator();
        Object[] tempArray = new Object[size];
        int currentIndex = 0;
        while (iterator.hasNext()) {
            tempArray[currentIndex] = iterator.next();
            currentIndex++;
        }
        return tempArray;
    }

    /**
     * Returns string like {1, 2, 3}
     * 
     * @return 
     */
    @Override
    public String toString() {
        Iterator<T> iterator = iterator();
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (iterator.hasNext()) {
            builder.append(iterator.next());
            if (iterator.hasNext()) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * Is this list equal to another?
     * 
     * @param other
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        else if (this == other) {
            return true;
        }
        else if (this.getClass() == other.getClass()) {
            if (size != ((LinkedList<T>) other).size()) {
                return false;
            }
            Iterator<T> thisIterator = iterator();
            Iterator<T> otherIterator = ((LinkedList<T>) other).iterator();
            while (thisIterator.hasNext()) {
                T thisCurrent = thisIterator.next();
                T otherCurrent = otherIterator.next();
                if (!thisCurrent.equals(otherCurrent)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Node class
     * 
     * Group 69
     * @author Zach Monheim <zach80>
     * @version 11/12/2018
     * @author Harrison Chun <hchun13>
     * @author Ruchi Maniar <mruchi1>
     */
    @SuppressWarnings("hiding")
    private class Node<T> {
        /**
         * Field contains the data of the Node and the node's reference to
         * another node.
         */
        private T data;
        private Node<T> nextNode;

        /**
         * Creates a Node object. The Node object will contain data and have a
         * reference to another node. The reference will be null.
         * 
         * @param data The data inside the node.
         */
        public Node(T data) {
            this.data = data;
            setNextNode(null);
        }

        /**
         * gets next node
         * 
         * @return nextNode
         */
        public Node<T> getNextNode() {
            return nextNode;
        }

        /**
         * sets next node
         * 
         * @param nextNode
         */
        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        /**
         * gets data
         * 
         * @return data
         */
        public T getData() {
            return data;
        }
    }

    /**
     * Group 69
     * 
     * Iterator class
     * 
     * @author Zach Monheim <zach80>
     * @version 11/12/2018
     * @author Harrison Chun <hchun13>
     * @author Ruchi Maniar <mruchi1>
     * 
     */
    private class LinkedListIterator implements Iterator<T> {
        /**
         * Field contains the iterator's cursor.
         */
        private int index;

        /**
         * LinkedListIterator
         */
        private LinkedListIterator() {
            index = -1;
        }

        /**
         * hasNext
         * 
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return (index + 1 < size);
        }

        /**
         * Next Object
         * 
         * @throws NoSuchElementException
         * @return T object
         */
        @Override
        public T next() {
            if (hasNext()) {
                index++;
                return get(index);
            }
            else {
                throw new NoSuchElementException("Illegal call next();"
                        + "iterator is after end of list.");
            }
        }
    }
}