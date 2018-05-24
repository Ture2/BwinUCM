package apuestas;

import actores.Usuario;

public class Torneo extends Apuesta {
	
	protected String PrimeraPos;
	protected String SegundaPos;
	protected String TerceraPos;
	
	
	public Torneo(){}
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

}
