package sa;

import java.io.IOException;
import java.util.ArrayList;

import apuestas.Apuesta;
import apuestas.FactoriaApuesta;
import exceptions.ApuestaDoesntExistException;
import tao.TAOCompeticion;

public interface SAApuestasCompeticiones {
	
	public Apuesta CrearApuestaUsuario(String tipoApuesta) throws ApuestaDoesntExistException;
	public void AccederApuesta(String apuesta);
	public void ModificarApuesta(String id_apuesta);
	public ArrayList<TAOCompeticion> VisualizarCompeticiones() throws IOException;
	public void EliminarApuesta(String id_apuesta) throws IOException;
	public void EliminarCompeticion(String id_competicion) throws IOException;
	public void Apostar(int cant_BwinCoins, String nick_usuario, String id_competicion, String tipo_competicion, int cuota, String[] pos) throws IOException, ApuestaDoesntExistException;
}
