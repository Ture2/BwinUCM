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
	public void CerrarSesion() {
		this.saUsuario.CerrarSesion(this.nick);
	}

	public void CambiarContrasena(String oldPass, String newPass) {
		this.saUsuario.CambiarContrasena(this.nick, oldPass, newPass);
	}
	
	public String[] visualizarCompeticiones(){
		return this.saApuComp.VisualizarCompeticiones();
	}
	public void Apostar(int cant, String id, String tipo, int cuota, String[] pos){
		this.saApuComp.Apostar(cant, this.nick, id, tipo, cuota, pos);
	}

	public void premium() {
		this.saUsuario.HacersePremium(this.nick);
	}

	public void configurarDinero(int cantidad, String accion) {
		String acc;
		if(accion.equals("Sacar Dinero")) acc = "SacarDinero";
		else acc = "MeterDinero";
		this.saUsuario.ConfigurarDinero(this.nick, cantidad, acc);
	}

}
