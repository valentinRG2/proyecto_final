import greenfoot.*;
import java.util.ArrayList;
import java.util.Random;

public class PokemonWorld extends World
{
    int finDelay = -1;
    ArrayList<Pokemon> pokemones;

    Pokemon jugador;
    Pokemon enemigo;
    jugadorActor actorJugador;
    int tiempoEspera = 0;
    Combate combate;

    public PokemonWorld()
    {
        super(900, 600, 1);

        setBackground("fondo.png");

        LeerCSV lector = new LeerCSV();

        pokemones =
        lector.leerPokemones();

        ArrayList<Ataque> ataques =lector.leerAtaques();

        ArrayList<String[]> conexiones =lector.conectar(pokemones,ataques);
        for(String[]conexion : conexiones) {
            //el continue es para saltar esa vuelta del for por que llega una lista en cero
            if(conexion.length < 2) {
                continue;
            }
            String nombrePokemon = conexion[0];
            String nombreAtaque = conexion[1];

            for(Pokemon pokemon :pokemones) {
                if(pokemon.nombre.equals(nombrePokemon)) {
                    for(Ataque ataque : ataques) {
                        if(ataque.nombre.equals(nombreAtaque)) {
                            pokemon.listaDeAtaques.add(ataque);
                        }
                    }
                }
            }
        }

        Random random =new Random();

        jugador =pokemones.get(0);

        enemigo =pokemones.get(random.nextInt(pokemones.size()));

        combate =new Combate(jugador,enemigo);

        showText("HP: " + jugador.vida,120,50);

        showText("HP: " + enemigo.vida,750,350);
        //Construye nombre de imagen.
        actorJugador =new jugadorActor(jugador.nombre + ".png");

        addObject(actorJugador,300,420);

        addObject(new enemigoActor(enemigo.nombre + ".png"),700,250);

        showText("1. " +jugador.listaDeAtaques.get(0).nombre,750,500);

        showText("2. " +jugador.listaDeAtaques.get(1).nombre,750,530);

        showText("3. " +jugador.listaDeAtaques.get(2).nombre,750,560);
        prepare();
    }

    public void act()
    {
        if(combate.combateTerminado())
        {
            if(jugador.vida <= 0){
                showText("PERDISTE",450,300);
            }

            if(enemigo.vida <= 0)
            {
                showText(
                    "GANASTE",
                    450,
                    300
                );
            }

            Greenfoot.stop();

            return;
        }
        if(tiempoEspera > 0)
        {
            tiempoEspera--;
        }

        if(Greenfoot.isKeyDown("1")&& tiempoEspera == 0){
            proyectil p =new proyectil(0,combate,false);
            //Agrega proyectil
            addObject(p,actorJugador.getX()+80,actorJugador.getY());

            showText("HP: " + enemigo.vida,750,350);

            showText("HP: " + jugador.vida,120,50);
            tiempoEspera = 40;
            showText("HP: " + enemigo.vida,750,350);
        }
        if(Greenfoot.isKeyDown("2")&& tiempoEspera == 0){
            proyectil p =new proyectil(1,combate,false);
            //el +80 es para que el proyectil salga un poc mas adelante del jugador
            addObject(p,actorJugador.getX() + 80,actorJugador.getY());
            //espera 40 frames
            tiempoEspera = 40;

            showText("HP: " + enemigo.vida,750,350);

            showText("HP: " + jugador.vida,120,50);
        }
        if(Greenfoot.isKeyDown("3")&& tiempoEspera == 0){
            proyectil p =new proyectil(2,combate,false);

            addObject(p,actorJugador.getX() + 80,actorJugador.getY());
            tiempoEspera = 40;
            showText("HP: " + enemigo.vida,750,350);

            showText("HP: " + jugador.vida,120,50);
        }

        if(enemigo.vida <= 0)
        {
            showText("GANASTE",450,300);

            finDelay = 60;
        }
        showText("HP: " + enemigo.vida,750,350);

        showText("HP: " + jugador.vida,120,50);
        if(jugador.vida <= 0)
        {
            showText("PERDISTE",450,300);

            finDelay = 60;
        }
        showText("HP: " + enemigo.vida,750,350);

        showText("HP: " + jugador.vida,120,50);

        if(finDelay > 0)
        {
            finDelay--;

            if(finDelay == 0)
            {
                Greenfoot.stop();
            }
        }

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}


