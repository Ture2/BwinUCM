package actores;

public class Usuario {
	
	private String nombre;
	private String pass;
	private int BwinCoins;
	private String correo;
	private String IdUser;
	

	
	public Usuario(String nombre, String pass, String correo) {
		 this.nombre = nombre;
		 this.pass = pass;
		 this.correo = correo;
		 this.BwinCoins = 100;
		 this.IdUser = correo;
	}
	
	public String getNombre() {
		return this.nombre;
		
	}
	
	public String getPass() {
		return this.pass;
		
	}
	
	public String getIdUser() {
		return this.IdUser;
		
	}
	
	public int getBwinCoins() {
		return this.BwinCoins;
		
	}
	
	public String getMailUCM() {
		return this.correo;
				
	}
	
	public int setBwinCoins(int coins) {
		return this.BwinCoins = coins;
	}
	
}
