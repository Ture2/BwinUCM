package sa;

import java.io.IOException;

public interface SAUsuario {
	public void BorrarUsuario(String nombre, String pass, String correo);
	public void CambiarContrasena(String nombre, String pass, String correo);
	public void Login(String nombre, String pass);
	public boolean CrearUsuario(String id, String nombre, String pass, int dinero, String correo) throws IOException;
	

}
