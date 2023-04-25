package ui; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {


    /**
      Ubuntu (linux) -> /usr/bin/jvm/
      MacOs (unix)  -> /user/home/documents
      Windows -> C:\\Users\\user\\Documents

      tenga en cuenta que los espacios son caracteres especiales 
    */
    
		// get folder path 
		String path = "/home/runner/Serializacion"; 
		File folder = new File(path); 

		// referencias una carpeta 
		// listar una carpeta 
		String[] files = folder.list(); 
		for (String name : files) {
			System.out.println(name);
		}

		// referenciar un archivo 
		File archivo = new File("/home/runner/Serializacion/filetest.txt"); 
		System.out.println(archivo.exists());

		try {

			// get a input file 
			FileInputStream fis = new FileInputStream(archivo); 

			// buffer reader 
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis)); 
			String line; 

			while ( (line = reader.readLine()) != null) {
				// print lines in a file 
				System.out.println(line);
				
			}
			fis.close();

		} catch(Exception e){
			e.printStackTrace();
		}

	}
}