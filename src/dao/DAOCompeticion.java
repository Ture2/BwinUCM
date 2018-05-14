package dao;

import tao.TAOCompeticion;

public interface DAOCompeticion {
	
	public void CrearCompeticion(TAOCompeticion competicion);
	public void BorrarCompeticion(TAOCompeticion competicion);
	public void ModificarCompeticion(TAOCompeticion competicion);
	public void LeerCompeticion(TAOCompeticion competicion);
	public void CrearTAO();
}
