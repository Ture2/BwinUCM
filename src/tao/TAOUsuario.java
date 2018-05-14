package tao;

public class TAOUsuario {

	private String IdUser;
	private String Nombre;
	private String Pass;
	private String CorreoUCM;
	private int BwinCoins;
	private boolean validacion;
	
	public TAOUsuario(String id,String nombre, String pass, int dinero,String correo) {
		
	}
	
	public String GetIdUser() {
		return this.IdUser;
	}
	
	public String SetIdUser(String p1) {
		return this.IdUser = p1;
	}
	
	public String GetNombre() {
		return Nombre;
	}
	
	public String SetNombre(String nombre) {
		return this.Nombre = nombre;
	}
	
	public String GetPass() {
		return Pass;
	}
	
	public String SetPass(String contraseña) {
		return this.Pass = contraseña;
	}
	
	public String GetCorreo() {
		return CorreoUCM;
	}
	
	public String SetCorreo(String mail) {
		return this.CorreoUCM = mail;
	}
	
	public boolean GetValidacion() {
		return validacion;
	}
	
	public boolean SetValidacion(boolean val) {
		return this.validacion = val;
	}
	
}
