package packagePrincipal;

import java.io.IOException;

import sa.SAApuestasCompeticionesImp;
import sa.SAUsuarioImp;

public class ControladorPrincipal {
	private SAUsuarioImp saUsuario;
	private SAApuestasCompeticionesImp saApuComp;
	
	
	public ControladorPrincipal(){
		this.saUsuario = new SAUsuarioImp();
		this.saApuComp = new SAApuestasCompeticionesImp();
	}
	
	public boolean CrearUsuario(String nick, String nombre, String pass, String correo){
		return this.saUsuario.CrearUsuario(nick, nombre, pass, 0, correo);
	}
	
	public boolean IniciarSesion(){
		
	}
	public void CerrarSesion(String nick) {
		// TODO Auto-generated method stub
		this.saUsuario.CerrarSesion(nick);
	}

	public void CambiarContrasena(String nick, String oldPass, String newPass) {
		this.saUsuario.CambiarContrasena(nick, oldPass, newPass);
	}
	
	
	public void Apostar(){
		this.saApuComp.Apostar(cant_BwinCoins, nick_usuario, id_competicion, tipo_competicion, cuota, pos);
	}
}
