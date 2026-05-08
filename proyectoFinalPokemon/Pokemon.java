package proyectoFinalPokemon;

import java.util.ArrayList;

public class Pokemon {
	String nombre;
	String tipo;
	int vida;
	int defensa;
	
	ArrayList<Ataque> listaDeAtaques;
	public Pokemon() {
		listaDeAtaques = new ArrayList<>();

	}
	
	public void atacar(Pokemon enemigo,Ataque ataque) {
		int dano=ataque.dano-enemigo.defensa;
		if(dano<0) {
			dano=0;
		}
		enemigo.vida-=dano;
		System.out.println(enemigo.nombre+" ahora tiene"+enemigo.vida+" de vida");
	}
}
