package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class FileReader {
    private File myObj;
    private Scanner myReader;
    private ArrayList<String> readLines;
    public int planeRows;
    public int planeColumns;
    public int planeFirstClassRows;
    public int totalData;
    private HashTable<String,Passenger> passengers;
    private ArrayList<String> arrivals;


    public FileReader(String pathName) throws Exception{
        try {
            myObj = new File(pathName);
            myReader = new Scanner(myObj);
            readLines= new ArrayList();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                readLines.add(data);
                //System.out.println(data);
            }
            myReader.close();

            planeRows = Integer.parseInt(readLines.get(1).split(" ")[0]);
            planeColumns = columnCharToInt(readLines.get(2).charAt(0));
            planeFirstClassRows = Integer.parseInt(readLines.get(3).split(" ")[0]);

            passengers = new HashTable();
             totalData = planeRows*planeColumns;
            for(int k = 7; k<7+ totalData; k++){

                String[] info = readLines.get(k).split(",");
                int row=Integer.parseInt(info[2]);
                Passenger objPsngr;
                if (Integer.parseInt(info[2])<=planeFirstClassRows ){
                    int miles=Integer.parseInt(info[4]);
                    boolean older = Boolean.parseBoolean(info[5]);
                    boolean specialNeeds = Boolean.parseBoolean(info[6]);
                    boolean travelsWithBaby = Boolean.parseBoolean(info[7]);
                    objPsngr= new Passenger( info[0], info[1], row, info[3], miles, older, specialNeeds, travelsWithBaby);
//String name, String id,  int row, String column, int miles, boolean older, boolean specialNeeds, boolean travelsWithBaby

                }else objPsngr= new Passenger(info[0], info[1],row, info[3]);
                                            //String name, String id, int row, String column
                // System.out.printf("adding id(%s,%s) passenger(%s)\n", info[1], passengers.hash(info[1]), objPsngr.name);
                passengers.insert(info[1], objPsngr);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura de los datos.");
            e.printStackTrace();
        }
    }
    public void readArrivals(){
        arrivals = new ArrayList();
        int k = 1;
        for(int i = 9+ totalData; i<9+2* totalData; i++){
            String id = readLines.get(i);
            arrivals.add(id);
            passengers.search(id).setArrivalOrder(k);
            k++;
        }
    }
    public int columnCharToInt(char column){
        return  column -'A'+ 1;
    }
    public ArrayList<String> getReadLines() {
        return readLines;
    }
    public HashTable<String, Passenger> getPassengers() {
        return passengers;
    }
    public ArrayList<String> getArrivals() {
        return arrivals;
    }
    public String showPlainSpecifications() {
        return "Plane rows: "+ planeRows+ "  Plane columns: "+ planeColumns+"  Plane first class: "+ planeFirstClassRows;
    }
    public String showArrivals() {
        String arrv="Llegadas: ";
        for(int i = 0; i< totalData; i++){
            arrv+="\n "+(i+1)+". "+arrivals.get(i);
        }
        return arrv;
    }

    public void showPassengers() {
    }
}