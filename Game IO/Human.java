import java.io.*;
import java.util.*;
public class Human implements Player {
    private String name;
    public Human(String name) throws IllegalArgumentException {
        try{
            int num = Integer.parseInt(name.substring(0,1));
            throw new IllegalArgumentException("Player name cannot start with a number. Please retry.");
        } catch(NumberFormatException ex) {
            if(name.contains(" ") || name.contains("\n"))
                System.out.println("No spaces or combinations that will mess with formatting.");
            else
                this.name = name;
        }
    }
    
    public String getName(){return name;}
    public int getMove() {
        System.out.println("Your turn. Type a number between 1 and 4 inclusive: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            int answer = Integer.parseInt(input);
            if(answer >= 1 && answer <= 4)
                return answer;
            else {
                System.out.println("Number given doesn't fit into 1 <= x <= 4. Try again.");
                return getMove();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("I dunno wth just happened but I don't really care...");
            return 0;
        } catch(NumberFormatException nfe) {
            System.out.println("Not a number. Try again.");
            return getMove();
        }
    }
}