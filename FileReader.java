package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Group 69 File reader class to read through excel data
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 */
public class FileReader {

    private String personFile;
    private String songFile;
    
    /**
     * file reader
     * @param personFile
     * @param songFile
     */
    public FileReader(String personFile, String songFile) {
        this.personFile = personFile;
        this.songFile = songFile;
    }
    
    /**
     * readSongFile
     * @return
     */
    public LinkedList<Song> readSongFile() {
        LinkedList<Song> songList = new LinkedList<Song>();
        Scanner songScanner = null;
        try {
            File songScannerFile = new File(songFile);
            songScanner = new Scanner(songScannerFile);
        }
        catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
        
        songScanner.nextLine();
        while (songScanner.hasNextLine()) {
            String currentLine = songScanner.nextLine();
            String[] songLineArray = currentLine.split(",");
            
            String artistNameLine = songLineArray[0];
            String songTitleLine = songLineArray[1];
            String releaseYearLine = songLineArray[2];
            String genreLine = songLineArray[3];
            Song addSong = new Song(artistNameLine, songTitleLine, 
                    releaseYearLine, genreLine);
            songList.add(addSong);
        }
        songScanner.close();
        
        return songList;
        
    }
    
    public LinkedList<Person> readPersonFile() throws FileNotFoundException {
        LinkedList<Person> personList = new LinkedList<Person>();
        
        
        File file = new File(personFile);
        Scanner personScanner = new Scanner(file);
        
        personScanner.nextLine();
        
        while (personScanner.hasNextLine()) {
            String currentLine = personScanner.nextLine();
            String[] personLineArray = currentLine.split(",");
            if (personLineArray.length >= 6) {
                int personID = Integer.parseInt(personLineArray[0]);
                RepresentationEnum major = getMajor(personLineArray[2]);
                RepresentationEnum region = getRegion(personLineArray[3]);
                RepresentationEnum hobby = getHobby(personLineArray[4]);
                LinkedList<String> personResponses = new LinkedList<String>();
                for (int i = 5; i < personLineArray.length; i++) {
                    personResponses.add(personLineArray[i]);
                }
                if (major != null && region != null && hobby != null) {
                    Person addPerson = new Person(personID, major, 
                            region, hobby, personResponses);
                    personList.add(addPerson);
                }
            }
        }
        personScanner.close();
        
        return personList;
    }
    
    private RepresentationEnum getMajor(String major) {
        switch(major) {
            case "Computer Science" :
                return RepresentationEnum.ComputerScience;
            case "Other Engineering" :
                return RepresentationEnum.OtherEngineering;
            case "Math or CMDA" :
                return RepresentationEnum.MathCMDA;
            case "Other" :
                return RepresentationEnum.Other;
            default :
                return null;
        }
    }
    
    private RepresentationEnum getRegion(String region) {
        switch(region) {
            case "NorthEast" :
                return RepresentationEnum.NorthEast;
            case "SouthEast" :
                return RepresentationEnum.SouthEast;
            case "United States (other than SouthEast or NorthWest)" :
                return RepresentationEnum.OtherUS;
            case "Outside of United States" :
                return RepresentationEnum.OutsideUS;
            default :
                return null;
        }
    }
    
    private RepresentationEnum getHobby(String hobby) {
        switch(hobby) {
            case "reading" :
                return RepresentationEnum.Read;
            case "art" :
                return RepresentationEnum.Art;
            case "sports" :
                return RepresentationEnum.Sports;
            case "music" :
                return RepresentationEnum.Music;
            default :
                return null;
        }
    }
}
