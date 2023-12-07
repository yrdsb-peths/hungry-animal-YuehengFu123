import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A cool yellow flower!
 * 
 * @ Yueheng Fu
 * @version 2023 november
 */
public class Flower extends Actor
{
    private int speed = 1;
    /**
     * Act - do whatever the Flower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        MyWorld world = (MyWorld) getWorld();
        if(getY() > world.getHeight()){
            world.onGameOver();
        }
    }  
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
