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
            String line;
            while( (line = reader.readLine()) != null)
                lines.add(line);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println(ex.getCause());
            System.exit(1);
        } catch(IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getCause());
            if(ex.getCause().equals("No reading permissions. Aborting..."))
                System.exit(2);
            else
                System.exit(3);
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
    
    public void two() {
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
    
    public void three() {
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
    
    public void four() {
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
    
    public void five() {
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
    
    public void six() {
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
    
    public void seven() {
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
    
    public void eight() {
        ArrayList<Integer> lineNums = new ArrayList<>();
        int count = 0;
        regex = "(?i)(\\b\\w+\\b).+\\1";
        pat = Pattern.compile(regex);
        for(int i = 0; i < lines.size(); i++ ) {
            mat = pat.matcher(lines.get(i));
            while(mat.find())
                count++;
            if(count >= 2)
                lineNums.add(i);
            else
                count = 0;
        }
        System.out.println("A word repeating 2+ times is found on line(s) "+lineNums.toString());
    }
    
    //I know that this solution is somewhat overcomplicated and doesn't fully work but I am out of ideas and out of time.
    public void nine() {
        class Character implements Comparable<Character> {
            public String name;
            public int mentions;
            public Character(String name, int mentions) {
                this.name = name;
                this.mentions = mentions;
            }
            
            @Override public int compareTo(Character other) {
                if(mentions > other.mentions) return 1;
                else if(mentions < other.mentions) return -1;
                else return 0;
            }
            
            public String toString() {
                return name+" mentioned "+mentions+" times.";
            }
        }
        ArrayList<String> names = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        regex = "\\b([A-Z]\\w{2,})\\b";
        pat = Pattern.compile(regex);
        for(int j = 0; j < lines.size(); j++ ) {
            mat = pat.matcher(lines.get(j));
        }
        for(int i = 1; i < mat.groupCount(); i++) {
            System.out.print(mat.group(i)+", ");
            if(!(map.get(mat.group(i)) == null)) 
                map.replace(mat.group(i), map.get(mat.group(i))+1);
            else
                map.put(mat.group(i),1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(String s : map.keySet())
            pq.add(new Character(s, map.get(s)));
        System.out.println(pq);
    }
}