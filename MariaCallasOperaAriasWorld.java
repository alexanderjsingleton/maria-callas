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
    /**
     * Constructor for objects of class MariaCallasOperaAriasWorld.
     * 
     */
    public MariaCallasOperaAriasWorld()
    {    
        super(600, 833, 1); // size of the image found on the internet
        prepareGreenfootBucks();
        prepareTicketBooth();
        addVideoToWorld();
    }

    private void addVideoToWorld()
    {
        addObject(new CastaDivaVideo(),60,63);
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
