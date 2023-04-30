package test;
import junit.framework.TestCase;
import model.HashTable;
import model.Passenger;

public class HashTableTest extends TestCase{
    private HashTable hashTable;


    public void setupStage1() throws Exception {
        hashTable = new HashTable();
        Passenger p1 = new Passenger("Lucas","1193",2, "A",200, false,true,false);
        hashTable.insert("1193",p1);
        Passenger  p2  = new Passenger("Julian","2143",5, "A");
        hashTable.insert("2143",p2);
        Passenger  p3  = new Passenger("Rodrigo","5493",16, "C");
        hashTable.insert("5493",p3);
    }



}
