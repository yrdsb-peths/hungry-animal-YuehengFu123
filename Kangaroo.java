import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kangaroo here.
 * 
 * Yueheng Fu
 * November 2023
 */
public class Kangaroo extends Actor
{
    
    GreenfootSound kangarooSound = new GreenfootSound("KangarooSound.mp3");
    GreenfootSound boostSound = new GreenfootSound("boostSound.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[7];
    GreenfootImage[] idleLeft = new GreenfootImage[7];
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    SimpleTimer boostTimer = new SimpleTimer();
    SimpleTimer boostCooldown = new SimpleTimer();
// Kangaroo's speed
    public int k = 2;
    
    /**
     * Constructor that is called when a new object is created
     */
    public Kangaroo()
    {
        for(int i = 0; i<idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/Kangaroo_idle/idle" + i + ".png");
            idleRight[i].scale(200, 200);
        }
        
        for(int i =0; i<idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/Kangaroo_idle/idle" + i +".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(200, 200);
        }
        animationTimer.mark();
        
        // initial kangaroo image
        setImage(idleRight[0]);
        
    }
    int imageIndex = 0;
    /**
     * Animating the kangaroo
     */
    public void animateKangaroo()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex +1 ) %idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    /**
     * main act method for kangaroo
     */
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.isKeyDown("k"))
        {
          if(boostCooldown.millisElapsed() > 8000){
            k = 8;
            
            world.changeBackground();
            boostSound.play();
            boostTimer.mark();
            boostCooldown.mark();
          }
          
        }
        if(getX() > world.getWidth()){
            setLocation(600, 350);
       
        }
        if(getX() < 0){
            setLocation(0,350);
        }
        if(Greenfoot.isKeyDown("left")){
            move(-k);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right")){
            move(k);
            facing = "right";
        }
        eat();
        animateKangaroo();
        if(boostTimer.millisElapsed() > 5000){
            k = 2;  
            world.resetBackground();
        }
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
         kangarooSound.play();
        }
        
    }
    
   

    }

