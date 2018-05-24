package tao;

import actores.Usuario;
import apuestas.FactoriaApuesta;

public class TAOApuesta {
	//Atributos genericos
	private String ArrayCuotas;
	private String usuario;
	private String idApuesta;
	private int CuotaApuesta;
	private int CantidadApuesta;
	
	//Atributos GEP
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	
	//Atributos Alternative
	
	//Atributos Torneo
	
	private String PrimeraPos;
	private String SegundaPos;
	private String TerceraPos;
	
	//TaoApuestaGenerico
	public TAOApuesta(String idApuesta, String tipo, String usuario,int cantidad) {
		
	}
	
	//TaoApuestaGEP
	public TAOApuesta(String idApuesta, String usuario,int cantidad),{
		
	}

	
	//TaoApuestaAlternative
	
	
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
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public Usuario setUsuario(Usuario user) {
		return this.usuario = user;
	}
	
	public FactoriaApuesta getTipo() {
		return this.tipo;
		
	}
	
	public FactoriaApuesta setTipo(FactoriaApuesta tipoApuesta) {
		return this.tipo = tipoApuesta;
	}
	
	public String getIdApuesta() {
		return this.idApuesta;
	}
	
	public String setIdApuesta(String id) {
		return this.idApuesta = id;
	}

}
