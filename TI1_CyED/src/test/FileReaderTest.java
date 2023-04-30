package test;
import junit.framework.TestCase;
import model.FileReader;

public class FileReaderTest extends TestCase{
    private FileReader fileReader;


    public void setupStage1() throws Exception{
        fileReader = new FileReader("Data.txt");
        fileReader.readArrivals();
    }
    public void testShowPlaneSpecifications() throws Exception {
        setupStage1();
        assertEquals("Plane rows: 4  Plane columns: 4  Plane first class: 2", fileReader.showPlaneSpecifications());

    }
    public void testGet1Arrival() throws Exception {
        setupStage1();
        assertEquals("010", fileReader.get1Arrival(1));

    }
    public void testFileReader() throws Exception {
        setupStage1();
        assertEquals("/**** model.Passenger Database ****/", fileReader.getReadLine(6));
    }

}
