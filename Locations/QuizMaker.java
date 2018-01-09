import java.util.*;
import java.io.*;
/**System Exit Codes (would go in the readme but 1.I don't submit it; 2.no one reads it)
 * 1 = IO exception
 */
public class QuizMaker {
    private static BufferedReader reader;
    private static FileWriter writer;
    private static String[] ffl = new String[]{"A","B","C","D"};
    public static void main() {
        try {
            File directory = new File("/SMB/16085/hs2.lan.summit.k12.nj.us/students/16085/Documents/Programming/currproj/Locations/quizzes/");
            File output = new File("/SMB/16085/hs2.lan.summit.k12.nj.us/students/16085/Documents/Programming/currproj/Locations/quizzes/locations.txt");
            if(!directory.exists()) {
                directory.mkdir();
                output.createNewFile();
            }
            File input = new File("/SMB/16085/hs2.lan.summit.k12.nj.us/students/16085/Documents/Programming/currproj/Locations/states.txt");
            if(input.canRead() && output.canWrite())
                makeQuiz(input, output);
        } catch(FileNotFoundException ioe) {
            System.out.println("File not found");
            ioe.printStackTrace();
            System.exit(1);
        } catch(IOException ioe) {
            System.out.println("Unforseen IO exception in main()");
            ioe.printStackTrace();
            System.exit(1);
        }
    }
    
    public static void makeQuiz(File in, File out) {
        HashMap<Key, String> map = loadStateHash(in);
        List<Key> keys = new ArrayList<>(map.keySet());
        ArrayList<String> quizQuestions = new ArrayList<>();
        for(int i = 0; i < 50; i++) {
            String question = (i+1)+". The capital of ";
            String state = "";
            //Choose random state & remove it
            boolean valid = false;
            while(!valid) {
                int rand = random(0,keys.size());
                if(!keys.get(rand).used) {
                    state = keys.get(rand).str;
                    valid = true;
                    question += state+" is...\n";
                }
            }
            ArrayList<String> answers = new ArrayList<>(4);
            System.out.println(answers);
            answers.add(map.get(new Key(state)));//set the real answer to a random one from 1 to 4
            System.out.println(answers);
            while(answers.size() < 4)
                if(!keys.get(random(0,keys.size())).str.equals(state))
                    answers.add(map.get(keys.get(random(0,keys.size()))));
            System.out.println(answers);
            //Collections.shuffle(answers);
            while(!answers.isEmpty())
                question += answers.remove(0)+"\n";
            System.out.println(answers);
            quizQuestions.add(question);
        }
        writeToFile(out, quizQuestions);
    }
    
    private static HashMap loadStateHash(File in) {
        ArrayList<String> list = readFromFile(in);//odd index = state name, even index = capital
        if(list.isEmpty()) {
            System.out.println("states.txt is either empty or nonexistent");
        }
        HashMap<Key, String> map = new HashMap<Key, String>();
        while(!list.isEmpty())
            map.put(new Key(list.remove(0)), list.remove(0));
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
            System.out.println("Unforseen IO exception while reading from file");
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
            System.out.println("Unforseen IO exception while writing to file");
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
    public static class Key {
        public String str;
        public boolean used;
        public Key(String in) {
            str = in;
            used = false;
        }
    }
}