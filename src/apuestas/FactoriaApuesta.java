package apuestas;


import exceptions.ApuestaDoesntExistException;

public class FactoriaApuesta implements IFactoriaApuesta{	
	
	public FactoriaApuesta(){}
	
	@Override
	public Apuesta crearApuesta(String tipo) throws ApuestaDoesntExistException {
		if(tipo.equalsIgnoreCase("GEP")){
			return new Gep();
		}else if(tipo.equalsIgnoreCase("TOURNAMENT")){
			return new Torneo();
		}else if(tipo.equalsIgnoreCase("ALTERNATIVE")){
			return new ApuestaAlternativa();
		}else throw new ApuestaDoesntExistException();
	}
	
}

