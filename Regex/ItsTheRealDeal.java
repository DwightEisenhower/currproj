import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.io.*;
/**
 * Author: Danylo Mirin
 * Assignment: Regex
 * Date: February 1st, 2018
 * 
 * Error codes:
 * 1 = alice.txt not found
 * 2 = no reading permissions
 * 3 = unexpected IO exception
 */
public class ItsTheRealDeal {
    private File input = new File("alice.txt");
    private BufferedReader reader;
    private Pattern pat;
    private Matcher mat;
    private String regex = "";
    public ItsTheRealDeal() {
        try{
            if(!input.exists())
                throw new FileNotFoundException("alice.txt not found, aborting...");
            if(!input.canRead())
                throw new IOException("No reading permissions. Aborting...");
            reader = new BufferedReader(new FileReader(input));
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getCause());
            System.exit(1);
        } catch(IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getCause());
            System.exit(2);
        }
    }
    
    public static void main(String[] args) {
        ItsTheRealDeal proj = new ItsTheRealDeal();
        try {
            proj.one();
            proj.two();
            proj.three();
            proj.four();
            proj.five();
            proj.six();
            proj.seven();
            proj.eight();
            proj.nine();
        } catch(IOException ex) {
            ex.printStackTrace();
            System.exit(3);
        }
    }
    
    public void one() throws IOException {
        String line = "";
        int count = 0;
        regex = "\\bAlice\\b";
        while( (line = reader.readLine()) != null) {//O(n)
            pat = Pattern.compile(regex);
            mat = pat.matcher(line);
            while(mat.find())
                count++;
        }
        System.out.println("'Alice' appears "+count+" times.");
    }
    
    public void two() throws IOException {
        String line = "";
        ArrayList<Integer> lineNums = new ArrayList<>();
        regex = "Alice";
        int lineNumber = 0;
        while( (line = reader.readLine()) != null) {
            pat = Pattern.compile(regex);
            mat = pat.matcher(line);
            if(mat.find()) {
                System.out.println("match found");
                lineNums.add(lineNumber);
            }
            lineNumber++;
        }
        System.out.println("The following lines contain the name Alice: "+lineNums.toString());
    }
    
    public void three() throws IOException {
        String line = "";
        int count = 0;
        regex = "\\b\\w+'\\w\\b";
        while( (line = reader.readLine()) != null) {
            pat = Pattern.compile(regex);
            mat = pat.matcher(line);
            while(mat.find())
                count++;
        }
        System.out.println(count+" contractions and possessives");
    }
    
    public void four() throws IOException {
        
    }
    
    public void five() throws IOException {
        
    }
    
    public void six() throws IOException {
        
    }
    
    public void seven() throws IOException {
        
    }
    
    public void eight() throws IOException {
        
    }
    
    public void nine() throws IOException {
        
    }
    
    private ArrayList<String> readFromFile() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while( (line = reader.readLine()) != null)
            lines.add(line);
        return lines;
    }
}