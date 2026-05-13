import java.util.Random;

public class Combate
{
    Pokemon jugador;
    Pokemon enemigo;

    Random random = new Random();

    public Combate(Pokemon jugador,Pokemon enemigo){
        this.jugador = jugador;
        this.enemigo = enemigo;
    }

    public void turnoJugador(int indiceAtaque)
    {
        Ataque ataqueJugador =jugador.listaDeAtaques.get(indiceAtaque);
        jugador.atacar(enemigo,ataqueJugador);
    }

    public void turnoEnemigo(){
        int indiceRandom =random.nextInt(enemigo.listaDeAtaques.size());

        Ataque ataqueEnemigo =enemigo.listaDeAtaques.get(indiceRandom);

        enemigo.atacar(jugador,ataqueEnemigo);
    }

    public boolean combateTerminado(){
        return jugador.vida <= 0|| enemigo.vida <= 0;
    }
}
