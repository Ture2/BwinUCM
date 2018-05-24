package apuestas;

import actores.Usuario;

public class GanaPorMas extends Apuesta{
	
	private int cuotaDosOMas;
	private int cuotaTresOMas;
	private int cuotaUnoMas;
	
	public int getCuotaDosOMas(){
		return cuotaDosOMas;
		
	}

	public int getCuotaTresOMas(){
		return cuotaTresOMas;
		
	}
	
	public int getCuotaUnoMas(){
		return cuotaUnoMas;
		
	}
	
	public void setCuotaDosOMas(int c){
		this.cuotaDosOMas = c;
	}
	
	public void setCuotaTresOMas(int c){
		this.cuotaTresOMas = c;
	}
	
	public void setCuotaUnaMas(int c){
		this.cuotaUnoMas = c;
	}
}
