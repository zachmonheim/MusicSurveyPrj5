/**
 * 
 */
package prj5;

import student.TestCase;


/**
 * Group 69
 * 
 * SongTest
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 */
public class SongTest extends TestCase {
    
    private Song bling;
    private Song bling2;
    private Song creep;

    /**
     * Sets up each method before tests
     */
    public void setUp()
    {
        bling = new Song("Hotline Bling", "Drake",
                "2015", "R&B");
        bling2 = new Song("Hotline Bling", "Drake",
                "2015", "R&B");
        creep = new Song("Creep", "Radiohead", "1992", "Alternative");
    }

    /**
     * Tests getSongTitle() 
     */
    public void testGetSongTitle()
    {
        assertEquals("Hotline Bling", bling.getSongTitle());
    }
    
    /**
     * Tests getArtistName() 
     */
    public void testGetArtistName()
    {
        assertEquals("Drake", bling.getArtistName());
    }
    
    /**
     * Tests getReleaseYear()
     */
    public void testGetReleaseYear()
    {
        assertEquals("2015", bling.getReleaseYear());
    }
    
    /**
     * Tests getGenre() to make sure correct genre is returned 
     */
    public void testGetGenre()
    {
        assertEquals("R&B", bling.getGenre());
    }
    
    /**
     * Tests compareArtistTo
     */
    public void testCompareTitleTo()
    {
        assertEquals(0, bling.compareTitleTo(bling2));
        assertTrue(bling.compareTitleTo(creep) > 0);
        assertTrue(creep.compareTitleTo(bling) < 0);
    }
    
    /**
     * Tests compareArtistTo
     */
    public void testCompareArtistTo()
    {
        assertEquals(0, bling.compareArtistTo(bling2));
        assertTrue(bling.compareArtistTo(creep) < 0);
        assertTrue(creep.compareArtistTo(bling) > 0);
    }
    
    /**
     * Tests compareArtistTo
     */
    public void testCompareReleaseYearTo()
    {
        assertEquals(0, bling.compareReleaseYearTo(bling2));
        assertTrue(bling.compareReleaseYearTo(creep) > 0);
        assertTrue(creep.compareReleaseYearTo(bling) < 0);
    }
    
    /**
     * Tests compareGenreTo
     */
    public void testCompareGenreTo()
    {
        assertEquals(0, bling.compareGenreTo(bling2));
        assertTrue(bling.compareGenreTo(creep) > 0);
        assertTrue(creep.compareGenreTo(bling) < 0);
    }
}
