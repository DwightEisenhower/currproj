import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
public class Program
{
    private BufferedReader filereader;
    private BufferedReader consolereader;
    private File file;
    public Program() {
        file = new File("/Documents/Programming/currproj/Writing to File");
        try {
            if(!file.exists())
                file.createNewFile();
            filereader = new BufferedReader(new FileReader(file));
            consolereader = new BufferedReader(new InputStreamReader(System.in));
        } catch(FileNotFoundException fnfe) {
            System.out.println("Uh-oh... file not found...");
            System.exit(0);
        } catch(IOException ioe) {
            System.out.println("Uh-oh... some dark IO magic broke this program...");
        }
    }
    
    public static void main(String[] args) {
        Program p = new Program();
        p.run();
    }
    
    public void run() {
        System.out.println("Welcome! Login or register?");
        boolean stop = false;
        ArrayList<String> lines = new ArrayList<String>();
        while(!stop) {
            try {
                String input = consolereader.readLine();
                if(input.toLowerCase().equals("login")) {
                    ArrayList<String> temp = readFromFile();
                    if(lines.isEmpty() || !lines.contains(temp.get(temp.size()-1)))
                        lines = temp;
                    HashMap<String, String> map = new HashMap<>();
                    System.out.println("Please type your username as is, it's case sensitive.");
                    input = consolereader.readLine();
                    if(map.containsKey(input)) {
                        System.out.println("Found you! Now type your password carefully, it's case sensitive");
                        input = consolereader.readLine();
                    }
                } else if(input.toLowerCase().equals("register")) {
                    
                }
            } catch(FileNotFoundException fnfe) {
                fnfe.printStackTrace();
                System.out.println("smth went terribly wrong...");
                System.exit(0);
            } catch(IOException ioe) {
                System.out.println("Uh-oh... some dark IO magic broke this program...");
                System.exit(0);
            }
        }
    }
    
    private void hash(ArrayList<String> list, HashMap<String, String> hashmap) {
        if(hashmap.isEmpty())
            while(!list.isEmpty())
                hashmap.put(list.get(0).split("=")[0], list.get(0).split("=")[1]);
    }
    
    private ArrayList<String> readFromFile() throws FileNotFoundException {
        //BufferedReader to read from file, reads & returns a string
        ArrayList<String> lines = new ArrayList<String>();
        try {
            String line;
            while ((line = filereader.readLine()) != null)
                lines.add(line);
            filereader.close();
        } catch(IOException ioe) {
            System.out.println("Uh-oh... some dark IO magic broke this program...");
            System.exit(0);
        }
        return lines;
    }
}