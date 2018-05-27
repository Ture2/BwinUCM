package packagePrincipal;

import java.io.IOException;
import java.util.ArrayList;

import sa.SAApuestasCompeticionesImp;
import sa.SAUsuarioImp;
import tao.TAOCompeticion;

public class ControladorPrincipal {
	private SAUsuarioImp saUsuario;
	private SAApuestasCompeticionesImp saApuComp;
	private String nick;
	
	private static ControladorPrincipal instancia;
	
	
	private ControladorPrincipal(){
		this.saUsuario = new SAUsuarioImp();
		this.saApuComp = new SAApuestasCompeticionesImp();
	}
	
	public static ControladorPrincipal getControlador(){
		if(instancia == null) instancia = new ControladorPrincipal();
		return instancia;
	}
	
	public boolean CrearUsuario(String nick, String nombre, String pass, String correo){
		return this.saUsuario.CrearUsuario(nick, nombre, pass, 0, correo);
	}
	
	public boolean IniciarSesion(String nick, String pass){
		boolean ok = this.saUsuario.Login(nick, pass);
		if(ok){
			this.nick = nick;
		}
		return ok;
	}
	public void CerrarSesion(String nick) {
		this.saUsuario.CerrarSesion(nick);
	}

	public void CambiarContrasena(String nick, String oldPass, String newPass) {
		this.saUsuario.CambiarContrasena(nick, oldPass, newPass);
	}
	
	public String[] visualizarCompeticiones(){
		return this.saApuComp.VisualizarCompeticiones();
	}
	public void Apostar(int cant, String nick, String id, String tipo, int cuota, String[] pos){
		this.saApuComp.Apostar(cant, nick, id, tipo, cuota, pos);
	}
}
