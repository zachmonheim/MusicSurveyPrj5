/**
 * 
 */
package prj5;


/**
 * Group 69
 * Person
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 */
public class Person {
    private int pers;
    private RepresentationEnum major;
    private RepresentationEnum region;
    private RepresentationEnum hobby;
    private LinkedList<String> response;
    
    /**
     * Person constructor
     * @param pers Person
     * @param major Rep
     * @param region Rep
     * @param hobby Rep
     * @param response List
     */
    public Person(int pers, RepresentationEnum major, 
        RepresentationEnum region, RepresentationEnum hobby,
        LinkedList<String> response) {
        this.pers = pers;
        this.major = major;
        this.region = region;
        this.hobby = hobby;
        this.response = response;
    }
    
    /**
     * returns person
     * 
     * @return int person
     */
    public int getPerson() {
        return pers;
    }
    
    /**
     * returns major
     * 
     * @return major
     */
    public RepresentationEnum getMajor() {
        return major;
    }
    
    /**
     * returns region
     * 
     * @return region
     */
    public RepresentationEnum getRegion() {
        return region;
    }
    
    /**
     * returns hobby
     * 
     * @return hobby
     */
    public RepresentationEnum getHobby() {
        return hobby;
    }
    
    /**
     * returns responses
     * 
     * @return response
     */
    public LinkedList<String> getResponse() {
        return response;
    }
    
    /**
     * checks if equal
     * 
     * @return boolean
     * @param obj compared object
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || obj.getClass() != Person.class) {
            return false;
        }
        return (this.getPerson() == ((Person) obj).getPerson()
                && this.getMajor() == ((Person) obj).getMajor())
                && this.getRegion() == ((Person) obj).getRegion()
                && this.getHobby() == ((Person) obj).getHobby();
    }

}
