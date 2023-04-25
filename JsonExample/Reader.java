
import com.google.gson.Gson;
import model.Owner;
import model.Pet;

import java.io.*;
import java.util.ArrayList;

public class Reader {
    public static void main(String[] args) {
        try {

            File file = new File("array.json");
            System.out.println("Existe: "+file.exists());

            FileInputStream fis = new FileInputStream(file);
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String json = "";
            String line;
            while ( (line = reader.readLine()) != null ){
                json+=line;
            }
            fis.close();
            System.out.println(json);

            Gson gson = new Gson();
            Owner[] owners = gson.fromJson(json, Owner[].class);

            ArrayList<Owner> ownerArrayList = new ArrayList<>();
            for(Owner o : owners){

                ownerArrayList.add(o);
                System.out.println(o.getName());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
