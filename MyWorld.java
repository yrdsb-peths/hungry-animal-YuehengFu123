import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world
 * 
 * @author Yueheng
 * @version Novemember 2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // create kangaroo and Flower
        Kangaroo kangaroo = new Kangaroo();
        addObject(kangaroo, 300, 350);
        //Creating a score counter label
        scoreLabel = new Label(0, 60);
        addObject(scoreLabel, 30, 30);
        
        createFlower();
        
    }
    /**
     * Increase score
     */
    public void increaseScore()
    {
     score++;
     scoreLabel.setValue(score);
     
     if(score %5 == 0)
     {
         level +=1;
     }
    }
    /**
     * Game over
     */
    public void onGameOver() {
        Label gameOverLabel = new Label("Game Over!", 70);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
    }
    
    public void createFlower(){
        Flower flower = new Flower();
        flower.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(flower, x, y);
        
    }
}
