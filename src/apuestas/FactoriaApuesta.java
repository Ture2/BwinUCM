package apuestas;

import actores.Usuario;

public class FactoriaApuesta {
	
	// el diagrama de clases esta mal 

	private int cantidadApuesta;
	private int CuotaApuesta;
	private String idApuesta;
	private Usuario usuario;
	
	public FactoriaApuesta() {
		
	}
	
	public String GenerateId(String id) {
		return id;
	}
	
	public int getCantidadApuesta() {
		return this.cantidadApuesta;
	}
	 public int setCantidadApuesta(int cant) {
		 return this.cantidadApuesta = cant;
	 }
	 
	 public int getCuotaApuesta() {
		 return this.CuotaApuesta;
	 }
	
	 public int setCuotaApuesta(int cuota) {
		 return this.CuotaApuesta = cuota;
	 }
	 
	 public String getId() {
		 return this.idApuesta;
	 }
	 
	 public String setId(String id) {
		 return this.idApuesta = id;
	 }
	 
	 public Usuario getUser() {
		 return this.usuario;
	 }
	 
	 public Usuario setUser(Usuario user) {
		 return this.usuario = user;
	 }
}

