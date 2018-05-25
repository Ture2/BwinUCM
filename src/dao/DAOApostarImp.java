package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import actores.Usuario;
import apuestas.FactoriaApuesta;
import bbdd.BBDD;
import exceptions.ApuestaDoesntExistException;
import exceptions.UsuarioExistException;
import tao.TAOApuesta;
import tao.TAOUsuario;

public class DAOApostarImp implements DAOApostar {
	
	public DAOApostarImp(){}
	
	
	public void CrearApuesta(TAOApuesta apuesta) throws IOException, ApuestaDoesntExistException {
		if(this.LeerApuesta(apuesta) == null){
			FileWriter fw = new FileWriter("Apuestas.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = apuesta.getCantidadApuesta() + " " + apuesta.getTipo() + " " + apuesta.getUsuario() + " " + 
					apuesta.getIdApuesta();
			bw.write(linea);
			bw.newLine();
			bw.close();
		}else throw new UsuarioExistException("La apuesta ya existe");
	}


	public void BorrarApuesta(TAOApuesta apuesta) throws IOException {
		String line;
		File fich = new File("Apuestas.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		
		File fichTemp = new File("ApuestasTmp.txt");
		FileWriter fw = new FileWriter(fichTemp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			if(!palabra[0].equalsIgnoreCase(apuesta.getIdApuesta())){
				bw.write(line);
				bw.newLine();
			}
		}
		
		bw.close();
		br.close();
		
		fichTemp.renameTo(fich);
		fichTemp.delete();
	}


	public void ModificarApuesta(TAOApuesta apuesta) throws IOException {
		String line;
		File fich = new File("Apuestas.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		
		File fichTemp = new File("ApuestasTmp.txt");
		FileWriter fw = new FileWriter(fichTemp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			if(!palabra[0].equalsIgnoreCase(apuesta.getIdApuesta())){
				bw.write(line);
				bw.newLine();
			}else{
				line = apuesta.getCantidadApuesta() + " " + apuesta.getTipo() + " " + apuesta.getUsuario() + " " + 
						apuesta.getIdApuesta();
				bw.write(line);
				bw.newLine();
			}
		}
		
		bw.close();
		br.close();
		
		fichTemp.renameTo(fich);
		fichTemp.delete();
	}

	
	public TAOApuesta LeerApuesta(TAOApuesta apuesta) throws IOException, ApuestaDoesntExistException{
		Boolean find = false;
		TAOApuesta tao = null;
		File fich = new File("Apuestas.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while(!((line = br.readLine()) == null) && !find){
			String[] palabra = line.split(" ");
			if(palabra[0].equalsIgnoreCase(apuesta.getIdApuesta())){ 
				if(palabra[1].equalsIgnoreCase("GEP")){
					tao = new TAOApuesta(palabra[0], palabra[2], Integer.parseInt(palabra[3]),
							Integer.parseInt(palabra[4]), Integer.parseInt(palabra[5]), Integer.parseInt(palabra[6]), Integer.parseInt(palabra[7]));
					find = true;
				}else if(palabra[1].equalsIgnoreCase("WINFORMORE")){
					tao = new TAOApuesta(palabra[0], palabra[2], Integer.parseInt(palabra[3]), Integer.parseInt(palabra[4]));
					find = true;
				}else if(palabra[1].equalsIgnoreCase("TORNEO")){
					String[] l = new String[3];
					l[0] = palabra[4];
					l[1] = palabra[5];
					l[2] = palabra[6];
					tao = new TAOApuesta(palabra[0], palabra[2], Integer.parseInt(palabra[3]), l);
					find = true;
				}else throw new ApuestaDoesntExistException();
			}
		}
		br.close();
		return tao;
	}
	
	public TAOApuesta LeerUltimaApuesta() throws IOException{
		//Por defecto el id sera 1000
		TAOApuesta tao = new TAOApuesta("1000");
		File fich = new File("Apuestas.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while(line != null){
			String[] palabra = line.split(" ");
			tao.setIdApuesta(palabra[0]);
		}
		br.close();
		return tao;
	}

}
