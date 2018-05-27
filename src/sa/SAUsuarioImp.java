package sa;

import java.io.IOException;

import dao.DAOUsuarioImp;
import tao.TAOUsuario;

public class SAUsuarioImp implements SAUsuario {
	private DAOUsuarioImp daoUsuario;
	
	public SAUsuarioImp(){
		this.daoUsuario = new DAOUsuarioImp();
	}
	
	@Override
	public void BorrarUsuario(String nick, String pass, String correo) throws NumberFormatException, IOException {
		TAOUsuario taoNick = new TAOUsuario(nick, "", "", 0, "");
		daoUsuario.BorrarUsuario(taoNick);
	}


	@Override
	public boolean Login(String nick, String pass) {
		TAOUsuario taoNick = new TAOUsuario(nick, "", pass, 0, "");
		TAOUsuario taoUsuario;
		boolean login = false;
		try {
			taoUsuario = daoUsuario.LeerUsuario(taoNick);
			if(taoUsuario != null){
				taoUsuario.SetValidacion(true);
				if(taoUsuario != null){
					daoUsuario.ModificarUsuario(taoUsuario);
				}	
				login = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return login;
	}


	public void CerrarSesion(String nick){
		TAOUsuario taoNick = new TAOUsuario(nick, "", "", 0, "");
		TAOUsuario taoUsuario;
		try {
			taoUsuario = daoUsuario.LeerUsuario(taoNick);
			taoUsuario.SetValidacion(false);
			daoUsuario.ModificarUsuario(taoUsuario);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void CambiarContrasena(String nick, String oldPass, String newPass){
		TAOUsuario taoUsuario = new TAOUsuario(nick, "", "", 0, "");;
		try {
			taoUsuario = daoUsuario.LeerUsuario(taoUsuario);
			if(taoUsuario.GetPass().equalsIgnoreCase(oldPass)){
				taoUsuario.SetPass(newPass);
				daoUsuario.ModificarUsuario(taoUsuario);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean CrearUsuario(String id, String nombre, String pass, int dinero, String correo) {
		TAOUsuario tao = new TAOUsuario(nombre, pass, correo, 0, null);
		boolean exist = true;
		//Si es null significa que no esta y que se puede añadir
		try {
			if(daoUsuario.LeerUsuario(tao) == null){
				daoUsuario.CrearUsuario(tao);
			}else exist = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public boolean HacersePremium(String id) {
		TAOUsuario tao = new TAOUsuario(id);
		
		try {
			TAOUsuario taoNuevo = daoUsuario.LeerUsuario(tao);
			//Suponemos que conexion a paypal == true
			taoNuevo.setPremium(true);
			daoUsuario.ModificarUsuario(taoNuevo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ConfigurarDinero(String id, int cantidad, String accion){
		TAOUsuario tao = new TAOUsuario(id);
		TAOUsuario taoNuevo;
		try {
			taoNuevo = daoUsuario.LeerUsuario(tao);
			if(accion.equalsIgnoreCase("SacarDinero")){
				if((taoNuevo.getDinero() - cantidad) > 0)taoNuevo.setDinero(taoNuevo.getDinero() - cantidad);
				else return false;
			}else if(accion.equalsIgnoreCase("MeterDinero")){
				taoNuevo.setDinero(taoNuevo.getDinero() + cantidad);
			}
			daoUsuario.ModificarUsuario(taoNuevo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	
}
