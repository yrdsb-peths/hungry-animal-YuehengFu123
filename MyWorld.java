import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world
 * 
 * @author Yueheng
 * @version Novemember 2023
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Kangaroo kangaroo = new Kangaroo();
        Flower flower = new Flower();
        addObject(kangaroo, 300, 200);
        addObject(flower, 300, 0);
        
    }
    
    public void createFlower(){
        Flower flower = new Flower();
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(flower, x, y);
        
    }
}
