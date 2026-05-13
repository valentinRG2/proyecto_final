import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class LeerCSV {
	public ArrayList<Pokemon> leerPokemones() {
		File archivo=new File("datos/info_pokemons.csv"); // para que el programa sepa que archivo usar
		try {
			// el sc.nextLine es para ignorar la primera linea del archivo que es: nombre;tipo;vida;defensa
			Scanner sc =new Scanner(archivo);
			sc.nextLine();
			//lista para guardar los pokemons
			ArrayList<Pokemon> listaPokemones = new ArrayList<>();

			//el hasNextLine pregunta si hay mas lineas por leer y retorna true o false
			while(sc.hasNextLine()) {
				String linea=sc.nextLine();
				//hace que cada separacion por ; sea un dato aparte de la forma datos[0]=dato
				String[] datos = linea.split(";");
				//crear el objeto automaticamente
				Pokemon pokemon = new Pokemon();
				//se asigna un dato del csv a cada atributo respectivamente
				pokemon.nombre = datos[0];
				pokemon.tipo = datos[1];
				// Integer.parseInt convierte el dato String a int
				pokemon.vida = Integer.parseInt(datos[2]);
				pokemon.defensa = Integer.parseInt(datos[3]);
				//agrega los pokemones a la lista 
				listaPokemones.add(pokemon);
			}
			return listaPokemones;
			//FileNotFoundException evita que el programa se rompa si no encuentra el archivo
			// la variable "e" es para guardar el error si ocurre
		}catch (FileNotFoundException e) {
			System.out.println("no se encuentra el archivo");
		}
		//por si no puede devolver la lista
		return new ArrayList<>();

	}

	public ArrayList<Ataque> leerAtaques(){
		File ataquesArchivo=new File("datos/ataques.csv"); // para que el programa sepa que archivo usar
		try {
			Scanner sc = new Scanner(ataquesArchivo);
			sc.nextLine();
			
			ArrayList<Ataque> listaAtaques = new ArrayList<>();
			
			while(sc.hasNextLine()) {
				String linea=sc.nextLine();
				String[] datosAtaques = linea.split(";");
				Ataque ataque = new Ataque();
				ataque.nombre=datosAtaques[0];
				ataque.dano=Integer.parseInt(datosAtaques[1]);
				ataque.tipo=datosAtaques[2];
				listaAtaques.add(ataque);
			}
			return listaAtaques;
			
		}catch (FileNotFoundException e) {
			System.out.println("no se encuentra el archivo");
		}
		return null;
	}
	public ArrayList<String[]> conectar(ArrayList<Pokemon> listaPokemones,ArrayList<Ataque> listaAtaques){
		File coneccionPokemon=new File("datos/pokemons_ataques.csv"); // para que el programa sepa que archivo usar
		try {
			Scanner sc=new Scanner(coneccionPokemon);
			sc.nextLine();
			
			ArrayList<String[]> conexiones = new ArrayList<>();
			
			while(sc.hasNextLine()) {
				String linea=sc.nextLine();
				String[] datosConeccion=linea.split(";");
				conexiones.add(datosConeccion);			
			}
			return conexiones;
		}
		catch (FileNotFoundException e) {
			System.out.println("no se encuentra el archivo");
		}
		return null;
		
	}
}
