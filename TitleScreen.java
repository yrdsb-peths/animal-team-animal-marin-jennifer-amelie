import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        GreenfootImage bg = new GreenfootImage("images/background.png");
        getBackground().drawImage(bg, 0, 0);

        addObject(titleLabel, 250, 125);
        prepare();
    }

    /**
     * The main world act loop
     */
    public void act(){
        //start the game if user presses the space bar
        if(Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,466,103);
        
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,456,305);
        
        Label label2 = new Label("Use \u21D0 and \u21D2 to Move", 40);
        addObject(label2,51,245);
        
        label2.setLocation(250,291);
        label.setLocation(250,218);
        elephant.setLocation(525,213);
    }
}
