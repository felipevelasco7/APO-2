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

    public void testInsert() throws Exception {
        setupStage1();
        Passenger  p1  = new Passenger("Jimmy","1193",4, "B");
        try {
            hashTable.insert("1193",p1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void testSearch() throws Exception {
        setupStage1();
        Passenger p= (Passenger) hashTable.search("1193");
        String id= p.getId();
        assertEquals("1193",id );
    }

    public void testInsert2() throws Exception {
        setupStage1();
        Passenger  p1  = new Passenger("Jimmy","2340",4, "B",100, true,true,false);
        hashTable.insert("2340",p1);
        assertEquals(p1, hashTable.search("2340"));

    }


}
