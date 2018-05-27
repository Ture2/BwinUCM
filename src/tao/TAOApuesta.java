package tao;

import actores.Usuario;
import apuestas.FactoriaApuesta;

public class TAOApuesta {
	//Atributos genericos
	private String usuario;
	private String idApuesta;
	private int CuotaApuesta;
	private int CantidadApuesta;
	private String tipo;
	
	//Atributos GEP
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	
	//Atributos GanaPorMas
	
	private int cuotaDosOMas;
	private int cuotaTresOMas;
	private double cuotaUnoMas;
	private int coutaCuatroExactos;
	
	//Atributos Torneo
	
	private String PrimeraPos;
	private String SegundaPos;
	private String TerceraPos;
	
	//TaoApuestaGenerico
	public TAOApuesta(String idApuesta, String usuario,int cantidad) {
	}
	
	//TaoApuestaGEP
	public TAOApuesta(String idApuesta, String usuario,int cantidad, int cuotaApuesta, int cuotaGanaA, int cuotaGanaB, int cuotaEmpate){
		this.tipo = "GEP";
		this.usuario = "usuario";
		this.CantidadApuesta = cantidad;
		this.CuotaApuesta = cuotaApuesta;
		this.CuotaGanaA = cuotaGanaA;
		this.CuotaGanaB = cuotaGanaB;
		this.CuotaEmpate = cuotaEmpate;
	}

	
	//TaoApuestaGanaPorMas
	
	public TAOApuesta(String idApuesta, String usuario, int cantidad, int cuotaApuesta) {
		this.tipo = "WINFORMORE";
		this.usuario = "usuario";
		this.CantidadApuesta = cantidad;
		this.CuotaApuesta = cuotaApuesta;
		this.cuotaDosOMas = 3;
		this.cuotaTresOMas = 4;
		this.cuotaUnoMas = 1.5;
		this.coutaCuatroExactos = 5;
	}
	
	//TaoApuestaToreno
	public TAOApuesta(String idApuesta, String usuario, int cantidad, String[] pos){
		this.tipo = "TORNEO";
		this.usuario = usuario;
		this.CantidadApuesta = cantidad;
		this.CuotaApuesta = 4;
		this.PrimeraPos = pos[0];
		this.SegundaPos = pos[1];
		this.TerceraPos = pos[2];
	}
	
	//TaoApuestaId
	
	public TAOApuesta(String id_apuesta){
		this.idApuesta = id_apuesta;
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

	public String getTipo(){
		return this.tipo;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
}
