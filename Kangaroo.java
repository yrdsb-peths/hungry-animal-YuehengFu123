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
