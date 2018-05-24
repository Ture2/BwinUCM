package apuestas;

import exceptions.ApuestaDoesntExistException;

public interface IFactoriaApuesta {
	public Apuesta crearApuesta(String tipo) throws ApuestaDoesntExistException;
}
