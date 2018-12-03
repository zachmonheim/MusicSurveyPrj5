/**
 * 
 */
package prj5;

/**
 * Group 69
 * 
 * ComparableINterface
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 * 
 * @param <T>
 *
 */
public interface Comparable<T> {
    /**
     * Comparing artist name
     * @param item to compare to
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareArtistTo(T item);
    
    /**
     * comparing title name
     * @param item to compare to 
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareTitleTo(T item);
    
    
    /**
     * comparing genre
     * @param item to compare to
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareGenreTo(T item);
    
    
    /**
     * comparing release year
     * @param item to compare to 
     * @return 1 if larger, 0 if equal, negative 1 if smaller
     */
    public int compareReleaseYearTo(T item);

}
