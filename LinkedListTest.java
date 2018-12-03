/**
 * 
 */
package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Group 69
 * LinkedListTest
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 *
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> emptyList;
    private LinkedList<String> list1;
    private LinkedList<String> list2;
    private LinkedList<String> list3;
    private LinkedList<String> list4;
    private Object list5;

    /**
     * Set up
     */
    public void setUp() {
        emptyList = new LinkedList<String>();

        list1 = new LinkedList<String>();
        list1.add("All");

        list2 = new LinkedList<String>();
        list2.add("Front");
        list2.add("Back");

        list3 = new LinkedList<String>();
        list3.add("Front");
        list3.add("Back");

        list4 = null;

        list5 = new Object();
    }

    /**
     * Test method to ensure add works as intended.
     */
    public void testAdd() {
        assertEquals(0, emptyList.size());
        emptyList.add("Front");
        assertEquals(1, emptyList.size());
        emptyList.add("Back");
        assertEquals(2, emptyList.size());
        assertEquals("Front", emptyList.get(0));
        assertEquals("Back", emptyList.get(1));
    }

    /**
     * Test method to ensure size works as intended.
     */
    public void testSize() {
        assertEquals(0, emptyList.size());
        assertEquals(1, list1.size());
        assertEquals(2, list2.size());
        assertEquals(2, list3.size());
        emptyList.add("All");
        assertEquals(1, emptyList.size());
        emptyList.get(0);
        assertEquals(1, emptyList.size());
        emptyList.indexOf("All");
        emptyList.size();
    }

    /**
     * Test method to ensure get works as intended.
     */
    public void testGet() {
        assertEquals("Front", list3.get(0));
        assertEquals("Back", list3.get(1));
        list3.add("NewBack");
        assertEquals("NewBack", list3.get(2));

        Exception thrown = null;
        try {
            list3.get(3);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;
        try {
            list3.get(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        list3.add("NewNewBack");
        assertEquals("NewNewBack", list3.get(3));
        list3.size();
        assertEquals("NewNewBack", list3.get(3));
        list3.indexOf("All");
        assertEquals("NewNewBack", list3.get(3));
    }

    /**
     * Test method to ensure indexOf works as intended.
     */
    public void testIndexOf() {
        assertEquals(0, list3.indexOf("Front"));
        assertEquals(1, list3.indexOf("Back"));
        list3.add("NewBack");
        assertEquals(2, list3.indexOf("NewBack"));
        list3.size();
        assertEquals(2, list3.indexOf("NewBack"));
        list3.get(0);
        assertEquals(2, list3.indexOf("NewBack"));

        Exception thrown = null;
        try {
            list1.indexOf(null);
        }
        catch (IllegalArgumentException e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * Test method to ensure toArray works as intended.
     */
    public void testToArray() {
        Object[] array = { "Front", "Back" };
        assertTrue(Arrays.equals(array, list2.toArray()));
        assertTrue(Arrays.equals(array, list2.toArray()));

        Object[] array1 = {};
        assertTrue(Arrays.equals(array1, emptyList.toArray()));

        emptyList.add("All");
        Object[] array2 = { "All" };
        assertTrue(Arrays.equals(array2, emptyList.toArray()));
        emptyList.get(0);
        assertTrue(Arrays.equals(array2, emptyList.toArray()));
        emptyList.size();
        assertTrue(Arrays.equals(array2, emptyList.toArray()));
        emptyList.indexOf("All");
        assertTrue(Arrays.equals(array2, emptyList.toArray()));
    }

    /**
     * Test method to ensure toString works as intended.
     */
    public void testToString() {
        String str = "[]";
        assertEquals(str, emptyList.toString());
        emptyList.size();
        assertEquals(str, emptyList.toString());
        emptyList.indexOf("Something");
        assertEquals(str, emptyList.toString());

        str = "[Front]";
        emptyList.add("Front");
        assertEquals(str, emptyList.toString());
        emptyList.get(0);
        assertEquals(str, emptyList.toString());
        str = "[Front, Back]";
        emptyList.add("Back");
        assertEquals(str, emptyList.toString());
    }

    /**
     * Test method to ensure equals works as intended.
     */
    public void testEquals() {
        assertFalse(list2.equals(list4));
        assertEquals(list2, list2);
        assertFalse(list2.equals(list5));
        assertFalse(list2.equals(list1));
        assertEquals(list2, list3);

        LinkedList<String> test1 = new LinkedList<>();
        LinkedList<String> test2 = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            test1.add("" + i);
            test2.add("" + i);
        }
        test1.add("10");
        test2.add("11");
        assertFalse(test1.equals(test2));
    }
    
    /**
     * sort with smaller lists
     */
    public void testSortSmaller()
    {
        LinkedList<Song> songs = 
            new LinkedList<Song>();
        
        Song[] songArr = new Song[4];
        
        Song song1 = new Song("AAATitle", 
            "BBBArtist", "333", "DDDGenre");
        Song song2 = new Song("BBBTitle", 
            "AAAArtist", "444", "BBBGenre");
        Song song3 = new Song("CCCTitle", 
            "DDDArtist", "111", "CCCGenre");
        Song song4 = new Song("DDDTitle", 
            "CCCArtist", "222", "AAAGenre");
        songs.add(song1);
        songs.sortByArtistName();
        songArr[0] = song1;
        assertEquals(songArr[0], songs.get(0));
        
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        
        //sorts by artist test
        songArr[0] = song2;
        songArr[1] = song1;
        songArr[2] = song4;
        songArr[3] = song3;
        
        songs.sortByArtistName();
        assertEquals(songArr[0], songs.get(0));
        assertEquals(songArr[1], songs.get(1));
        assertEquals(songArr[2], songs.get(2));
        assertEquals(songArr[3], songs.get(3));
        
        
        //sorts by title test
        songArr[0] = song1;
        songArr[1] = song2;
        songArr[2] = song3;
        songArr[3] = song4;
        
        songs.sortByTitle();
        assertEquals(songArr[0], songs.get(0));
        assertEquals(songArr[1], songs.get(1));
        assertEquals(songArr[2], songs.get(2));
        assertEquals(songArr[3], songs.get(3));
        
        //sorts by year test
        songArr[0] = song3;
        songArr[1] = song4;
        songArr[2] = song1;
        songArr[3] = song2;
        
        songs.sortByReleaseYear();
        assertEquals(songArr[0], songs.get(0));
        assertEquals(songArr[1], songs.get(1));
        assertEquals(songArr[2], songs.get(2));
        assertEquals(songArr[3], songs.get(3));
        
        //sorts by genre test
        songArr[0] = song4;
        songArr[1] = song2;
        songArr[2] = song3;
        songArr[3] = song1;
        
        songs.sortByGenre();
        assertEquals(songArr[0], songs.get(0));
        assertEquals(songArr[1], songs.get(1));
        assertEquals(songArr[2], songs.get(2));
        assertEquals(songArr[3], songs.get(3));
        
    }
    

    /**
     * Tests the iterator methods
     */
    public void testIterator() {
        Iterator<String> iter = list2.iterator();
        assertTrue(iter.hasNext());
        assertEquals("Front", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("Back", iter.next());
        assertFalse(iter.hasNext());

        Exception thrown = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            thrown = e;
        }
        assertTrue(thrown instanceof NoSuchElementException);
    }
    
}
