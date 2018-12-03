package prj5;


import java.util.NoSuchElementException;

/**
 * Group 69
 * 
 * MusicSurvey
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 */
public class MusicSurvey {
    
    private Song song;
    private RepresentationEnum rep;
    private LinkedList<Person> students;
    private LinkedList<Song> songList;
    private LinkedList<Double> heard;
    private LinkedList<Double> likes;
    private LinkedList<Integer> totals;
    
    /**
     * Runs the intermediate solution
     * @param song the song sorted
     * @param students the list of students
     * @param songList the list of songs
     * @param rep the representation enums
     */
    public MusicSurvey(Song song, 
        LinkedList<Person> students,
            LinkedList<Song> songList, 
            RepresentationEnum rep) {
        this.song = song;
        this.students = students;
        this.songList = songList;
        this.rep = rep;
        calculate();
    }
    
    /**
     * The song to be returned
     * @return the song
     */
    public Song getSong()
    {
        return song;
    }
    
    /**
     * heard
     * @return the heard
     */
    public LinkedList<Double> getHeard()
    {
        return heard;
    }
    
    /**
     * liked
     * @return the liked
     */
    public LinkedList<Double> getLiked()
    {
        return likes;
    }
    
    /**
     * initializes the lists
     */
    public void calculate() {
        totals = totals();
        likes = likesPercent();
        heard = heardPercent();
    }
    
    /**
     * list of all the totals of each combination
     * @return the list
     */
    private LinkedList<Integer> totals() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(totalInFirst("heard"));
        list.add(totalInSecond("heard"));
        list.add(totalInThird("heard"));
        list.add(totalInFourth("heard"));
        list.add(totalInFirst("likes"));
        list.add(totalInSecond("likes"));
        list.add(totalInThird("likes"));
        list.add(totalInFourth("likes"));
        return list;    
    }
    
    /**
     * calculates the total number in the first combination
     * @param response heard, or like
     * @return the total number
     */
    private int totalInFirst(String response) {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        int total = 0;
        if (response.equals("likes")) {
            realIndex = realIndex + 1;
        }
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Read;
                if (person.getHobby() == compareTo) {
                    total++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = 
                    RepresentationEnum.ComputerScience;
                if (person.getMajor() == compareTo) {
                    total++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.NorthEast;
                if (person.getRegion() == compareTo) {
                    total++;
                }
            }
        }
        return total;
    }
    
    /**
     * calculates the total number in the second combination
     * @param response heard, or like
     * @return the total number
     */
    private int totalInSecond(String response) {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        int total = 0;
        if (response.equals("likes")) {
            realIndex = realIndex + 1;
        }
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Art;
                if (person.getHobby() == compareTo) {
                    total++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = 
                    RepresentationEnum.OtherEngineering;
                if (person.getMajor() == compareTo) {
                    total++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.SouthEast;
                if (person.getRegion() == compareTo) {
                    total++;
                }
            }
        }
        return total;
    }
    
    /**
     * calculates the total number in the third combination
     * @param response heard, or like
     * @return the total number
     */
    private int totalInThird(String response) {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        int total = 0;
        if (response.equals("likes")) {
            realIndex = realIndex + 1;
        }
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Sports;
                if (person.getHobby() == compareTo) {
                    total++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = RepresentationEnum.MathCMDA;
                if (person.getMajor() == compareTo) {
                    total++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.OtherUS;
                if (person.getRegion() == compareTo) {
                    total++;
                }
            }
        }
        return total;
    }
    
    /**
     * calculates the total number in the fourth combination
     * @param response heard, or like
     * @return the total number
     */
    private int totalInFourth(String response) {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        int total = 0;
        if (response.equals("likes")) {
            realIndex = realIndex + 1;
        }
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Music;
                if (person.getHobby() == compareTo) {
                    total++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = RepresentationEnum.Other;
                if (person.getMajor() == compareTo) {
                    total++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.OutsideUS;
                if (person.getRegion() == compareTo) {
                    total++;
                }
            }
        }
        return total;
    }
    
    /**
     * decides if the person is Yes
     * @param person Person
     * @param realIndex int
     * @return boolean
     */
    public boolean isYes(Person person, int realIndex) {
        LinkedList<String> responses = person.getResponse();
        return (realIndex < responses.size() 
            && "Yes".equals(responses.get(realIndex)));
    }
    
    /**
     * finds the songs index
     * @return index value
     * @throws NoSuchElementException();
     */
    private int songIndex() {
        int index = 0;
        boolean found = false;
        while (!found && index < songList.size()) {
            if (song.equals(songList.get(index))) {
                found = true;
            }
            else {
                index++;
            }
        }
        if (!found) {
            throw new NoSuchElementException();
        }
        else {
            return index;
        }
    }
    
    /**
     * calculates amount of yes's in the first combination
     * @param realIndex the index in the list
     * @return number of yes's
     */
    private int yesFirstCombination(int realIndex) {
        int yes = 0;
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby
                && person.getHobby() == RepresentationEnum.Read 
                && isYes(person, realIndex)) {
                yes++;
            }
            else if (rep == RepresentationEnum.Major
                && person.getMajor() == RepresentationEnum.ComputerScience 
                && isYes(person, realIndex)) {
                yes++;
            }
            else if (person.getRegion() == RepresentationEnum.NorthEast 
                && isYes(person, realIndex)) {
                yes++;
            }
        }
        return yes;
    }
    
    /**
     * calculates amount of yes's in the second combination
     * @param realIndex in the list
     * @return number of yes's
     */
    private int yesSecondCombination(int realIndex) {
        int yes = 0;
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Art;
                if (person.getHobby() == compareTo && 
                    isYes(person, realIndex)) {
                    yes++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = 
                    RepresentationEnum.OtherEngineering;
                if (person.getMajor() == compareTo && 
                    isYes(person, realIndex)) {
                    yes++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.SouthEast;
                if (person.getRegion() == compareTo
                        && isYes(person, realIndex)) {
                    yes++;
                }
            }
        }
        return yes;
    }
    
    /**
     * calculates amount of yes's in the third combination
     * @param realIndex in the list
     * @return number of yes's
     */
    private int yesThirdCombination(int realIndex) {
        int yes = 0;
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Sports;
                if (person.getHobby() == compareTo && 
                    isYes(person, realIndex)) {
                    yes++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = RepresentationEnum.MathCMDA;
                if (person.getMajor() == compareTo && 
                    isYes(person, realIndex)) {
                    yes++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.OtherUS;
                if (person.getRegion() == compareTo
                        && isYes(person, realIndex)) {
                    yes++;
                }
            }
            
        }
        return yes;
    }
    
    /**
     * calculates amount of yes's in the fourth combination
     * @param realIndex in the list
     * @return number of yes's
     */
    private int yesFourthCombination(int realIndex) {
        int yes = 0;
        for (int i = 0; i < students.size(); i++) {
            Person person = students.get(i);
            if (rep == RepresentationEnum.Hobby) {
                RepresentationEnum compareTo = RepresentationEnum.Music;
                if (person.getHobby() == compareTo && 
                    isYes(person, realIndex)) {
                    yes++;
                }
            }
            else if (rep == RepresentationEnum.Major) {
                RepresentationEnum compareTo = RepresentationEnum.Other;
                if (person.getMajor() == compareTo 
                    && isYes(person, realIndex)) {
                    yes++;
                }
            }
            else {
                RepresentationEnum compareTo = RepresentationEnum.OutsideUS;
                if (person.getRegion() == compareTo
                        && isYes(person, realIndex)) {
                    yes++;
                }
            }
        }
        return yes;
    }
    
    /**
     * number of likes in the first combination
     * @return that number
     */
    private int firstCombinationLikes() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex) + 1;
        return yesFirstCombination(realIndex);
    }
    
    /**
     * number of likes in the second combination
     * @return that number
     */
    private int secondCombinationLikes() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex) + 1;
        return yesSecondCombination(realIndex);
    }
    
    /**
     * number of likes in the third combination
     * @return that number
     */
    private int thirdCombinationLikes() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex) + 1;
        return yesThirdCombination(realIndex);
    }
    
    /**
     * number of likes in the fourth combination
     * @return that number
     */
    private int fourthCombinationLikes() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex) + 1;
        return yesFourthCombination(realIndex);
    }
    
    /**
     * number of heards in the first combination
     * @return
     */
    private int firstCombinationHeard() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        return yesFirstCombination(realIndex);
    }
    
    /**
     * number of heards in the second combination
     * @return
     */
    private int secondCombinationHeard() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        return yesSecondCombination(realIndex);
    }
    
    /**
     * number of heards in the third combination
     * @return
     */
    private int thirdCombinationHeard() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        return yesThirdCombination(realIndex);
    }
    
    /**
     * number of heards in the fourth combination
     * @return
     */
    private int fourthCombinationHeard() {
        int songIndex = songIndex();
        int realIndex = (2 * songIndex);
        return yesFourthCombination(realIndex);
    }
    
    /**
     * list of all the percentage of heard in each combination
     * @return the list
     */
    private LinkedList<Double> heardPercent() {
        LinkedList<Double> list = new LinkedList<>();
        list.add(((double) firstCombinationHeard() / (double) totals.get(0)));
        list.add(((double) secondCombinationHeard() / (double) totals.get(1)));
        list.add(((double) thirdCombinationHeard() / (double) totals.get(2)));
        list.add(((double) fourthCombinationHeard() / (double) totals.get(3)));
        return list; 
    }
    
    /**
     * list of all the percents of likes in each combination
     * @return the list
     */
    private LinkedList<Double> likesPercent() {
        LinkedList<Double> list = new LinkedList<>();
        list.add(((double) firstCombinationLikes() / (double) totals.get(4)));
        list.add(((double) secondCombinationLikes() / (double) totals.get(5)));
        list.add(((double) thirdCombinationLikes() / (double) totals.get(6)));
        list.add(((double) fourthCombinationLikes() / (double) totals.get(7)));
        return list; 
    }
    
    /**
     * returns totals array
     * @return LinkedList<Integer>
     */
    public LinkedList<Integer> getTotals()
    {
        return totals;
    }
}
