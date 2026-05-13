import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class enemigoActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemigoActor extends PokemonActor
{
    Random random = new Random();

int direccionX = 0;
int direccionY = 0;

int tiempoMovimiento = 0;
int tiempoDisparo = 0;
    public enemigoActor(String imagen)
{
    super(imagen);
}
    /**
     * Act - do whatever the enemigoActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
public void act()
{
    if(tiempoMovimiento <= 0){
        direccionX =random.nextInt(7) - 3;

        direccionY =random.nextInt(7) - 3;

        tiempoMovimiento = 40;
        
    }
    if(tiempoDisparo > 0){
    tiempoDisparo--;
}
if(random.nextInt(100) == 0&& tiempoDisparo == 0){
    PokemonWorld mundo =(PokemonWorld)getWorld();

proyectil p =new proyectil(0,mundo.combate,true);

mundo.addObject(p,getX() - 80,getY());

p.setRotation(180);

tiempoDisparo = 40;
}

    setLocation(getX() + direccionX,getY() + direccionY);
    tiempoMovimiento--;
}
}
