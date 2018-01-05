import java.util.*;
import java.io.*;
/**Error Codes (would go in the readme but 1. I don't submit it 2. no one reads it)
 * 1 = IO exception
 */
public class QuizMaker {
    private static BufferedReader reader;
    private static FileWriter writer;
    private static Random rand = new Random();
    private static String[] ffl = new String[]{"A","B","C","D"};
    public static void main() {
        File output = new File("/SMB/16085/hs2.lan.summit.k12.nj.us/students/16085/Documents/Programming/currproj/Locations/quizzes/locations.txt");
        try {
            if(!output.exists()) {
                output.mkdir();
                output.createNewFile();
            }
            File input = new File("/SMB/16085/hs2.lan.summit.k12.nj.us/students/16085/Documents/Programming/currproj/Locations/states.txt");
            if(input.canRead() && output.canWrite())
                makeQuiz(input, output);
        } catch(IOException ioe) {
            System.out.println("Unforseen IO exception...");
            ioe.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void makeQuiz(File in, File out) {
        HashMap<String, String> map = loadStateHash(in);
        List<String> keys = new ArrayList<>(map.keySet());
        rand = new Random();
        ArrayList<String> quizQuestions = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            String question = (i+1)+". The capital of ";
            String state = keys.remove(rand.nextInt(keys.size()));//Choose random state & remove it
            String[] answers = new String[4];
            answers[rand.nextInt(4)] = map.get(state);//set the real answer to a random one from 1 to 4
            question += state+" is...\n";
            for(int j = 0; j < 4; j++)
                if(answers[j] == null && !keys.isEmpty())
                    answers[j] = map.get(keys.get(random(0,keys.size())));
            for(int j = 0; j < 4; j++)
                question += answers[j]+"\n";
            quizQuestions.add(question);
        }
        writeToFile(out, quizQuestions);
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
            ioe.printStackTrace();
            System.exit(1);
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
        } catch(IOException ioe) {
            System.out.println("Unforseen IO exception...");
            ioe.printStackTrace();
            System.exit(1);
            return false;
        }
    }
    
    private static int random(int min, int max) {
        return (int)(Math.random()*max+min);
    }
    
    private static void print(Object o) {
        System.out.println(o);
    }
}