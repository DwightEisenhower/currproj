import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * Baseball stat processor
 * @Author Danylo Mirin
 * @Date 12 February 2018
 * @Copyright 2018
 * 
 * @Error codes
 * 1 = stats.csv nonexistent
 * 2 = reading failure
 * 3 = writing failure
 */
public class Processor {
    private BufferedReader reader;
    private FileWriter writer;
    private ArrayList<String> lines;
    private File file;
    public Processor() {
        try {
            file = new File("stats.csv");
            readFromFile(file);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
            end(1);
        }
    }
    
    public static void main() {
        Processor p = new Processor();
        p.run();
    }
    
    public void run() {
        
    }
    
    private boolean breakdown(String line) {
        
        return true;
    }
    
    private void readFromFile(File f) throws FileNotFoundException {
        //BufferedReader to read from file, reads & returns a string
        reader = new BufferedReader(new FileReader(file));
        lines = new ArrayList<String>();
        int index = 0;
        try {
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
            end(2);
        }
    }
    
    private boolean writeToFile(File f, ArrayList<String> lines) {
        if(lines.isEmpty())
            return false;
        try {
            writer = new FileWriter(f);
            while(!lines.isEmpty())
                writer.write(lines.remove(0));
            writer.flush();
            writer.close();
            return true;
        } catch(IOException ex) {
            ex.printStackTrace();
            end(3);
            return false;//needs to be here for the compiler but never runs because the system shuts down prior
        }
    }
    
    private void end(int code) {
        System.out.println("System failure. Code "+code);
        System.exit(code);
    }
    public class Player {
        private String name, team;
        private int ab, r, h, twob, threeb, hr, rbi, sb, cs;
    }
}