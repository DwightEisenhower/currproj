public class Computer implements Player {
    private String name;
    public Computer(int number) {
        name = "CPU"+number;
    }
    
    public String getName(){return name;}
    
    public int getMove() {
        return (int)(Math.random()*4+1);
    }
}