package exceptions;

public class UsuarioExistException extends RuntimeException {

	public UsuarioExistException(String msg){
		super(msg);
	}
}
