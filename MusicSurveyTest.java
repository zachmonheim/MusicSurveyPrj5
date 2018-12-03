/**
 * 
 */
package prj5;

import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Group 69
 * 
 * MusicSurveyTest
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 */
public class MusicSurveyTest extends TestCase {
        
    private MusicSurvey musicSurv;
    private Song song;
    
    private MusicSurvey musicSurv2;
    private MusicSurvey musicSurv3;
    
    private LinkedList<Song> songList;
    private LinkedList<Person> students;
    
    /**
     * set up
     */
    public void setUp()
    {
        LinkedList<Song> songL = new LinkedList<Song>();
        for (int i = 1; i <= 5; i++) {
            Song s = new Song("Title " + i, 
                "Artist " + i, "Release Year " + i,  "Genre " + i);
            songL.add(s);
        }
        LinkedList<String> responses = new LinkedList<String>();
        LinkedList<String> responsesYes = new LinkedList<String>();
        LinkedList<String> responsesNo = new LinkedList<String>();
        responses.add("Yes");
        responses.add("No");
        responses.add("Yes");
        responses.add("No");
        responses.add("Yes");
        responses.add("No");
        responses.add("Yes");
        responses.add("No");
        
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        responsesYes.add("Yes");
        
        responsesNo.add("No");
        responsesNo.add("No");
        responsesNo.add("No");
        responsesNo.add("No");
        responsesNo.add("No");
        responsesNo.add("No");
        responsesNo.add("No");
        responsesNo.add("No");
        
        song = new Song("Hotline Bling", "Drake",
            "2015", "R&B");
        Song songB = new Song("All of Me", "John Legend",
            "2013", "R&B");
        Song songC = new Song("Hello", "Adele",
            "2014", "Soul");
        Song songD = new Song("Wonderwall", "Oasis",
            "1995", "Pop");
        songList = new LinkedList<Song>();
        songList.add(song);
        songList.add(songB);
        songList.add(songC);
        songList.add(songD);
        
        
        Person person = new Person(0, RepresentationEnum.ComputerScience,
            RepresentationEnum.NorthEast, RepresentationEnum.Art,
            responsesYes);
        Person person2 = new Person(1, RepresentationEnum.MathCMDA,
            RepresentationEnum.OutsideUS, RepresentationEnum.Music,
            responsesNo);
        Person person3 = new Person(2, RepresentationEnum.OtherEngineering,
            RepresentationEnum.OtherUS, RepresentationEnum.Read,
            responsesYes);
        Person person4 = new Person(3, RepresentationEnum.Other,
            RepresentationEnum.SouthEast, RepresentationEnum.Sports,
            responses);
        Person person5 = new Person(4, RepresentationEnum.MathCMDA,
            RepresentationEnum.SouthEast, RepresentationEnum.Sports,
            responsesYes);
        Person person6 = new Person(5, RepresentationEnum.Other,
            RepresentationEnum.NorthEast, RepresentationEnum.Read,
            responsesNo);
        Person person7 = new Person(6, RepresentationEnum.ComputerScience,
            RepresentationEnum.OutsideUS, RepresentationEnum.Music,
            responsesYes);
        Person person8 = new Person(7, RepresentationEnum.OtherEngineering,
            RepresentationEnum.OtherUS, RepresentationEnum.Art,
            responses);
        students = new LinkedList<Person>();
        students.add(person);
        students.add(person2);
        students.add(person3);
        students.add(person4);
        students.add(person5);
        students.add(person6);
        students.add(person7);
        students.add(person8);
        
        musicSurv = new MusicSurvey(song, students, 
            songList, RepresentationEnum.Hobby);
        
        musicSurv2 = new MusicSurvey(song, students, 
            songList, RepresentationEnum.Major);
        
        musicSurv3 = new MusicSurvey(song, students, 
            songList, RepresentationEnum.Region);
    }
    
    /**
     * test isYes
     */
    public void testIsYes()
    {
        LinkedList<String> responses = new LinkedList<String>();
        responses.add("Yes");
        responses.add("No");
        
        Person person = new Person(0, RepresentationEnum.ComputerScience,
            RepresentationEnum.NorthEast, RepresentationEnum.Art,
            responses);
        
        assertTrue(musicSurv.isYes(person, 0));
        
        assertFalse(musicSurv.isYes(person, 1));
        
        assertFalse(musicSurv.isYes(person, 2));
    }
    
    /**
     * test get song
     */
    public void testGetSong()
    {
        assertEquals(song, musicSurv.getSong());
        assertEquals(song, musicSurv2.getSong());
        assertEquals(song, musicSurv3.getSong());
    }
    
    /**
     * test get heard
     */
    public void testGetHeard()
    {
        LinkedList<Double> list = new LinkedList<Double>();
        list.add(1.0);
        list.add(1.0);
        list.add(1.0);
        list.add(0.5);
        
        assertEquals(list, musicSurv.getHeard());
        
        LinkedList<Double> list2 = new LinkedList<Double>();
        list2.add(1.0);
        list2.add(1.0);
        list2.add(0.5);
        list2.add(0.5);
        
        assertEquals(list2, musicSurv2.getHeard());
        
        LinkedList<Double> list3 = new LinkedList<Double>();
        list3.add(0.5);
        list3.add(1.0);
        list3.add(1.0);
        list3.add(0.5);
        
        assertEquals(list3, musicSurv3.getHeard());
    }
    
    /**
     * test get liked
     */
    public void testGetLiked()
    {
        LinkedList<Double> list = new LinkedList<Double>();
        list.add(1.0);
        list.add(0.5);
        list.add(0.5);
        list.add(0.5);
        
        assertEquals(list, musicSurv.getLiked());
        
        LinkedList<Double> list2 = new LinkedList<Double>();
        list2.add(1.0);
        list2.add(0.5);
        list2.add(0.5);
        list2.add(0.0);
        
        assertEquals(list2, musicSurv2.getLiked());
        
        LinkedList<Double> list3 = new LinkedList<Double>();
        list3.add(0.5);
        list3.add(0.5);
        list3.add(0.5);
        list3.add(0.5);
        
        assertEquals(list3, musicSurv3.getLiked());
    }
    
    /**
     * test songIndex exception
     */
    public void testSongIndexException()
    {
        Song notSong = new Song("Hotline Bling", "Drake",
            "2015", "R&B");
        Exception exception = null;
        try {
            new MusicSurvey(notSong, students, 
                songList, RepresentationEnum.Region);
        }
        catch (NoSuchElementException e)
        {
            exception = e;
        }
        assertNotNull(exception);
    }
    
    /**
     * tests calculate
     */
    public void testCalculate()
    {
        LinkedList<Integer> tot = new LinkedList<Integer>();
        tot.add(2);
        tot.add(2);
        tot.add(2);
        tot.add(2);
        tot.add(2);
        tot.add(2);
        tot.add(2);
        tot.add(2);
        assertEquals(tot, musicSurv.getTotals());
    }
}
