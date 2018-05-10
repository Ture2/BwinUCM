package packagePrincipal;

public class TAOApuesta {
	
	private int CantidadApuesta;
	private FactoriaApuesta tipo;
	private Usuario usuario;
	private String idApuesta;
	
	public TAOApuesta(int cantidadApuesta, FactoriaApuesta tipo,Usuario user, String idApuesta) {
		
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
