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
 * 4 = file creation failure
 */
public class Processor {
    private BufferedReader reader;
    private FileWriter writer;
    private ArrayList<String> lines = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private File input, output;
    public Processor() {
        try {
            input = new File("stats.csv");
            output = new File("adjustedStats.csv");
            if(!output.exists())
                output.createNewFile();
            readFromFile(input);
        } catch(FileNotFoundException ex) {
            ex.printStackTrace();
            end(1);
        } catch(IOException ex) {
            ex.printStackTrace();
            end(4);
        }
    }
    
    public static void main() {
        Processor p = new Processor();
        p.run();
    }
    
    public void run() {
        //Load players
        for(int i = 1; i < lines.size(); i++)
            players.add(breakdown(lines.get(i)));
        //Clean the list (merging 3b and HR is already done in the Player class)
        ArrayList<Player> temp = new ArrayList<>();
        while(!players.isEmpty()) {
            players.get(0).slg += 0.052;
            if(players.get(0).team.equals("KC") || players.get(0).team.equals("NYY") || players.get(0).avg < 0.275 || players.get(0).ab < 200)
                players.remove(0);
            else
                temp.add(players.remove(0));
        }
        players.clear();
        players.addAll(temp);
        Collections.sort(players);
        writeToFile(output);
    }
    
    private Player breakdown(String line) {
        String[] parts = line.split(",");
        ArrayList<Double> numChar = new ArrayList<>();
        String regex = "^\\-?\\d+?(\\.\\d+)?$";
        Pattern p = Pattern.compile(regex);
        Matcher m;
        for(int i = 1; i < parts.length; i++) {
            m = p.matcher(parts[i]);
            if(m.find()) {
                numChar.add(Double.parseDouble(parts[i]));
            }
        }
        return new Player(parts[1], parts[2], numChar);
    }
    
    private void readFromFile(File f) throws FileNotFoundException {
        //BufferedReader to read from file, reads & returns a string
        reader = new BufferedReader(new FileReader(input));
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
    
    private boolean writeToFile(File f) {
        if(players.isEmpty())
            return false;
        try {
            writer = new FileWriter(f);
            int temp = lines.get(0).indexOf("3B");
            writer.write(lines.get(0).substring(0, temp)+"PW"+lines.get(0).substring(temp+5)+"\n");
            int c = 1;
            while(!players.isEmpty()) {
                writer.write(c+","+players.remove(0).toString()+"\n");
                c++;
            }
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
    /*#Disclaimer: bad code ahead!*/
    public class Player implements Comparable<Player> {
        public String name, team;
        public int ab, r, h, twob, pw, rbi, sb, cs, bb, so;
        public double avg, obp, slg, ops, war;
        public Player(String name, String team, ArrayList<Double> chars) {
            this.name = name;
            this.team = team;
            //ints
            ab = (int) chars.get(0).doubleValue();
            r = (int) chars.get(1).doubleValue();
            h = (int) chars.get(2).doubleValue();
            twob = (int) chars.get(3).doubleValue();
            pw = (int) (chars.get(4)+chars.get(5));
            rbi = (int) chars.get(6).doubleValue();
            sb = (int) chars.get(7).doubleValue();
            cs = (int) chars.get(8).doubleValue();
            bb = (int) chars.get(9).doubleValue();
            so = (int) chars.get(10).doubleValue();
            //doubles
            avg = chars.get(11);
            obp = chars.get(12);
            slg = chars.get(13);
            ops = chars.get(14);
            war = chars.get(15);
        }
        
        public int compareTo(Player other) {
            if(other.avg > avg) return -1;
            else if(other.avg < avg) return 1;
            else return 0;
        }
        
        public String toString() {
            String coma = ",";
            return name+coma+team+coma+ab+coma+r+coma+h+coma+twob+coma+pw+coma+rbi+coma+sb+coma+cs+coma+bb+coma+so+coma+avg+coma+obp+coma+slg+coma+ops+coma+war;
        }
    }
}