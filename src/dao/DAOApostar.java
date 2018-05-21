package dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import tao.TAOApuesta;

public interface DAOApostar {
	
	public void CrearApuesta(TAOApuesta apuesta) throws IOException;
	public void BorrarApuesta(TAOApuesta apuesta);
	public void ModificarApuesta(TAOApuesta apuesta);
	public TAOApuesta LeerApuesta(TAOApuesta apuesta) throws FileNotFoundException, IOException;
	
}
