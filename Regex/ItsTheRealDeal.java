import java.util.regex.Pattern;
import java.util.regex.Matcher;
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
        proj.one();
        proj.two();
        proj.three();
        proj.four();
        proj.five();
        proj.six();
        proj.seven();
        proj.eight();
        proj.nine();
    }
    
    public void one() {
        try {
            String line = "";
            int count = 0;
            while( (line = reader.readLine()) != null) {//O(n)
                regex = "\\bAlice\\b";
                pat = Pattern.compile(regex);
                mat = pat.matcher(line);
                if(mat.find())
                    count++;
            }
        } catch(IOException ex) {
            ex.printStackTrace();
            System.exit(3);
        }
    }
    
    public void two() {
        
    }
    
    public void three() {
        
    }
    
    public void four() {
        
    }
    
    public void five() {
        
    }
    
    public void six() {
        
    }
    
    public void seven() {
        
    }
    
    public void eight() {
        
    }
    
    public void nine() {
        
    }
}