import greenfoot.*;

/**
 * Write a description of class Video here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Video extends Actor
{
    // Video instance variables (fields)
    private String aria;
    private String opera;
    private String url;
    private int greenfootBucksCost;
    private int maxViewsAllowed;
    private String image;
    private int timesViewed;    
    public Video(String ariaName, String operaName, String urlName, String imageName, int cost, int viewLimit)
    {

        aria = ariaName;
        opera = operaName;
        url = urlName;
        image = imageName;  // image is a String
        setImage(image);       // to get the actual image we need the method setImage()
        greenfootBucksCost = cost;
        maxViewsAllowed = viewLimit;
        timesViewed = 0;
    }

    public void act() 
    {
        checkMousedOver();
        checkMouseClickedOn();
    } 

    private void checkMousedOver()
    {
        if ( Greenfoot.mouseMoved(this) )
        {
           getWorld().showText(opera + " " + aria + " " + greenfootBucksCost + " GreenfootBucks",300,30);
        }
    }

    private void checkMouseClickedOn()
    {
        if ( Greenfoot.mousePressed(this))
        {
            int greenfootBucksLeft = ((MariaCallasOperaAriasWorld)(getWorld())).getGreenfootBucks();
            if ( greenfootBucksLeft < greenfootBucksCost )
            {
                getWorld().showText(" Not enough greenFootBucks",300,30);  
                return;                 // not able to continue in this method because not enough GreenfootBucks
            }
            else if ( timesViewed >= maxViewsAllowed )
            {
                getWorld().showText(" No more views left",300,30);
                return;                // not able to continue in this method because reached the limit of number of views
            }
            else
            {
                try 
                {
                    String URL = url;                 //  URL of the YouTube video
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));             //  Java code to open the URL in a web browser window
                }
                catch (Exception e)                                // Java run time will throw an error if web page not opened
                {
                    getWorld().showText("Could not open web page",50,30);                      
                    return;                                                                 // not able to continue because the video did not open
                }
                getWorld().showText("Video is Playing",300,30);
                ((MariaCallasOperaAriasWorld)(getWorld())).removeGreenfootBucks(greenfootBucksCost);        // pay for watching the viewo   
                timesViewed = timesViewed + 1;                                             // increment the number of times viewed
            }
        }
    }
}
