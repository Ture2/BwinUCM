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
				this.introducirNick();
				this.escribirContraseña();
				this.sumbitLogin();
				while(!this.sumbitLogin()){
					System.out.println("Error al iniciar sesion");
					this.introducirNick();
					this.escribirContraseña();
				}
				exit = interfazUsuario();
			}else if(line.equalsIgnoreCase("2")){
				this.introducirNombre();
				this.introducirNick();
				this.introducirCorreo();
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
				
				this.selecionarApuesta();
				this.introducirCantidad();
				this.selecionarTipoApuesta();
				this.sumbitApostar();
			}else if(line.equalsIgnoreCase("2")){
				this.controlador.premium();
			}else if(line.equalsIgnoreCase("3")){
				System.out.println("¿Que accion desea realizar?  Sacar Dinero  |   Meter Dinero");
				line = in.nextLine();
				while(!line.equalsIgnoreCase("Sacar Dinero") && !line.equalsIgnoreCase("Meter Dinero")){
					System.out.println("Error, introduzca una accion valida\n ¿Que accion desea realizar?  Sacar Dinero  |   Meter Dinero");
					line = in.nextLine();
				}
				this.introducirCantidad();
				this.controlador.configurarDinero(cantidad, line);
			}else if(line.equalsIgnoreCase("4")){
				exit = true;
			}
		}
		return exit;
	}
	
	
	public void introducirNombre(){
		System.out.println("Introduzca el nombre\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.nombre = palabra[0];
	}
	
	public void introducirNick(){
		System.out.println("Introduzca el nick\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.nick = palabra[0];
	}

	public void introducirCorreo(){
		System.out.println("Introduzca el mail\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.correo = palabra[0];
	}
	public void escribirContraseña(){
		System.out.println("Introduzca la contraseña\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.pass = palabra[0];
	}
	
	public boolean sumbitLogin(){
		return this.controlador.IniciarSesion(this.nick, this.pass);
	}

	public void sumbitRegistrar(){
		this.controlador.CrearUsuario(this.nick, this.nombre, this.pass, this.correo);
	}
	
	
	public void introducirCantidad(){
		System.out.println("Introduzca la cantidad\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.cantidad = Integer.parseInt(palabra[0]);
	}
	
	public void selecionarApuesta(){
		System.out.println("Introduzca el id\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.idApuesta = palabra[0];
	}
	
	public void selecionarTipoApuesta(){
		System.out.println("Seleccione el tipo de apuesta: GEP  | WINFORMORE  | TOURNAMENT\n");
		String line = in.nextLine();
		String[] palabra = line.split(" ");
		this.tipoApuesta = palabra[0];
	}
	public void sumbitApostar(){
		String[] pos = null;  
		this.controlador.Apostar(this.cantidad, this.idApuesta, this.tipoApuesta, 2, pos);
	}
	
	
}
