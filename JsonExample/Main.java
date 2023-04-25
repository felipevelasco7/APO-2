import model.Pet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        ArrayList<Owner> owners = new ArrayList<>();

        Pet p1 = new Pet("p1", 10);
        Pet p2 = new Pet("p2", 20);
        Pet p3 = new Pet("p3", 30);
        Pet p4 = new Pet("p4", 40);
        Pet p5 = new Pet("p5", 50);
        Pet p6 = new Pet("p6", 60);


        String json = gson.toJson(owners);
        System.out.println(json);

        try {
            FileOutputStream fos = new FileOutputStream(new File("array.json"));
            fos.write( json.getBytes(StandardCharsets.UTF_8) );
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}