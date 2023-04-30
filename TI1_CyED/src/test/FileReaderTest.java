package test;
import junit.framework.TestCase;
import model.FileReader;

public class FileReaderTest extends TestCase{
    private FileReader fileReader;


    public void setUpScenario1() throws Exception{
        fileReader = new FileReader("Data.txt");
    }
}
