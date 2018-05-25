package sa;

import java.io.IOException;

public interface SAUsuario {
	public void BorrarUsuario(String nombre, String pass, String correo) throws NumberFormatException, IOException;
	public void CambiarContrasena(String nombre, String pass, String correo) throws IOException;
	public void Login(String nombre, String pass) throws IOException;
	public boolean CrearUsuario(String id, String nombre, String pass, int dinero, String correo) throws IOException;
	boolean HacersePremium(String id) throws IOException;
	boolean ConfigurarDinero(String id, int cantidad, String accion) throws IOException;

}
