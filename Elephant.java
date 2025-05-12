import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, our hero
 * 
 * @author Amelie 
 * @version Apr 2025
 */
public class Elephant extends Actor
{
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
    //direction of elephant
    String facing = "right";
    /**
     * constructor - code gets run first time instance created
     */
    public Elephant(){
        for(int i = 0; i<idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idleRight[i].scale(120, 100);
        }
        for(int i = 0; i<idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle"+i+".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(120, 100);
        }
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    /**
     * animate elephant
     */
    public void animateElephant(){
        if(animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;  
        } else {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        
    }
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left")){            
            move(-5);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right")){
            move(5);
            facing = "right";
        }
        eat();
        animateElephant();
    }
    //remove apples if eaten
    /**
     * Eat and spawn new apple
     */
    public void eat(){
        if(isTouching(Apple.class)){
            removeTouching(Apple.class);
            //get instance of world object is in
            MyWorld world = (MyWorld) getWorld(); 
            world.createApple();
            world.increaseScore();
        }
    }
}
