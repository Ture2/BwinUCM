package packagePrincipal;

import java.io.IOException;

import dao.DAOUsuarioImp;
import tao.TAOUsuario;

public class Main {

	public static void main(String[] args){
		/*DAOUsuarioImp dao = new DAOUsuarioImp();
		TAOUsuario user = new TAOUsuario();
		user.SetIdUser("Ture");
		user = dao.LeerUsuario(user);
		System.out.println(user.GetIdUser() + user.GetNombre() + user.getDinero() + user.GetPass() + user.GetCorreo());
		TAOUsuario modify = new TAOUsuario("Ture", "AquiAndomos", "segundanuevaPass", 3000,"albeture@ucm.es" );
		dao.ModificarUsuario(modify);
		user = dao.LeerUsuario(user);
		System.out.println(user.GetIdUser() + user.GetNombre() + user.getDinero() + user.GetPass() + user.GetCorreo());
		*/
		
		GUIFacadeSistema fachada = new GUIFacadeSistema();
		fachada.interfazLogin();
	}

}
