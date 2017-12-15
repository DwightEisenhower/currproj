import java.util.*;
import java.io.*;
public class Game {
    private ArrayList<Player> list;
    private BufferedReader reader;
    public static void main() {
        Game x = new Game();
        x.play();
    }
    
    public Game() {
        list = new ArrayList<Player>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        int CPUnumber = 0;
        System.out.println("Welcome to The Game!");
        while(go) {
            System.out.println("Human (true), Computer (false) or 'stop' to stop adding players?");
            try {
                String input = reader.readLine();
                if(input.toLowerCase().equals("stop"))
                    if(list.size() >= 2)
                        break;
                    else
                        System.out.println("You need at least 2 players to start the game.");
                else if(input.toLowerCase().equals("true")) {
                    System.out.println("What's the player's name?");
                    input = reader.readLine();
                    boolean success = false;
                    while(!success) {
                        try {
                            list.add(new Human(input));
                            success = true;
                        } catch(IllegalArgumentException iae) {
                            System.out.println("try again.");
                        }
                    }
                } else if(input.toLowerCase().equals("false")) {
                    list.add(new Computer(CPUnumber));
                    CPUnumber++;
                }
            } catch(IOException ioe) {
                ioe.printStackTrace();
                System.out.println("I dunno wth just happened but I don't really care...");
            }
            if(list.size() == 10)
                go = false;
        }
        try {
            reader.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            System.out.println("I dunno wth just happened but I don't really care...");
        }
        System.out.println("Now that the players have been chosen, let us begin!");
        System.out.println(list);
    }
    
    public void play() {
        ArrayList<Integer> tokenCount = new ArrayList<>(list.size());
        int tokens = (int)(Math.random()*51+25);
        int pnum = 0;
        System.out.println("There are "+tokens+" tokens this game.");
        while(tokens > 0) {
            System.out.println("It's player "+list.get(pnum).getName()+"'s turn.");
            Player temp = list.get(pnum);
            System.out.println("What's your move? (enter int 1-4)");
            int move = list.get(0).getMove();
            if(tokens - move < 0)
                System.out.println("Your move is valid but there are not enough tokens for it. Try again with a different number.");
            else {
                tokenCount.set(pnum, tokenCount.get(pnum)+move);
                tokens -= move;
            }
        }
        int smallest = 0;//smallest index
        for(int i = 0; i < tokenCount.size(); i++)
            if(tokenCount.get(i) < tokenCount.get(smallest))
                smallest = i;
        System.out.println("Player "+list.get(smallest)+" wins!");
        try {
            System.out.println("Do you wish to play again? Y/N");
            String temp = reader.readLine();
            if(temp.toUpperCase().equals("Y"))
                play();
            else
                System.exit(0);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}