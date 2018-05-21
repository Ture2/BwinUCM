package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import tao.TAOUsuario;
import exceptions.UsuarioExistException;

public class DAOUsuarioImp implements DAOUsuario {
	
	
	public DAOUsuarioImp(){}
	
	@Override
	public void CrearUsuario(TAOUsuario usuario) throws IOException {
		if(this.LeerUsuario(usuario) == null){
			FileWriter fw = new FileWriter("Usuarios.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			String linea = usuario.GetIdUser() + " " + usuario.GetNombre() + " " + usuario.GetPass() + " " + 
					usuario.getDinero() + " " + usuario.GetCorreo();
			bw.write(linea);
			bw.newLine();
			bw.close();
		}else throw new UsuarioExistException("El usuario ya existe.");
	}

	@Override
	public void BorrarUsuario(TAOUsuario usuario) throws NumberFormatException, IOException {
		String line;
		File fich = new File("Usuarios.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		
		File fichTemp = new File("UsuariosTmp.txt");
		FileWriter fw = new FileWriter(fichTemp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			if(!palabra[0].equalsIgnoreCase(usuario.GetIdUser())){
				bw.write(line);
				bw.newLine();
			}
		}
		
		bw.close();
		br.close();
		
		fichTemp.renameTo(fich);
		fichTemp.delete();
		
	}

	@Override
	public void ModificarUsuario(TAOUsuario usuario) throws IOException {
		String line;
		File fich = new File("Usuarios.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		
		File fichTemp = new File("UsuariosTmp.txt");
		FileWriter fw = new FileWriter(fichTemp, true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(!((line = br.readLine()) == null)){
			String[] palabra = line.split(" ");
			if(!palabra[0].equalsIgnoreCase(usuario.GetIdUser())){
				bw.write(line);
				bw.newLine();
			}else{
				line = usuario.GetIdUser() + " " + usuario.GetNombre() + " "  + usuario.GetPass() 
					+ " " + usuario.getDinero() + " " + usuario.GetCorreo();
				bw.write(line);
				bw.newLine();
			}
		}
		
		bw.close();
		br.close();
		
		fichTemp.renameTo(fich);
		fichTemp.delete();
		
	}

	@Override
	public TAOUsuario LeerUsuario(TAOUsuario usuario) throws IOException {
		Boolean find = false;
		TAOUsuario tao = null;
		File fich = new File("Usuarios.txt");
		FileReader fr = new FileReader(fich);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while(!((line = br.readLine()) == null) && !find){
			String[] palabra = line.split(" ");
			if(palabra[0].equalsIgnoreCase(usuario.GetIdUser())){ 
				tao = new TAOUsuario(palabra[0], palabra[1], palabra[2], Integer.parseInt(palabra[3]), palabra[4]);
				find = true;
			}
		}
		br.close();
		return tao;
	}

	
}
