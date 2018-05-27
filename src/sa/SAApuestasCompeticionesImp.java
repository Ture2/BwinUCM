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
		this.daoCompeticion = new DAOCompeticionImp();
		this.daoUsuario = new DAOUsuarioImp();
		this.daoApuesta = new DAOApostarImp();
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
		String id = this.daoApuesta.LeerUltimaApuesta().getIdApuesta();
		int idParser = Integer.parseInt(id) + 1;
		apuesta.setId("" + idParser);
		apuesta.setCuotaApuesta(cuota);
		apuesta.setCantidadApuesta(cant_BwinCoins);
		apuesta.setUser(nick_usuario);
		
		
		//Guardamos la apuesta
		
		if(tipo_competicion.equalsIgnoreCase("GEP")){
			TAOApuesta taoGEP = new TAOApuesta(apuesta.getId(), nick_usuario, apuesta.getCantidadApuesta(), apuesta.getCuotaApuesta()
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
	public String[] VisualizarCompeticiones(){
		String[] competiciones = new String[20];
		try {
			ArrayList<TAOCompeticion> lista = this.daoCompeticion.LeerTodasCompeticiones();
			for(int i = 0; i < lista.size(); i++){
				competiciones[i] = "\nId: " + lista.get(i).getId() + "  Equipo A: " + lista.get(i).getEquipoA() + "  Equipo B: " + lista.get(i).getEquipoB() 
						+ "\n Gana A: " + lista.get(i).getCuotaGanaA() + "\n Gana B: " + lista.get(i).getCuotaGanaB() + "\n Empate: " + lista.get(i).getCuotaEmpate();
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return competiciones;
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
