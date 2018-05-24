package tao;

public class TAOCompeticion {
	private String equipoA;
	private String equipoB;
	private String fechaIni;
	private String fechaFin;
	private int CuotaGanaA;
	private int CuotaGanaB;
	private int CuotaEmpate;
	private String idCompeticion;
	
	public TAOCompeticion(String idCompeticion, String equipoA, String equipoB, String Fechaini, String Fechafin) {
		this.equipoA = equipoA;
		this.equipoB = equipoB;
		this.fechaIni = Fechaini;
		this.fechaFin = Fechafin;
		this.idCompeticion = idCompeticion;
		
	}
	
	public void setCuotaGanaA(int a){
		this.CuotaGanaA = a;
	}
	
	public void setCuotaGanaB(int b){
		this.CuotaGanaB = b;
	}
	
	public void setCuotaEmpate(int e){
		this.CuotaEmpate = e;
	}
	
	
	public int getCuotaGanaA(){
		return this.CuotaGanaA;
	}
	
	public int getCuotaGanaB(){
		return this.CuotaGanaB;
	}

	public int getCuotaEmpate(){
		return this.CuotaEmpate;
	}
	public TAOCompeticion(String id){
		this.idCompeticion = id;
	}
	
	public String getEquipoA() {
		return this.equipoA;
	}
	
	public String getEquipoB() {
		return this.equipoB;
	}
	
	public void setEquipoA(String eA) {
		this.equipoA = eA ;
	}
	
	public void setEquipoB(String eB) {
		this.equipoB = eB ;
	}
	
	public String getFechaIni() {
		return this.fechaIni;
	}
	
	public void setFechaIni(String fechaini) {
		this.fechaIni = fechaini;
	}
	
	public String getFechaFin() {
		return this.fechaFin;
	}
	
	public void setFechaFin(String fechafin) {
		this.fechaFin = fechafin;
	}
	
	public String getId() {
		return this.idCompeticion;
	}
	
	public void setId(String id) {
		this.idCompeticion = id;
	}


}
