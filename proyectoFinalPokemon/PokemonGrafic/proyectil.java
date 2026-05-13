import greenfoot.*;

public class proyectil extends Actor
{
    int shotImg = 1;
    int velocidad = 7;
    int posicion;
    Combate combate;
    boolean esEnemigo;

public proyectil(int direccion,Combate combate,boolean esEnemigo){
    posicion = direccion;
    this.combate = combate;
    this.esEnemigo = esEnemigo;
}
    public void act(){
        setImage("shots/shot" +shotImg +".png");

        GreenfootImage img =getImage();
        img.scale(80,80);
        move(velocidad);
        
if(esEnemigo == false)
{
    enemigoActor enemigo =(enemigoActor)getWorld().getObjects(enemigoActor.class).get(0);

    int distanciaX =
    Math.abs(getX() - enemigo.getX());

    int distanciaY =
    Math.abs(getY() - enemigo.getY());

    if(distanciaX < 40
    && distanciaY < 40)
    {
        combate.turnoJugador(0);
        getWorld().removeObject(this);

        return;
    }
}

if(esEnemigo == true)
{
    jugadorActor jugador =(jugadorActor)getWorld().getObjects(jugadorActor.class).get(0);

    int distanciaX =
    Math.abs(getX() - jugador.getX());

    int distanciaY =
    Math.abs(getY() - jugador.getY());

    if(distanciaX < 40
    && distanciaY < 40)
    {
        combate.turnoEnemigo();

        getWorld().removeObject(this);

        return;
    }
}

        shotImg++;

        if(shotImg > 6){
            shotImg = 1;
        }
        //pregunta si toca el borde del mapa
        if(isAtEdge()){
        getWorld().removeObject(this);
        }
    }
}
