package dao;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import bbdd.BBDD;
import exceptions.CompeticionExistException;
import exceptions.UsuarioExistException;
import tao.TAOCompeticion;
import tao.TAOUsuario;

public class DAOCompeticionImp implements DAOCompeticion{
	
	public DAOCompeticionImp(){}
	
	
	
	public void CrearCompeticion(TAOCompeticion competicion) throws IOException, CompeticionExistException {
		if(this.LeerCompeticion(competicion) == null){
			FileWriter fw = new FileWriter("Competiciones.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = competicion.getId() + " " + competicion.getEquipoA() + " " + competicion.getEquipoB() + " " + 
					competicion.getFechaIni() + " " + competicion.getFechaFin() + " " + competicion.getCuotaGanaA() + " " + 
					competicion.getCuotaGanaB() + " " + competicion.getCuotaEmpate();
			bw.write(linea);
			bw.newLine();
			bw.close();
		}else throw new CompeticionExistException("La competicion ya existe");
	}

	
	public void BorrarCompeticion(TAOCompeticion competicion) throws IOException {
		String line;
		File fich = new File("Competiciones.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		
		File fichTemp = new File("CompeticionesTmp.txt");
		FileWriter fw = new FileWriter(fichTemp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			if(!palabra[0].equalsIgnoreCase(competicion.getId())){
				bw.write(line);
				bw.newLine();
			}
		}
		
		bw.close();
		br.close();
		
		fichTemp.renameTo(fich);
		fichTemp.delete();
		
	}


	public void ModificarCompeticion(TAOCompeticion competicion) throws IOException {
		String line;
		File fich = new File("Competiciones.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		
		File fichTemp = new File("CompeticionesTmp.txt");
		FileWriter fw = new FileWriter(fichTemp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			if(!palabra[0].equalsIgnoreCase(competicion.getId())){
				bw.write(line);
				bw.newLine();
			}else{
				line = competicion.getId() + " " + competicion.getEquipoA() + " " + competicion.getEquipoB() + " " + 
						competicion.getFechaIni() + " " + competicion.getFechaFin() + " " + competicion.getCuotaGanaA() + " " + 
						competicion.getCuotaGanaB() + " " + competicion.getCuotaEmpate();
				bw.write(line);
				bw.newLine();
			}
		}
		
		bw.close();
		br.close();
		
		fichTemp.renameTo(fich);
		fichTemp.delete();
		
	}


	public TAOCompeticion LeerCompeticion(TAOCompeticion competicion) throws IOException {
		Boolean find = false;
		TAOCompeticion tao = null;
		File fich = new File("Competiciones.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while(!((line = br.readLine()) == null) && !find){
			String[] palabra = line.split(" ");
			if(palabra[0].equalsIgnoreCase(competicion.getId())){ 
				tao = new TAOCompeticion(palabra[0], palabra[1], palabra[2], palabra[3],palabra[4], Integer.parseInt(palabra[5]),
						Integer.parseInt(palabra[6]), Integer.parseInt(palabra[7]));
				find = true;
			}
		}
		br.close();
		return tao;
		
	}

	public ArrayList<TAOCompeticion> LeerTodasCompeticiones() throws NumberFormatException, IOException{
		ArrayList<TAOCompeticion> listaTaos = new ArrayList<TAOCompeticion>();
		File fich = new File("Competiciones.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			listaTaos.add(new TAOCompeticion(palabra[0], palabra[1], palabra[2], palabra[3],palabra[4], Integer.parseInt(palabra[5]),
					Integer.parseInt(palabra[6]), Integer.parseInt(palabra[7])));  
		}
		br.close();
		return listaTaos;
	}

	
}
