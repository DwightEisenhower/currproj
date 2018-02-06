import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
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
    private ArrayList<String> lines;
    public ItsTheRealDeal() {
        try{
            lines = new ArrayList<>();
            if(!input.exists())
                throw new FileNotFoundException("alice.txt not found, aborting...");
            if(!input.canRead())
                throw new IOException("No reading permissions. Aborting...");
            reader = new BufferedReader(new FileReader(input));
            readFromFile();
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
        int count = 0;
        regex = "\\bAlice\\b";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(0));
            while(mat.find())
                count++;
        }
        System.out.println("'Alice' appears "+count+" times.");
    }
    
    public void two() throws IOException {
        ArrayList<Integer> lineNums = new ArrayList<>();
        regex = "Alice";
        pat = Pattern.compile(regex);
        int lineNumber = 0;
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            if(mat.find()) {
                lineNums.add(lineNumber);
            }
            lineNumber++;
        }
        System.out.println("The following lines contain the name Alice: "+lineNums.toString());
    }
    
    public void three() throws IOException {
        int count = 0;
        regex = "\\b\\w+'\\w\\b";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            while(mat.find())
                count++;
        }
        System.out.println(count+" contractions and possessives");
    }
    
    public void four() throws IOException {
        int count = 0;
        regex = "\\b[A-Z]+\\b";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            while(mat.find())
                count++;
        }
        System.out.println(count+" words in all caps");
    }
    
    public void five() throws IOException {
        int count = 0;
        regex = "\\b\\w{7}'?\\w\\b";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            while(mat.find())
                count++;
        }
        System.out.println(count+" 8 letter words");
    }
    
    public void six() throws IOException {
        int count = 0;
        regex = "\\b\\w{4}\\b\\s+\\b\\w{4}\\b";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            while(mat.find())
                count++;
        }
        System.out.println(count+" back-to-back 4 letter words");
    }
    
    public void seven() throws IOException {
        int count = 0;
        regex = "(\\b\\w+\\b).+\\1";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            while(mat.find())
                count++;
            if(count > 1) {
                System.out.println("Found a line with a repeating word.");
                return;
            } else
                count = 0;
        }
    }
    
    public void eight() throws IOException {
        ArrayList<Integer> lineNums = new ArrayList<>();
        int count = 0;
        regex = "((\\b\\w+\\b).+){2,}";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i).toLowerCase());
            while(mat.find())
                count++;
            if(count >= 2)
                lineNums.add(i);
            else
                count = 0;
        }
        System.out.println("A word repeating 2+ times is found on lines "+lineNums.toString());
    }
    
    public void nine() throws IOException {
        HashMap<String, Integer> characters = new HashMap<>();
        for(int i = 0; i < 9; i++) {
            int count = 0;
            switch(i) {
                case 0:
                    regex = "Alice";
                    break;
                case 1:
                    regex = "March Hare";
                    break;
                case 2:
                    regex = "Hatter";
                    break;
                case 3:
                    regex = "Dormouse";
                    break;
                case 4:
                    regex = "Time";
                    break;
                case 5:
                    regex = "Queen";
                    break;
                case 6:
                    regex = "Elsie";
                    break;
                case 7:
                    regex = "Lacie";
                    break;
                case 8:
                    regex = "Tillie";
                    break;
                default:
                    break;
            }
            
            pat = Pattern.compile(regex);
            for(int j = 0; j < lines.size(); j++ ) {
                mat = pat.matcher(lines.get(i));
                while(mat.find())
                    count++;
            }
            characters.put(regex, count);
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(String s : characters.keySet()) {
            pq.add(characters.get(s));
        }
        System.out.println(pq);
    }
    
    private void readFromFile() throws IOException {
        String line;
        while( (line = reader.readLine()) != null)
            lines.add(line);
    }
}