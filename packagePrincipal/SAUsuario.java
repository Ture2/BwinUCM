package packagePrincipal;

public interface SAUsuario {
	public boolean CrearUsuario(String nombre, String pass, String correo);
	public void BorrarUsuario(String nombre, String pass, String correo);
	public void CambiarContraseņa(String nombre, String pass, String correo);
	public void Login(String nombre, String pass);
	

}
