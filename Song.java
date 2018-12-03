package prj5;


/**
 * Group 69
 * 
 * Song
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 */
public class Song implements Comparable<Song> {

    private String artistName;
    private String songTitle;
    private String releaseYear;
    private String genre;
    
    /**
     * Constructor for this class
     * @param artistName the artists name
     * @param songTitle the songs title
     * @param releaseYear the year it was released
     * @param genre the songs genre
     */
    public Song(String songTitle, String artistName, 
        String releaseYear, String genre) {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    /**
     * gets the artists name
     * @return artists name 
     */
    public String getArtistName() {
        return artistName;
    }
    
    /**
     * gets the songs title
     * @return song title
     */
    public String getSongTitle() {
        return songTitle;
    }
    
    /**
     * gets the release year
     * @return release year
     */
    public String getReleaseYear() {
        return releaseYear;
    }
    
    /**
     * gets the genre
     * @return genre
     */
    public String getGenre() {
        return genre;
    }
    
    /**
     * Comparing artist name
     * @param item to compare to
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareArtistTo(Song item) {
        return this.artistName.compareTo(item.getArtistName());
    }
    
    /**
     * comparing title name
     * @param item to compare to 
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareTitleTo(Song item) {
        return this.songTitle.compareTo(item.getSongTitle());
    }
    
    /**
     * comparing release year
     * @param item to compare to 
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareReleaseYearTo(Song item) {
        return this.releaseYear.compareTo(item.getReleaseYear());
    }
    
    /**
     * comparing genre
     * @param item to compare to
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareGenreTo(Song item) {
        return this.genre.compareTo(item.getGenre());
    }
}
