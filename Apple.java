import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Apple() {
        setImage("images/apple2.png");  
    }
    
    int speed = 1;
    
    public void act()
    {
        // Apple falls downwards
        setLocation(getX(), getY()+speed);
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) {
            world.removeObject(this);
        }// Add your action code here.
    }
    
    public void setSpeed(int spd) {
        speed = spd;
    }
}
