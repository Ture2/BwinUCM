package apuestas;



public abstract class Apuesta {
	protected String usuario;
	protected String idApuesta;
	protected int CuotaApuesta;
	protected int cantidadApuesta;
	
	
	protected String generateID(String id){
		return "";
	}
	
	public int getCantidadApuesta() {
		return this.cantidadApuesta;
	}
	
	 public void setCantidadApuesta(int cant) {
		this.cantidadApuesta = cant;
	 }
	
	 public int getCuotaApuesta() {
		 return this.CuotaApuesta;
	 }
	
	 public void setCuotaApuesta(int cuota) {
		  this.CuotaApuesta = cuota;
	 }
	
	 public String getId() {
		 return this.idApuesta;
	 }
	
	 public void setId(String id) {
		  this.idApuesta = id;
	 }
	
	 public String getUser() {
		 return this.usuario;
	 }
	
	 public void setUser(String user) {
		 this.usuario = user;
	 }
}
