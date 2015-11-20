import greenfoot.*;

/**
 * Write a description of class TicketBooth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicketBooth extends Actor
{
    /**
     * Act - do whatever the TicketBooth wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkForInput();
    }  
    public void checkForInput()
    {
        if ( Greenfoot.mousePressed(this))
        {
            String ans = Greenfoot.ask("Enter number of GreenfootBucks needed: ");
            int number = Integer.parseInt(ans); 
            ((MariaCallasOperaAriasWorld)(getWorld())).addGreenfootBucks(number);   
        }
    }
}
