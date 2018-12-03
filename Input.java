/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;

/**
 * Group 69
 * 
 * Input method (Main)
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 */
public class Input {

    
    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        String surveyFile = "";
        String songFile = "";
        FileReader fileRead;
        if (args.length == 2)
        {
            surveyFile = (args[0]);
            songFile = (args[1]);
            fileRead = new FileReader(args[0], args[1]);
            
        }
        else
        {
            surveyFile = "MusicSurveyData2018S.csv";
            songFile = "SongList2018S";
            fileRead = new FileReader(surveyFile, songFile);
        }
                
        
        
        
        LinkedList<Song> songs = fileRead.readSongFile();
        LinkedList<Person> persons = fileRead.readPersonFile();
        
        //for sorting
        LinkedList<Song> songsGenre = fileRead.readSongFile();
        LinkedList<Song> songsTitle = fileRead.readSongFile();
        
        LinkedList<MusicSurvey> intSub = 
            new LinkedList<MusicSurvey>();
        //MusicSurvey sort by hobby
        for (int i = 0; i < songs.size(); i++)
        {
            Song song = songs.get(i);
            intSub.add(new MusicSurvey(song, persons, songs, 
                RepresentationEnum.Hobby));
            
        }
        
        
        //sort by genre
        songsGenre.sortByGenre();
        //output

        
        
        //sort by song title
        songsTitle.sortByTitle();
        //output

        
        
    }

}
