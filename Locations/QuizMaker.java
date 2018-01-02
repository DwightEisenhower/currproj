import java.util.*;
import java.io.*;
public class QuizMaker {
    private static BufferedReader reader;
    private static FileWriter writer;
    public static void main() {
        File output = new File("locations.txt");
        File input = new File("states.txt");
        makeQuiz(input, output);
    }
    
    public static void makeQuiz(File in, File out) {
        HashMap<String, String> map = loadStateHash(in);
        
    }
    
    private static HashMap<String, String> loadStateHash(File in) {
        ArrayList<String> list = readFromFile(in);//odd index = state name, even index = capital
        if(list.isEmpty()) {
            System.out.println("states.txt is either empty or nonexistent");
        }
        HashMap<String, String> map = new HashMap<String, String>();
        while(!list.isEmpty())
            map.put(list.remove(0), list.remove(0));
        return map;
    }
    
    private static ArrayList<String> readFromFile(File file) {
        if(!file.exists() || !file.canRead())
            return null;
        try {
            reader = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<>();
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
            reader.close();
            return lines;
        } catch(IOException ioe) {
            System.out.println("Unforseen IO exception...");
            return null;
        }
    }
    
    private static boolean writeToFile(File f, ArrayList<String> lines) {
        if(lines.isEmpty() || !f.exists() || !f.canWrite())
            return false;
        try {
            writer = new FileWriter(f);
            while(!lines.isEmpty())
                writer.write(lines.remove(0));
            writer.flush();
            writer.close();
            return true;
        } catch(IOException ex) {
            System.out.println("Unforseen IO exception...");
            return false;
        }
    }
}