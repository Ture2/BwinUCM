package dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import exceptions.ApuestaDoesntExistException;
import tao.TAOApuesta;

public interface DAOApostar {
	
	public void CrearApuesta(TAOApuesta apuesta) throws IOException, ApuestaDoesntExistException;
	public void BorrarApuesta(TAOApuesta apuesta) throws IOException;
	public void ModificarApuesta(TAOApuesta apuesta) throws IOException;
	public TAOApuesta LeerApuesta(TAOApuesta apuesta) throws FileNotFoundException, IOException, ApuestaDoesntExistException;
	
}
