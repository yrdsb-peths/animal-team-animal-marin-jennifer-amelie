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
    
    /**
     * set the image for the apple icon in the game
     */
    public Apple() {
        setImage("images/apple2.png");  
    }
    
    /**
     * created a class variable for the speed of the apple falling down
     */
    static int speed = 1;
    
    public void act()
    {
        // Apple falls downwards
        setLocation(getX(), getY()+speed);
        
        // Remove apple and draw game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight()) {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    /**
     * set the speed of the apple as the level of the game that the player is on
     */
    public static void setSpeed(int spd) {
        speed = spd;
    }
}
