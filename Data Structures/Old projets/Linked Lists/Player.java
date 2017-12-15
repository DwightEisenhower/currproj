/** Look in the ReadMe for info on this project **/
/** LOOK BUT DON'T TOUCH **/

public class Player
{
    private final String name;
    private int wins;
    
    public Player(String name){
        this.name = name;
    }
    
    public String getname(){
        return(name);
    }
    
    public int getwins(){
        return(wins);
    }
    
    public void wins(){
        wins++;
    }
    
    public void takeTurn(){
        System.out.print(name + " takes their turn");
        if(Math.random() > 0.2){
            System.out.print(" and earns a win!");
            wins();
        }
        System.out.println();
    }
    
    public boolean equals(Player other){
        return(other.getname().equals(name));
    }
    
    public String toString(){
        return("Name: " + name + "; Wins: " + wins);
    }
}
