import greenfoot.*;

/**
 * Write a description of class MariaCallasOperaAriasWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MariaCallasOperaAriasWorld extends World
{
    // Class instance fields=> constant class variable "static"
    private static final int MAX_BUCKS = 10;
    private int currentNumberBucks;
    // Array consisting of Greenfootbuck
    GreenfootBuck bucksArray [];
    private String[] ariaNames =
        { "Habanera", "Vissi d'arte", "Casta diva", "O Mio Babbino Caro", "Un bel di" };

    private String[] operaNames =
        { "Carmen", "Tosca", "Norma", "Gianni Schicchi", "Madama Butterfly" };

    private String[] webURLs = { "https://www.youtube.com/watch?v=OYfMRZTDLZQ",
            "https://www.youtube.com/watch?v=pAqZ6TgW8AA",
            "https://www.youtube.com/watch?v=7rjGwS20V94", 
            "https://www.youtube.com/watch?v=pAxfaO606Vk", 
            "https://www.youtube.com/watch?v=sLcbfF9ypmM"}; 
    private String[] imageName ={ "callas2.jpg","callas3.jpg","callas1.jpg","callas4.jpg","callas5.jpg"};
    private int[] greenfootBucksCost = { 3,4,2,4,3};
    private int[] maxViews = { 3,5, 3, 4, 2 };
    /**
     * Constructor for objects of class MariaCallasOperaAriasWorld.
     * 
     */
    public MariaCallasOperaAriasWorld()
    {    
        super(600, 833, 1); // size of the image found on the internet
        prepareGreenfootBucks();
        prepareTicketBooth();
        prepareVideos();
    }

    private void prepareVideos()
    {
        for(int i = 0; i < ariaNames.length; i++) 
        {
            Video aVideo = new Video(ariaNames[i], operaNames[i], webURLs[i],imageName[i],greenfootBucksCost[i],maxViews[i]);
            addObject(aVideo, 52, i * 130 + 54);
        }
    }

    private void prepareTicketBooth()
    {
        addObject(new TicketBooth(), 524,747); 
    }

    private void prepareGreenfootBucks()
    { 
        currentNumberBucks = 5;
        bucksArray = new GreenfootBuck[MAX_BUCKS];
        for ( int i = 0; i < currentNumberBucks; i++)
        {
            bucksArray[i] = new GreenfootBuck();
            addObject(bucksArray[i], 550, i * 20 + 10);
        }
    }

    public int getGreenfootBucks()
    {
        return currentNumberBucks;
    }

    public void addGreenfootBucks(int howMany)
    {
        if (  ( howMany + currentNumberBucks ) > MAX_BUCKS )
        {
            howMany = MAX_BUCKS - currentNumberBucks;
        }
        for ( int i = 0; i < howMany; i++)
        {
            bucksArray[currentNumberBucks + i] = new GreenfootBuck();
            addObject(bucksArray[currentNumberBucks + i],550,(currentNumberBucks + i) * 20 + 10);
        }
        currentNumberBucks = currentNumberBucks + howMany;
    } 

    public void removeGreenfootBucks(int howMany)
    {
        if ( ( currentNumberBucks - howMany ) < 0 )
        {
            howMany = currentNumberBucks; 
        }
        for ( int i = 0; i < howMany; i++)
        {
            removeObject(bucksArray[currentNumberBucks -1 - i]);
        }
        currentNumberBucks = currentNumberBucks - howMany;
    }
}
