import java.io.*;
public class Program
{
    private BufferedReader reader;
    private File file;
    public Program() {
        file = new File("/Documents/Programming/currproj/Writing to File");
        try {
            if(!file.exists())
                file.createNewFile();
            reader = new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException fnfe) {
            System.out.println("Uh-oh... file not found...");
            System.exit(0);
        } catch(IOException ioe) {
            System.out.println("Uh-oh... some dark IO magic broke this program...");
        }
    }
    
    
}