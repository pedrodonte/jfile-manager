package info.pedrodonte.jfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FilePlainManager {
	
	public static File openFile(){
		JFrame window = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		int returnVal = fileChooser.showOpenDialog(window);
		if(returnVal==JFileChooser.APPROVE_OPTION){
			return fileChooser.getSelectedFile();
		}
		return null;
	}
	
	public static void writeFileString(String filename,String content){
		try {
		    FileWriter fw = new FileWriter(filename);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter salida = new PrintWriter(bw);
		    salida.println(content);
		    salida.close();
		}
		catch(IOException e) {
		  System.out.println("Error al escribir el Archivo");
		  e.printStackTrace();
		}
	}
	
	public static void writeFile(String filename,List<String> content){
		try {
		    FileWriter fw = new FileWriter(filename);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter salida = new PrintWriter(bw);
		    for (Iterator<String> iterator = content.iterator(); iterator.hasNext();) {
				String line = (String) iterator.next();
				salida.println(line);
			}
		    salida.close();
		}
		catch(java.io.IOException ioex) {
		  System.out.println("se presento el error: "+ioex.toString());
		}
	}
	
	public static List<String> readFile(String pathfile){
		List<String> list = new ArrayList<String>();
		try {
			  FileReader fr = new FileReader(pathfile);
			  BufferedReader entrada = new BufferedReader(fr);
			  String s;
			  
				while((s = entrada.readLine()) != null){
				  	  list.add(s);
				}
			entrada.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		return list;
	}
	
	public static boolean fileExists(String filename){
		 boolean exists = (new File(filename)).exists();
		 return exists;
	}
	
	public static long getSizeFile(String filename){
		File f = new File(filename);
		System.out.println(f.lastModified());
		return f.length();
	}
	
	public static boolean deleteFile(String filename){
		boolean success = (new File(filename)).delete();
		return success;
	}
	
	public static boolean renameFile(String oldname, String newname){
	    File file = new File("oldname");
	    File file2 = new File("newname");
	    boolean success = file.renameTo(file2);
	    return success;
	}
	
	@SuppressWarnings("deprecation")
	public static String generateNameFile(){
		Date d = new Date();
		String f,h,str=d.toLocaleString();
		String[] ar;
		ar=str.split(" ");
		f=ar[0];
		h=ar[1];
		ar=f.split("-");
		f=ar[0]+ar[1]+ar[2];
		ar=h.split(":");
		h=ar[0]+ar[1]+ar[2];
		return f+h+".csv";
	}
	
}