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
		try {
			return this.saUsuario.CrearUsuario(nick, nombre, pass, 0, correo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	public void CerrarSesion(String nick) {
		// TODO Auto-generated method stub
		this.saUsuario.CerrarSesion(nick);
	}

	public void CambiarContrasena(String nick, String oldPass, String newPass) {
		this.saUsuario.CambiarContrasena(nick, oldPass, newPass);
		
	}
	
	
	
	public void Apostar(){
		
	}
}
