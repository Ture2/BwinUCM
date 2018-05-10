package packagePrincipal;

public interface DAOCompeticion {
	public TAOCompeticion Competicion = null;

	public void CrearCompeticion(TAOCompeticion competicion);
	public void BorrarCompeticion(TAOCompeticion competicion);
	public void ModificarCompeticion(TAOCompeticion competicion);
	public void LeerCompeticion(TAOCompeticion competicion);
	public void CrearTAO();
}
