import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Yueheng Fu 
 * @version December 2023
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Starving Kangaroo", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }

    /** 
     * The main world act loop
     */
    public void act()
    {
        // starts the game if the user presses space
        if(Greenfoot.isKeyDown("space"))
        {
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
        Label label = new Label("Press <space> to Start", 30);
        addObject(label,248,252);
        label.setLocation(296,262);

        Label label2 = new Label("Use \u2190 and \u2192 to Move, and k to boost ( has cooldown )", 25);
        addObject(label2,296,197);
        label2.setLocation(296,300);
    }
}
