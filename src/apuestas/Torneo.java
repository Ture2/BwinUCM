package apuestas;

import actores.Usuario;

public class Torneo extends Apuesta {
	private String ArrayCuotas;
	private String usuario;
	private String idApuesta;
	private int cantidadApuesta;
	
	private String PrimeraPos;
	private String SegundaPos;
	private String TerceraPos;
	
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	
	public String getPrimerapos() {
		return this.PrimeraPos;
	}
	
	public String SetPrimeraPos(String primerapos) {
		return this.PrimeraPos = primerapos;
	}
	
	public String getSegundapos() {
		return this.SegundaPos;
	}
	
	public String SetSegundaPos(String segundapos) {
		return this.SegundaPos = segundapos;
	}
	
	public String getTercerapos() {
		return this.TerceraPos;
	}
	
	public String SetTerceraPos(String tercerapos) {
		return this.TerceraPos = tercerapos;
	}

	public boolean GenerateId(String id) {
		return true;
	}
	
	@Override
	public int getCantidadApuesta() {
		return this.cantidadApuesta;
	}
	@Override
	 public void setCantidadApuesta(int cant) {
		this.cantidadApuesta = cant;
	 }
	
	@Override
	 public String getId() {
		 return this.idApuesta;
	 }
	@Override
	 public void setId(String id) {
		  this.idApuesta = id;
	 }
	@Override
	 public String getUser() {
		 return this.usuario;
	 }
	@Override
	 public void setUser(String user) {
		 this.usuario = user;
	 }

}
