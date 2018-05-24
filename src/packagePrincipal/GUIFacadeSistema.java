package packagePrincipal;

import sa.SAApuestasCompeticionesImp;
import sa.SAUsuarioImp;

public class GUIFacadeSistema {
	// creo que faltan atributos pero no sabia como ponerlos
	private SAApuestasCompeticionesImp sApuestasCompeticiones;
	private SAUsuarioImp sAUsuario;
	
	
	
	public GUIFacadeSistema() {
		this.sApuestasCompeticiones = new SAApuestasCompeticionesImp();
		this.sAUsuario = new SAUsuarioImp();
	}
	
	public void CrearUsuario(String nombre,String pass, String correo) {
		this.sAUsuario.CrearUsuario(nombre, pass, correo);
	}
	
	
	public void BorrarUsuario(String nombre,String pass, String correo) {
		this.sAUsuario.BorrarUsuario(nombre, pass, correo);
	}

	public void Login(String nombre, String pass) {		
		this.sAUsuario.Login(nombre, pass);
	}
	
	public void CerrarSesion(String nombre, String pass) {
		this.sAUsuario.CerrarSesion(nombre, pass);
	}
	
	public void CambiarContrasena(String nombre, String pass, String correo) {
		this.sAUsuario.CambiarContrasena(nombre, pass, correo);
	}
	
	public void Apostar(int CantidadBwinCoins) {
		
	}
	
	public void AdministrarApuestas() {
		
	}
	
	public void VerCompeticiones() {
		
	}
	
	public void Configuracion() {
		
	}
}
