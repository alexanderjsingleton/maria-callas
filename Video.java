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
        // Add your action code here.
    }    
}
