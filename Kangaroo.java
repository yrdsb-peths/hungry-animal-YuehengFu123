import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kangaroo here.
 * 
 * Yueheng Fu
 * November 2023
 */
public class Kangaroo extends Actor
{
    GreenfootSound KangarooSound = new GreenfootSound("KangarooSound.mp3");
    GreenfootImage[] idle = new GreenfootImage[7];
    
    
    
    /**
     * Constructor that is called when a new object is created
     */
    public Kangaroo()
    {
        for(int i = 0; i<idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/Kangaroo_idle/idle" + i + ".png");
            idle[i].scale(100, 100);
        }
        setImage(idle[0]);
    }
    int imageIndex = 0;
    public void animateKangaroo()
    {
        setImage(idle[imageIndex]);
        imageIndex = (imageIndex + 1) % idle.length;
    }
    public void act() 
    {
  
        if(Greenfoot.isKeyDown("left")){
            move(-2);
        }
        else if(Greenfoot.isKeyDown("right")){
            move(2);
        }
        eat();
        animateKangaroo();
    }
    /**
     * Spawns a new flower every time the kangaroo eats one
     */
    
    public void eat()
    {
        if(isTouching(Flower.class))
        {
         removeTouching(Flower.class);
         MyWorld world = (MyWorld) getWorld();
         world.createFlower();
         world.increaseScore();
         KangarooSound.play();
        }
        
    }
}
