package model; 

import model.Person;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Escritura {
	public static void main(String[] args) {
		ArrayList<Person>	people = new ArrayList<>(); 

		people.add(new Person("p1", 10));
		people.add(new Person("p2", 20));
		people.add(new Person("p3", 30));
		people.add(new Person("p4", 40));
		people.add(new Person("p5", 50));

		String text = ""; 
		for (Person p : people) {
			text += p.getName() + " " + p.getAge()+"\n"; 
		}
		
		System.out.println(text); 

		File file = new File("/home/runner/Serializacion/people.temp");

		try{

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(text.getBytes(StandardCharsets.UTF_8));
			fos.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();	
		}
		catch (IOException e) {
			e.printStackTrace();	
		}

	}
}