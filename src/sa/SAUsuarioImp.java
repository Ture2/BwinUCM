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
	public void Login(String nick, String pass) {
		TAOUsuario taoNick = new TAOUsuario(nick, "", pass, 0, "");
		TAOUsuario taoUsuario = daoUsuario.LeerUsuario(taoNick);
		taoUsuario.SetValidacion(true);
		if(taoUsuario != null){
			daoUsuario.ModificarUsuario(taoUsuario);
		}	
	}


	public void CerrarSesion(String nick) {
		TAOUsuario taoNick = new TAOUsuario(nick, "", "", 0, "");
		TAOUsuario taoUsuario = daoUsuario.LeerUsuario(taoNick);
		taoUsuario.SetValidacion(false);
		daoUsuario.ModificarUsuario(taoUsuario);
	}

	public void CambiarContrasena(String nick, String oldPass, String newPass) {
		TAOUsuario taoNick = new TAOUsuario(nick, "", "", 0, "");
		TAOUsuario taoUsuario = daoUsuario.LeerUsuario(taoNick);
		if(taoUsuario.GetPass().equalsIgnoreCase(oldPass)){
			taoUsuario.SetPass(newPass);
			daoUsuario.ModificarUsuario(taoUsuario);
		}
	}

	@Override
	public boolean CrearUsuario(String id, String nombre, String pass, int dinero, String correo) throws IOException {
		TAOUsuario tao = new TAOUsuario(nombre, pass, correo, 0, null);
		boolean exist = true;
		//Si es null significa que no esta y que se puede añadir
		if(daoUsuario.LeerUsuario(tao) == null){
			daoUsuario.CrearUsuario(tao);
		}else exist = false;
		return exist;
	}

}
