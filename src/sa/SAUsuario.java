package sa;

public interface SAUsuario {
	public boolean CrearUsuario(String nombre, String pass, String correo);
	public void BorrarUsuario(String nombre, String pass, String correo);
	public void CambiarContrase�a(String nombre, String pass, String correo);
	public void Login(String nombre, String pass);
	

}
