package sa;

import java.io.IOException;
import java.util.ArrayList;

import apuestas.Apuesta;
import apuestas.FactoriaApuesta;
import dao.DAOApostarImp;
import dao.DAOCompeticion;
import dao.DAOCompeticionImp;
import dao.DAOUsuarioImp;
import exceptions.ApuestaDoesntExistException;
import tao.TAOApuesta;
import tao.TAOCompeticion;
import tao.TAOUsuario;

public class SAApuestasCompeticionesImp implements SAApuestasCompeticiones{
	private DAOCompeticionImp daoCompeticion;
	private DAOApostarImp daoApuesta;
	private DAOUsuarioImp daoUsuario;
	private FactoriaApuesta factory_apuesta;
	
	public SAApuestasCompeticionesImp(){
		this.factory_apuesta = new FactoriaApuesta();
	}
	
	
	//Operaciones Sobre Apuestas
	@Override
	public Apuesta CrearApuestaUsuario(String tipoApuesta) throws ApuestaDoesntExistException {
		return this.factory_apuesta.crearApuesta(tipoApuesta);
	}

	@Override
	public void Apostar(int cant_BwinCoins, String nick_usuario, String id_competicion, String tipo_competicion, int cuota) throws IOException, ApuestaDoesntExistException{
		// Creamos una apuesta
		Apuesta apuesta = this.CrearApuestaUsuario(tipo_competicion);
		
		//Buscamos la competicion que nos ha dicho el usuario
		TAOCompeticion tao = new TAOCompeticion(id_competicion);
		tao = this.daoCompeticion.LeerCompeticion(tao);
		
		//Introducimos la competicion y el usuario
		apuesta.setId(this.generateIDApuesta().getIdApuesta());
		apuesta.setCuotaApuesta(cuota);
		apuesta.setCantidadApuesta(cant_BwinCoins);
		apuesta.setUser(nick_usuario);
		
		//Guardamos la apuesta y decrementamos el dinero del usuario
		TAOUsuario taoUsuario = daoUsuario.LeerUsuario(new TAOUsuario(nick_usuario));
		taoUsuario.setDinero(taoUsuario.getDinero() - cant_BwinCoins);
		daoUsuario.ModificarUsuario(taoUsuario);
		
		TAOApuesta taoApuesta = new TAOApuesta(apuesta.getId(), tipo_competicion, apuesta.getUser(), apuesta.getCantidadApuesta());
		daoApuesta.CrearApuesta(taoApuesta);
	}
	
	@Override
	public void AccederApuesta(String id_apuesta) {
		
		
	}

	@Override
	public void ModificarApuesta(String id_apuesta) {
		
		
	}

	@Override
	public void EliminarApuesta(String id_apuesta) throws IOException {
		TAOApuesta tao = new TAOApuesta(id_apuesta);
		this.daoApuesta.BorrarApuesta(tao);
	}

	
	public TAOApuesta generateIDApuesta() throws IOException{
		return this.daoApuesta.LeerUltimaApuesta();
	}
	
	
	//Operaciones sobre Competiciones
	@Override
	public ArrayList<TAOCompeticion> VisualizarCompeticiones() throws IOException {
		return this.daoCompeticion.LeerTodasCompeticiones();
	}

	@Override
	public void EliminarCompeticion(String id_competicion) throws IOException {
		TAOCompeticion tao = new TAOCompeticion(id_competicion);
		this.daoCompeticion.BorrarCompeticion(tao);
	}
	
	

}
