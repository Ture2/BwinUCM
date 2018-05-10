package packagePrincipal;

public class TAOCompeticion {
	private String equipos;
	private String fechaIni;
	private String fechaFin;
	private int cuota;
	private String idCompeticion;
	private String tipo;
	
	public TAOCompeticion(String equipos, String Fechaini, String Fechafin, int cuota, String idCompeticion, String tipo) {
		
	}
	
	public String getEquipos() {
		return this.equipos;
	}
	
	public String setEquipos(String equipos) {
		return this.equipos = equipos;
	}
	
	public String getFechaIni() {
		return this.fechaIni;
	}
	
	public String setFechaIni(String fechaini) {
		return this.fechaIni = fechaini;
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	
	public String setFechaFin(String fechafin) {
		return this.fechaFin = fechafin;
	}
	
	public int getCuota() {
		return this.cuota;
	}
	
	public int setCuota(int cuota) {
		return this.cuota = cuota;
	}
	
	public String getId() {
		return this.idCompeticion;
	}
	
	public String setId(String id) {
		return this.idCompeticion = id;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public String setTipo(String tipo) {
		return this.tipo = tipo;
	}

}
