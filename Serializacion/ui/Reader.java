package ui; 

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Lector {
	public static void main(String[] args) {
		try {

			
			File file = new File("/home/runner/Serializacion/people.temp");
			FileInputStream fis = new FileInputStream(file); 
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); 

			int readBytes = 0;
			byte[] buffer = new byte[128]; 

			while( (readBytes = fis.read(buffer)) != -1){
				baos.write(buffer, 0, readBytes);
			}
			fis.close();
			baos.close();

			String text = baos.toString(StandardCharsets.UTF_8);
			System.out.println(text);


		} catch(Exception e){
			e.printStackTrace();
		}
	}
}