package dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import tao.TAOUsuario;

public interface DAOUsuario {
	
	public void CrearUsuario(TAOUsuario Usuario) throws IOException;
	public void BorrarUsuario(TAOUsuario Usuario) throws FileNotFoundException, NumberFormatException, IOException;
	public void ModificarUsuario(TAOUsuario Usuario) throws IOException;
	public TAOUsuario LeerUsuario(TAOUsuario Usuario) throws FileNotFoundException, IOException;

}
