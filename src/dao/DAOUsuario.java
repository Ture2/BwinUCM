package dao;

import tao.TAOUsuario;

public interface DAOUsuario {
	
	public void CrearUsuario(TAOUsuario Usuario);
	public void BorrarUsuario(TAOUsuario Usuario);
	public void ModificarUsuario(TAOUsuario Usuario);
	public void LeerUsuario(TAOUsuario Usuario);
	public void CrearTAO();

}
