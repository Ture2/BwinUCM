package dao;

import java.io.IOException;

import tao.TAOCompeticion;

public interface DAOCompeticion {
	
	public void CrearCompeticion(TAOCompeticion competicion) throws IOException;
	public void BorrarCompeticion(TAOCompeticion competicion) throws IOException;
	public void ModificarCompeticion(TAOCompeticion competicion) throws IOException;
	public TAOCompeticion LeerCompeticion(TAOCompeticion competicion) throws IOException;
}
