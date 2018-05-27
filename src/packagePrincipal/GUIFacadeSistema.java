package packagePrincipal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



import sa.SAApuestasCompeticionesImp;
import sa.SAUsuarioImp;
import tao.TAOCompeticion;

public class GUIFacadeSistema {
	// creo que faltan atributos pero no sabia como ponerlos
	private Scanner in = new Scanner(System.in);
	private ControladorPrincipal controlador;
	private String nombre;
	private String nick;
	private String pass;
	private String correo;
	private int bwinCoins;
	private String idApuesta;
	private int cantidad;
	private String tipoApuesta;
	
	
	public GUIFacadeSistema() {
		this.controlador = ControladorPrincipal.getControlador();
	}
	
	
	public void interfazLogin(){
		boolean exit = false;
		String line = "";
		while(!exit){
			System.out.println("--------> Bwin Ucm <---------\n");
			System.out.println("Menu:\n"
					+ "1.- Login\n"
					+ "2.- Darse de Alta\n"
					+ "3.- Exit\n");
			line = in.nextLine();
			
			if(line.equalsIgnoreCase("1")){
				System.out.println("Introduzca el nick\n");
				this.introducirNick();
				System.out.println("Introduzca la contraseña\n");
				this.escribirContraseña();
				this.sumbitLogin();
				
				exit = interfazUsuario();
			}else if(line.equalsIgnoreCase("2")){
				System.out.println("Introduzca el nombre\n");
				this.introducirNombre();
				System.out.println("Introduzca el nick\n");
				this.introducirNick();
				System.out.println("Introduzca el mail\n");
				this.introducirCorreo();
				System.out.println("Introduzca la contraseña\n");
				this.escribirContraseña();
				this.sumbitRegistrar();
				
				exit = interfazUsuario();
			}else if(line.equalsIgnoreCase("3")) exit = true;
		}
		
		
	}
	
	private boolean interfazUsuario(){
		boolean exit = false;
		String line = "";
		while(!exit){
			System.out.println("--------> Bwin Ucm <---------\n");
			System.out.println("Menu:\n"
					+ "1.- Apostar\n"
					+ "2.- Hacerse Premium\n"
					+ "3.- Configurar cuenta\n"
					+ "4.- Exit\n");
			line = in.nextLine();
			
			if(line.equalsIgnoreCase("1")){
				String[] competiciones = this.controlador.visualizarCompeticiones();
				for(int i = 0; i < competiciones.length; i++){
					if(competiciones[i] != null) System.out.println(competiciones[i]);
				}
				System.out.println("Introduzca el id\n");
				this.selecionarApuesta();
				System.out.println("Introduzca la cantidad\n");
				this.introducirCantidadApuesta();
				System.out.println("Seleccione el tipo de apuesta: GEP  | Ganar por mas  | Torneo\n");
				this.selecionarTipoApuesta();
				this.sumbitApostar();
			}else if(line.equalsIgnoreCase("2")){
				System.out.println("Introduzca el nombre\n");
				this.introducirNombre();
				System.out.println("Introduzca el nick\n");
				this.introducirNick();
				System.out.println("Introduzca el mail\n");
				this.introducirCorreo();
				System.out.println("Introduzca la contraseña\n");
				this.escribirContraseña();
				this.sumbitRegistrar();
			}else if(line.equalsIgnoreCase("3")) exit = true;
		}
		return exit;
	}
	
	
	public void introducirNombre(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.nombre = palabra[0];
	}
	
	public void introducirNick(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.nick = palabra[0];
	}

	public void introducirCorreo(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.correo = palabra[0];
	}
	public void escribirContraseña(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.pass = palabra[0];
	}
	
	public void sumbitLogin(){
		this.controlador.IniciarSesion(this.nick, this.pass);
	}

	public void sumbitRegistrar(){
		this.controlador.CrearUsuario(this.nick, this.nombre, this.pass, this.correo);
	}
	
	
	public void introducirCantidadApuesta(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.cantidad = Integer.parseInt(palabra[0]);
	}
	
	public void selecionarApuesta(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.idApuesta = palabra[0];
	}
	
	public void selecionarTipoApuesta(){
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.tipoApuesta = palabra[0];
	}
	public void sumbitApostar(){
		String[] pos = null;  
		this.controlador.Apostar(this.cantidad, this.nick, this.idApuesta, this.tipoApuesta, 2, pos);
	}
	
}
