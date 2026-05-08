package proyectoFinalPokemon;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		

		LeerCSV lector = new LeerCSV();
		ArrayList<Pokemon> pokemones =
				lector.leerPokemones();
		Pokemon jugador =
				menuPokemons(pokemones);

		ArrayList<Ataque> ataques =
				lector.leerAtaques();

		ArrayList<String[]> conexiones=lector.conectar(pokemones, ataques);
		
		

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
		
		

	}
	public static Pokemon menuPokemons(ArrayList<Pokemon> pokemones) {
		System.out.println("SELECCIONA TU POKEMON: ");
		for(int i=0;i<pokemones.size();i++) {
				System.out.println((i+1)+"."+pokemones.get(i).nombre);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("CUAL ELIGES?->");
		int op=sc.nextInt();
		
		Pokemon pokemonJugador =pokemones.get(op - 1);
		return pokemonJugador;
	}
}

