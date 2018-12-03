/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Group 69
 * PersonTest
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 */
public class PersonTest extends TestCase {
    
    private Person person1;
    private Person person2;
    private Person person3;
    private LinkedList<String> responses;
    
    /**
     * set up
     */
    public void setUp() {
        responses = new LinkedList<String>();
        person1 = new Person(1, RepresentationEnum.ComputerScience, 
            RepresentationEnum.NorthEast, RepresentationEnum.Art, 
            responses);
        person2 = new Person(1, RepresentationEnum.ComputerScience, 
            RepresentationEnum.NorthEast, RepresentationEnum.Art, 
            responses);
        person3 = new Person(3, RepresentationEnum.ComputerScience, 
            RepresentationEnum.SouthEast, RepresentationEnum.Music, 
            responses);
    }
    
    /**
     * test getPerson()
     */
    public void testGetPerson() {
        assertEquals(1, person1.getPerson());
        assertEquals(3, person3.getPerson());
        
    }
    
    /**
     * test getMajor()
     */
    public void testGetMajor() {
        assertEquals(RepresentationEnum.ComputerScience, person1.getMajor());
        assertEquals(RepresentationEnum.ComputerScience, person3.getMajor());
        
    }
    
    /**
     * test getRegion()
     */
    public void testGetRegion() {
        assertEquals(RepresentationEnum.NorthEast, person1.getRegion());
        assertEquals(RepresentationEnum.SouthEast, person3.getRegion());
        
    }
    
    /**
     * test getHobby()
     */
    public void testGetHobby() {
        assertEquals(RepresentationEnum.Art, person1.getHobby());
        assertEquals(RepresentationEnum.Music, person3.getHobby());
        
    }
    
    /**
     * test getResponse()
     */
    public void testGetResponse() {
        assertEquals(responses, person1.getResponse());
        assertEquals(responses, person3.getResponse());
        
    }
    
    /**
     * test equals()
     */
    public void testEquals() {
        Person nullPers = null;
        
        assertTrue(person1.equals(person1));
        assertTrue(person1.equals(person2));
        assertFalse(person1.equals(person3));
        assertFalse(person1.equals("str"));
        assertFalse(person1.equals(nullPers));
        
        Person person4 = new Person(0, null, null, null, null);
        Person person5 = new Person(1, null, null, null, null);
        Person person6 = new Person(0, null, null, null, null);
        Person person7 = new Person(0, RepresentationEnum.Art, 
            null, null, null);
        Person person8 = new Person(0, null, 
            RepresentationEnum.ComputerScience, null,
                null);
        Person person9 = new Person(0, null, null, 
            RepresentationEnum.NorthEast, null);

        assertFalse(person4.equals(person5));
        assertTrue(person4.equals(person6));
        assertFalse(person4.equals(person7));
        assertFalse(person4.equals(person8));
        assertFalse(person4.equals(person9));
    }
    
}
