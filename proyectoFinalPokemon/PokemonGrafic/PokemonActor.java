import greenfoot.*;

public class PokemonActor extends Actor
{
    public PokemonActor(String imagen)
    {
        setImage(imagen);

        GreenfootImage img = getImage();

        img.scale(160,160);
    }
    
}

