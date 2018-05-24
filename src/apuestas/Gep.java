package apuestas;

import actores.Usuario;

public class Gep extends Apuesta {
	private String ArrayCuotas;
	private String usuario;
	private String idApuesta;
	private int CuotaApuesta;
	private int cantidadApuesta;
	
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	
	
	
	public int getCuotaganaA() {
		return this.CuotaGanaA;
	}
	
	public int setCuotaGanaA(int cuotaganaA) {
		return this.CuotaGanaA = cuotaganaA;
	}
	
	public int getCuotaganaB() {
		return this.CuotaGanaB;
	}
	
	public int setCuotaGanaB(int cuotaganaB) {
		return this.CuotaGanaB = cuotaganaB;
	}
	
	public int getCuotaEmpate() {
		return this.CuotaEmpate;
	}
	
	public int setCuotaEmpate(int cuotaEmpate) {
		return this.CuotaEmpate = cuotaEmpate;
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

	@Override
	public boolean GenerateId(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCuotaApuesta(int c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCuotaApuesta() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
