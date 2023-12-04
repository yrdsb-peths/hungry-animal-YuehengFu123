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
    GreenfootImage idle = new GreenfootImage("images/Kangaroo_idle/idle0.png");
    
    /**
     * Constructor that is called when a new object is created
     */
    public Elephant(){
    {
        for(int i = 0; i<idle.length;i++_)
        {
            idle[i] = new GreenfotImage("images/Kangaroo_idle/idle" + i + ".png");
        }
        setImage(idle[0];
    }
    public void act() 
    {
  
        if(Greenfoot.isKeyDown("left")){
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right")){
            move(1);
        }
        eat();
    }
    /**
     * Spawns a new flower every time the kangaroo eats one
     */
    
    public void eat()
    {
        if(isTouching(Flower.class)){
         removeTouching(Flower.class);
         MyWorld world = (MyWorld) getWorld();
         world.createFlower();
         world.increaseScore();
         KangarooSound.play();
        }
        
    }
}
