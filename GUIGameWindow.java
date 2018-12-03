/**
 * 
 */
package prj5;

import java.awt.Color;
import java.io.FileNotFoundException;

import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * Group 69 GameWindow GUI
 * 
 * @author Zach Monheim <zach80>
 * @version 11/12/2018
 * @author Harrison Chun <hchun13>
 * @author Ruchi Maniar <mruchi1>
 */
public class GUIGameWindow {

    private Window window;
    public static final int BAR_HEIGHT = 10;
    private String theSongs;
    private String theSurvey;
    private FileReader reader;
    private LinkedList<Person> p;
    private LinkedList<Song> s;
    private RepresentationEnum rep;
    private String lastClicked;
    private int start;
    private int end;
    private String legendClicked;
    private Button next;
    private Button prev;
    private int page;

    
    /**
     * GameWindow
     * @throws FileNotFoundException 
     * 
     */
    public GUIGameWindow() throws FileNotFoundException {
        window = new Window();
        window.setTitle("Project 5: Music Survey");
        
        theSongs = "SongList2018S.csv";
        theSurvey = "MusicSurveyData2018S.csv";
        reader = new FileReader(theSurvey, theSongs);
        
        p = reader.readPersonFile();
        s = reader.readSongFile();
        rep = RepresentationEnum.Hobby;
        lastClicked = "";
        start = 0;
        end = 9;
        legendClicked = "hobby";
        page = 1;
        
        // create and add buttons
        prev = new Button("<- Prev");
        prev.onClick(this, "clickedPrev");
        window.addButton(prev, WindowSide.NORTH);
        prev.disable();

        Button artist = new Button("Sort by Artist Name");
        artist.onClick(this, "clickedArtist");
        window.addButton(artist, WindowSide.NORTH);

        Button title = new Button("Sort by Song Title");
        title.onClick(this, "clickedTitle");
        window.addButton(title, WindowSide.NORTH);

        Button year = new Button("Sort by Release Year");
        year.onClick(this, "clickedYear");
        window.addButton(year, WindowSide.NORTH);

        Button genre = new Button("Sort by Genre");
        genre.onClick(this, "clickedGenre");
        window.addButton(genre, WindowSide.NORTH);

        next = new Button("Next ->");
        next.onClick(this, "clickedNext");
        window.addButton(next, WindowSide.NORTH);

        Button hobby = new Button("Represent Hobby");
        hobby.onClick(this, "clickedHobby");
        window.addButton(hobby, WindowSide.SOUTH);

        Button major = new Button("Represent Major");
        major.onClick(this, "clickedMajor");
        window.addButton(major, WindowSide.SOUTH);

        Button region = new Button("Represent Region");
        region.onClick(this, "clickedRegion");
        window.addButton(region, WindowSide.SOUTH);

        Button quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.SOUTH);
        
        createLegend("hobby");
        
    }
    
    /**
     * Makes legend
     */
    public void createLegend(String sort) {
        int x = window.getWidth();
        int y = window.getHeight();
        
        
        String name1 = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
        String title = "";
        
        if (sort.equals("hobby")) {
            name1 = "Read";
            name2 = "Art";
            name3 = "Sports";
            name4 = "Music";
            title = "Hobby Legend";
        }
        else if (sort.equals("major")) {
            name1 = "Comp Sci";
            name2 = "Other Eng";
            name3 = "Math/CMDA";
            name4 = "Other";
            title = "Major Legend";
        }
        else {
            name1 = "Northeast US";
            name2 = "Southeast US";
            name3 = "The rest of US";
            name4 = "Outside the US";
            title = "Region Legend";
        }
        
        TextShape legendTitle = new TextShape(x - 110, 110, title);
        window.addShape(legendTitle);
        TextShape legendRead = new TextShape(x - 110, 130, name1, Color.MAGENTA);
        window.addShape(legendRead);
        TextShape legendArt = new TextShape(x - 110, 150, name2, Color.BLUE);
        window.addShape(legendArt);
        TextShape legendSports = new TextShape(x - 110, 170, name3, Color.ORANGE);
        window.addShape(legendSports);
        TextShape legendMusic = new TextShape(x - 110, 190, name4, Color.GREEN);
        window.addShape(legendMusic);
        legendTitle.setBackgroundColor(Color.WHITE);
        legendRead.setBackgroundColor(Color.WHITE);
        legendArt.setBackgroundColor(Color.WHITE);
        legendSports.setBackgroundColor(Color.WHITE);
        legendMusic.setBackgroundColor(Color.WHITE);

        Shape legendBar = new Shape(x - 60, 240, 4, 50, Color.BLACK);
        window.addShape(legendBar);
        TextShape legendSongTitle = new TextShape(x - 97, 220, "Song Title", Color.BLACK);
        legendSongTitle.setBackgroundColor(Color.WHITE);
        window.addShape(legendSongTitle);
        TextShape legendHeard = new TextShape(x - 108, 255, "Heard", Color.BLACK);
        legendHeard.setBackgroundColor(Color.WHITE);
        window.addShape(legendHeard);
        TextShape legendLikes = new TextShape(x - 54, 255, "Likes", Color.BLACK);
        legendLikes.setBackgroundColor(Color.WHITE);
        window.addShape(legendLikes);

        Shape legend2 = new Shape(x - 118, 102, (120) - 4, (y / 2) - 4, Color.WHITE);
        window.addShape(legend2);
        Shape legend = new Shape(x - 120, 100, 120, y / 2, Color.BLACK);
        window.addShape(legend);
    }

    /**
     * create glyphs
     */
    public void createGlyph(int location, String songTitle, String songArtist, 
            double heardPink, double heardBlue, double heardOrange, double heardGreen, 
            double likesPink, double likesBlue, double likesOrange, double likesGreen) {
        int x = window.getWidth();
        int y = window.getHeight();
        int s = (x / 6);
        int q = 0;

        if (location % 9 == 0) {
            s = (x / 6);
        }
        else if (location % 9 == 1) {
            s = (3 * s) - 100;
        }
        else if (location % 9 == 2) {
            s = (4 * s);
        }
        else if (location % 9 == 3) {
            q = 80;
        }
        else if (location % 9 == 4) {
            q = 80;
            s = (3 * s) - 100;
        }
        else if (location % 9  == 5) {
            q = 80;
            s = (4 * s);
        }
        else if (location % 9 == 6) {
            q = 160;
        }
        else if (location % 9 == 7) {
            q = 160;
            s = (3 * s) - 100;
        }
        else {
            q = 160;
            s = (4 * s);
        }

        // sets up bars for glyphs
        Shape bar = new Shape(s, (y / 6) + q, 4, 40, Color.BLACK);
        window.addShape(bar);
        
        // make left shapes (heard) x position is changing
        int heardPink1 = (int) ((1 - heardPink) * 50);
        int heardBlue1 = (int) ((1 - heardBlue) * 50);
        int heardOrange1 = (int) ((1 - heardOrange) * 50);
        int heardGreen1 = (int) ((1 - heardGreen) * 50);
        Shape leftPink = new Shape((s - 50) + heardPink1, (y / 6) + q, 50 - heardPink1, BAR_HEIGHT, Color.MAGENTA);
        Shape leftBlue = new Shape((s - 50) + heardBlue1, (y / 6) + BAR_HEIGHT + q, 50 - heardBlue1, BAR_HEIGHT, Color.BLUE);
        Shape leftOrange = new Shape((s - 50) + heardOrange1, (y / 6) + (2 * BAR_HEIGHT) + q, 50 - heardOrange1, BAR_HEIGHT, Color.ORANGE);
        Shape leftGreen = new Shape((s - 50) + heardGreen1, (y / 6) + (3 * BAR_HEIGHT) + q, 50 - heardGreen1, BAR_HEIGHT, Color.GREEN);
        
        //makes right shapes (likes) width is changing
        int likesPink1 = (int) (likesPink * 50);
        int likesBlue1 = (int) (likesBlue * 50);
        int likesOrange1 = (int) (likesOrange * 50);
        int likesGreen1 = (int) (likesGreen * 50);
        Shape rightPink = new Shape(s + 4, (y / 6) + q, likesPink1, BAR_HEIGHT, Color.MAGENTA);
        Shape rightBlue = new Shape(s + 4, (y / 6) + BAR_HEIGHT + q, likesBlue1, BAR_HEIGHT, Color.BLUE);
        Shape rightOrange = new Shape(s + 4, (y / 6) + (2 * BAR_HEIGHT) + q, likesOrange1, BAR_HEIGHT, Color.ORANGE);
        Shape rightGreen = new Shape(s + 4, (y / 6) + (3 * BAR_HEIGHT) + q, likesGreen1, BAR_HEIGHT, Color.GREEN);

        // add shapes to window
        window.addShape(leftPink);
        window.addShape(leftBlue);
        window.addShape(leftOrange);
        window.addShape(leftGreen);
        window.addShape(rightPink);
        window.addShape(rightBlue);
        window.addShape(rightOrange);
        window.addShape(rightGreen);

        // make text
        TextShape text1 = new TextShape(0, 0, songTitle);
        TextShape text2 = new TextShape(0, 0, songArtist);
        int w = text1.getWidth();
        int v = text2.getWidth();
        text1.moveTo(s - (w / 2) + 2, (y / 6) - 37 + q);
        text2.moveTo(s - (v / 2) + 2, (y / 6) - 20 + q);
        text1.setBackgroundColor(Color.WHITE);
        text2.setBackgroundColor(Color.WHITE);

        window.addShape(text1);
        window.addShape(text2);
    }
    
    /**
     * Sorts the list of songs a certain way
     * @param sort the sort
     */
    public void sortIt(String sort) {
        LinkedList<MusicSurvey> sorted = new LinkedList<>();
        
        if (sort.equals("Artist")) {
            s.sortByArtistName();
        }
        else if (sort.equals("Genre")) {
            s.sortByGenre();
        }
        else if (sort.equals("Title")) {
            s.sortByTitle();
        }
        else if (sort.equals("Year")) {
            s.sortByReleaseYear();
        }
        
        for (int i = 0; i < s.size(); i++) {
            Song anotherSong = s.get(i);
            MusicSurvey sub1 = new MusicSurvey(anotherSong, p, s, rep);
            sorted.add(sub1);
        }
        
        for (int i = start; i < end; i++) {
            createGlyph(i, s.get(i).getSongTitle(), s.get(i).getArtistName(), 
                    sorted.get(i).getHeard().get(0), 
                    sorted.get(i).getHeard().get(1), 
                    sorted.get(i).getHeard().get(2), 
                    sorted.get(i).getHeard().get(3),
                    sorted.get(i).getLiked().get(0), 
                    sorted.get(i).getLiked().get(1), 
                    sorted.get(i).getLiked().get(2), 
                    sorted.get(i).getLiked().get(3));
        }
    }

    /**
     * clickedPrev
     * 
     * @param button Button
     */
    public void clickedPrev(Button button) {
        window.removeAllShapes();
        next.enable();
        
        int b = s.size() / 9;
        
        if (page <= 1)
        {
            start = 0;
            end = 9;
            prev.disable();
            page--;
        }
        else if (page >= b) {
            end = start - 1;
            start = end - 9;
            page--;
        }
        else {
            start -= 9;
            end -= 9;
            page--;
        }
        
        sortIt(lastClicked);
        
        createLegend(legendClicked);
    }

    /**
     * clickedNext
     * 
     * @param button Button
     */
    public void clickedNext(Button button) {
        window.removeAllShapes();
        prev.enable();
        
        int a = (s.size() % 9);
        int b = s.size() / 9;
        
        
        if (page >= b) {
            next.disable();
            if (a == 0)
            {
                end = s.size() - 1;
                start = end - 9;
            }
            else
            {
                end = (s.size() - 1);
                start = (s.size() - 1) - a;
                page++;
            }
        }
        else {
            start += 9;
            end += 9;
            page++;
        }
        
        sortIt(lastClicked);
        
        createLegend(legendClicked);
    }

    /**
     * clickedQuit
     * 
     * @param button Button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

    /**
     * clickedArtist
     * 
     * @param button Button
     */
    public void clickedArtist(Button button) {
        window.removeAllShapes();
        
        lastClicked = "clickedArtist";
        
        sortIt("Artist");
        
        createLegend(legendClicked);
    }

    /**
     * clickedTitle
     * 
     * @param button Button
     */
    public void clickedTitle(Button button) {
        window.removeAllShapes();
        
        lastClicked = "clickedTitle";
        
        sortIt("Title");
        
        createLegend(legendClicked);
    }

    /**
     * clickedYear
     * 
     * @param button Button
     */
    public void clickedYear(Button button) {
        window.removeAllShapes();
        
        lastClicked = "clickedYear";
        
        sortIt("Year");

        createLegend(legendClicked);
    }

    /**
     * clickedGenre
     * 
     * @param button Button
     */
    public void clickedGenre(Button button) {
        window.removeAllShapes();

        lastClicked = "clickedGenre";
        
        sortIt("Genre");
        
        createLegend(legendClicked);

    }

    /**
     * clickedHobby
     * 
     * @param button Button
     */
    public void clickedHobby(Button button) {
        window.removeAllShapes();
        
        rep = RepresentationEnum.Hobby;
        
        if (lastClicked.equals("clickedTitle")) {
            sortIt("Title");
        }
        else if (lastClicked.equals("clickedArtist")) {
            sortIt("Artist");
        }
        else if (lastClicked.equals("clickedGenre")) {
            sortIt("Genre");
        }
        else if (lastClicked.equals("clickedYear")) {
            sortIt("Year");
        }
        legendClicked = "hobby";
        createLegend("hobby");

    }

    /**
     * clickedMajor
     * 
     * @param button Button
     */
    public void clickedMajor(Button button) {
        window.removeAllShapes();
        
        rep = RepresentationEnum.Major;
        
        if (lastClicked.equals("clickedTitle")) {
            sortIt("Title");
        }
        else if (lastClicked.equals("clickedArtist")) {
            sortIt("Artist");
        }
        else if (lastClicked.equals("clickedGenre")) {
            sortIt("Genre");
        }
        else if (lastClicked.equals("clickedYear")) {
            sortIt("Year");
        }
        legendClicked = "major";
        createLegend("major");

    }

    /**
     * clickedRegion
     * 
     * @param button Button
     */
    public void clickedRegion(Button button) {
        window.removeAllShapes();
        
        rep = RepresentationEnum.Region;
        
        if (lastClicked.equals("clickedTitle")) {
            sortIt("Title");
        }
        else if (lastClicked.equals("clickedArtist")) {
            sortIt("Artist");
        }
        else if (lastClicked.equals("clickedGenre")) {
            sortIt("Genre");
        }
        else if (lastClicked.equals("clickedYear")) {
            sortIt("Year");
        }
        legendClicked = "region";
        createLegend("region");
    }

}

