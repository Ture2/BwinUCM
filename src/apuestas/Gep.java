package apuestas;

import actores.Usuario;

public class Gep extends Apuesta {
	
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	
	public Gep(){}
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
	
	

	
}
