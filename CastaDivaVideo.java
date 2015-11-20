 import greenfoot.*;

/**
 * Write a description of class CastaDivaVideo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CastaDivaVideo extends Actor
{
    // Class instance field
    private int timesViewed = 0 ;
    
    /**
     * No argument Constructor for CastaDivaVideo class 
     */
    public CastaDivaVideo()
    {
        timesViewed = 0;
    }
    
    /**
     * Act - do whatever the B wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMousedOver();
        checkMouseClickedOn();
    } 

    private void checkMousedOver()
    {
        if ( Greenfoot.mouseMoved(this) )
        {
            getWorld().showText(" Norma " + " Casta Diva " + "2 GreenfootBucks",300,30);
        }
    }

    private void checkMouseClickedOn()
    {
        if ( Greenfoot.mousePressed(this))
        {
            int greenfootBucksLeft = ((MariaCallasOperaAriasWorld)(getWorld())).getGreenfootBucks();
            if ( greenfootBucksLeft < 2 )
            {
                getWorld().showText(" Not enough greenFootBucks",300,30);  
                return;                 // not able to continue in this method because not enough GreenfootBucks
            }
            else if ( timesViewed >= 4 )
            {
                getWorld().showText(" No more views left",300,30);
                return;                // not able to continue in this method because reached the limit of number of views
            }
            else
            {
                try 
                {
                    String URL = "https://www.youtube.com/watch?v=7rjGwS20V94";                 //  URL of the YouTube video
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));             //  Java code to open the URL in a web browser window
                }
                catch (Exception e)                                // Java run time will throw an error if web page not opened
                {
                    getWorld().showText("Could not open web page",50,30);                      
                    return;                                                                 // not able to continue because the video did not open
                }
                getWorld().showText("Video is Playing",300,30);
                ((MariaCallasOperaAriasWorld)(getWorld())).removeGreenfootBucks(2);        // pay for watching the viewo   
                timesViewed = timesViewed + 1;                                             // increment the number of times viewed
            }
        }
    }
}

