package packagePrincipal;

import sa.SAApuestasCompeticionesImp;
import sa.SAUsuarioImp;

public class GUIFacadeSistema {
	// creo que faltan atributos pero no sabia como ponerlos
	private ControladorPrincipal cp = null;
	private String nombre;
	private String nick;
	private String pass;
	private String correo;
	private int bwinCoins;
	
	
	public GUIFacadeSistema() {
		this.cp =  new ControladorPrincipal();
	}
	
	public void accionCrearUsuario(String nombre,String pass, String correo) {
		this.cp.CrearUsuario(this.nick, this.nombre, this.pass, this.correo);
	}
	
	
	public void accionBorrarUsuario(String nombre,String pass, String correo) {
		//No se susa
	}

	public void accionLogin(String nombre, String pass) {		
		this.cp.
	}
	
	public void accionCerrarSesion(String nombre, String pass) {
		this.sAUsuario.CerrarSesion(nombre, pass);
	}
	
	public void accionCambiarContrasena(String nombre, String pass, String correo) {
		this.sAUsuario.CambiarContrasena(nombre, pass, correo);
	}
	
	public void accionApostar(int CantidadBwinCoins) {
		
	}
	
	public void accionAdministrarApuestas() {
		
	}
	
	public void accionVerCompeticiones() {
		
	}
	
	public void accionConfiguracion() {
		
	}
}
