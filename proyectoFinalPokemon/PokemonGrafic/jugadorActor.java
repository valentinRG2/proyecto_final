import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class jugadorActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class jugadorActor extends PokemonActor
{
    public jugadorActor(String imagen)
{
    super(imagen);
}
    /**
     * Act - do whatever the jugadorActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-3);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+3);
        }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-3,getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+3,getY());
        }
        
    }
}
