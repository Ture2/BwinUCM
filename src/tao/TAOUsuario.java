package tao;

public class TAOUsuario {

	private String IdUser;
	private String Nombre;
	private String Pass;
	private String CorreoUCM;
	private int BwinCoins;
	private boolean validacion;
	
	public TAOUsuario(){}
	public TAOUsuario(String id,String nombre, String pass, int dinero,String correo) {
		this.IdUser = id;
		this.Nombre = nombre;
		this.Pass = pass;
		this.BwinCoins = dinero;
		this.CorreoUCM = correo;
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
	
	public int getDinero(){
		return this.BwinCoins;
	}
	
	public void setDinero(int bwinsCoins){
		this.BwinCoins = bwinsCoins;
	}
	public void SetNombre(String nombre) {
		 this.Nombre = nombre;
	}
	
	public String GetPass() {
		return Pass;
	}
	
	public void SetPass(String contrasena) {
		this.Pass = contrasena;
	}
	
	public String GetCorreo() {
		return CorreoUCM;
	}
	
	public void SetCorreo(String mail) {
		this.CorreoUCM = mail;
	}
	
	public boolean GetValidacion() {
		return validacion;
	}
	
	public void SetValidacion(boolean val) {
		this.validacion = val;
	}
	
}
