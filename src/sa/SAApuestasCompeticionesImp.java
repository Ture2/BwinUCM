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
	public void Apostar(int cant_BwinCoins, String nick_usuario, String id_competicion, String tipo_competicion, int cuota, String[] pos) {
		// Creamos una apuesta
		Apuesta apuesta;
		try {
			apuesta = this.CrearApuestaUsuario(tipo_competicion);
		
		
		//Buscamos la competicion que nos ha dicho el usuario
		TAOCompeticion tao = new TAOCompeticion(id_competicion);
		tao = this.daoCompeticion.LeerCompeticion(tao);
		
		//Introducimos la competicion y el usuario
		apuesta.setId(this.daoApuesta.LeerUltimaApuesta().getIdApuesta() + 1);
		apuesta.setCuotaApuesta(cuota);
		apuesta.setCantidadApuesta(cant_BwinCoins);
		apuesta.setUser(nick_usuario);
		
		
		//Guardamos la apuesta
		
		if(tipo_competicion.equalsIgnoreCase("GEP")){
			TAOApuesta taoGEP = new TAOApuesta(apuesta.getId(), nick_usuario, apuesta.getCantidadApuesta(),apuesta.getCuotaApuesta()
					,tao.getCuotaGanaA(), tao.getCuotaGanaB(), tao.getCuotaEmpate());
			daoApuesta.CrearApuesta(taoGEP);
		}
		
		if(tipo_competicion.equalsIgnoreCase("WINFORMORE")){
			TAOApuesta taoWFM = new TAOApuesta(apuesta.getId(), nick_usuario, apuesta.getCantidadApuesta(), apuesta.getCuotaApuesta());
			daoApuesta.CrearApuesta(taoWFM);
		}
		
		if(tipo_competicion.equalsIgnoreCase("TOURNAMENT")){
			TAOApuesta taoTMT = new TAOApuesta(apuesta.getId(), nick_usuario, apuesta.getCantidadApuesta(), pos);
			daoApuesta.CrearApuesta(taoTMT);
		}
		//decrementamos el dinero del usuario
		TAOUsuario taoUsuario = daoUsuario.LeerUsuario(new TAOUsuario(nick_usuario));
		taoUsuario.setDinero(taoUsuario.getDinero() - cant_BwinCoins);
		daoUsuario.ModificarUsuario(taoUsuario);
		} catch (ApuestaDoesntExistException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void AccederApuesta(String id_apuesta) {}

	@Override
	public void ModificarApuesta(String id_apuesta) {}

	@Override
	public void EliminarApuesta(String id_apuesta) {
		TAOApuesta tao = new TAOApuesta(id_apuesta);
		try {
			this.daoApuesta.BorrarApuesta(tao);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Operaciones sobre Competiciones
	@SuppressWarnings("finally")
	@Override
	public ArrayList<TAOCompeticion> VisualizarCompeticiones(){
		try {
			return this.daoCompeticion.LeerTodasCompeticiones();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			return null;
		}
	}

	@Override
	public void EliminarCompeticion(String id_competicion){
		TAOCompeticion tao = new TAOCompeticion(id_competicion);
		try {
			this.daoCompeticion.BorrarCompeticion(tao);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
