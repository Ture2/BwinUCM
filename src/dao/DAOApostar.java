package dao;

import tao.TAOApuesta;

public interface DAOApostar {
	
	public void CrearApuesta(TAOApuesta apuesta);
	public void BorrarApuesta(TAOApuesta apuesta);
	public void ModificarApuesta(TAOApuesta apuesta);
	public void LeerApuesta(TAOApuesta apuesta);
	public void CrearTAO();
	
}
