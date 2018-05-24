package tao;

import actores.Usuario;
import apuestas.FactoriaApuesta;

public class TAOApuesta {
	//Atributos genericos
	private String usuario;
	private String idApuesta;
	private int CuotaApuesta;
	private int CantidadApuesta;
	
	//Atributos GEP
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	
	//Atributos GanaPorMas
	
	private int cuotaDosOMas;
	private int cuotaTresOMas;
	private int cuotaUnoMas;
	
	//Atributos Torneo
	
	private String PrimeraPos;
	private String SegundaPos;
	private String TerceraPos;
	
	//TaoApuestaGenerico
	public TAOApuesta(String idApuesta, String tipo, String usuario,int cantidad) {
		
	}
	
	//TaoApuestaGEP
	public TAOApuesta(String idApuesta, String usuario,int cantidad, int cuotaGanaA, int cuotaGanaB, int cuotaEmpate){
		
	}

	
	//TaoApuestaGanaPorMas
	
	public TAOApuesta(String idApuesta, String tipo, String usuario,int cantidad, int cuotaDosOMas, int cuotaTresOMas,
			int cuotaUnoMas) {
		
	}
	
	//TaoApuestaToreno
	public TAOApuesta(String idApuesta, String usuario,
			int cantidad, String PrimeraPos, String SegundaPos, String TerceraPos){
		
	}
	
	public int getCantidadApuesta() {
		return this.CantidadApuesta;
	}
	
	public int setCantidadApuesta(int cant) {
		return this.CantidadApuesta = cant;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public String setUsuario(String user) {
		return this.usuario = user;
	}
	
	public String getIdApuesta() {
		return this.idApuesta;
	}
	
	public String setIdApuesta(String id) {
		return this.idApuesta = id;
	}

}
