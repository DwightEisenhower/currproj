import java.util.*;
public class MazeSolver {
    private Spot[][] maze;
    private int health;
    private Stack<Spot> stack;
    public MazeSolver(Spot[][] array, int hp) {
        maze = array;
        health = hp;
        stack = new Stack<>();
    }
    
    public static void main(String[] args) {
        Spot[][] path = {{new Spot(0,0,0), new Spot(0,1,0), new Spot(0,2,1), new Spot(0,3,2), new Spot(0,4,1)},
                         {new Spot(1,0,1), new Spot(1,1,0), new Spot(1,2,2), new Spot(1,3,0), new Spot(1,4,0)},
                         {new Spot(2,0,1), new Spot(2,1,0), new Spot(2,2,1), new Spot(2,3,1), new Spot(2,4,2)},
                         {new Spot(3,0,2), new Spot(3,1,1), new Spot(3,2,2), new Spot(3,3,0), new Spot(3,4,1)},
                         {new Spot(4,0,2), new Spot(4,1,1), new Spot(4,2,0), new Spot(4,3,2), new Spot(4,4,0)}
        };
        MazeSolver ms = new MazeSolver(path, 6);
        ms.getToSafety();
    }
    /*# Finish #*/
    public void getToSafety() {
        int healthLeft = health;
        Spot end = maze[maze.length-1][maze[0].length-1];
        stack.push(maze[0][0]);
        maze[0][0].check();
        int crow = 0; int ccol = 0;
        boolean moved;
        while(!stack.isEmpty()) {
            crow = stack.peek().row();
            ccol = stack.peek().col();
            moved = false;
            System.out.println("Location: "+crow+", "+ccol+"; health "+health);
            if(crow == end.row() && ccol == end.col()) {
                System.out.println(stack);
                return;
            }
            /**4 directional checks*/
            if(!moved && crow+1 < maze.length && canMove(maze[crow+1][ccol])) {
                moveTo(maze[crow+1][ccol]);
                maze[crow+1][ccol].check();
                moved = true;
            }
            if(!moved && ccol+1 < maze[0].length && canMove(maze[crow][ccol+1])) {
                moveTo(maze[crow][ccol+1]);
                maze[crow][ccol+1].check();
                moved = true;
            }
            if(!moved && crow-1 >= 0 && canMove(maze[crow-1][ccol])) {
                moveTo(maze[crow-1][ccol]);
                maze[crow-1][ccol].check();
                moved = true;
            }
            if(!moved && ccol-1 >= 0 && canMove(maze[crow][ccol-1])){
                moveTo(maze[crow][ccol-1]);
                maze[crow][ccol-1].check();
                moved = true;
            }
            if(!moved) {
                maze[crow][ccol].check();
                ctrlZ();
            }
        }
        System.out.println("Cannot get to the end with this setup and this health.");
    }
    
    private boolean canMove(Spot s) {
        if(s.checked())
            return false;
        else {
            switch(s.type()) {
                case 0:
                    return true;
                case 1:
                    if(health > 1)
                        return true;
                    break;
                case 2:
                    s.check();
                    return false;
            }
        }
        return false;
    }
    
    private void moveTo(Spot s) {//moves to a spot, O(1)
        if(s.type() == 1)
            health--;
        stack.push(s);
        System.out.println("Moving to: "+s.row()+", "+s.col());
    }
    
    private Spot ctrlZ() {//undoes the previous action, O(1)
        if(stack.peek().type() == 1)
            health++;
        return stack.pop();
    }
}
class Spot
{
    private final int type;
    private final int row;
    private final int col;
    private boolean checked;
    public Spot(int row, int col, int type) {
        this.type = type;
        this.row = row;
        this.col = col;
    }
    /*# Finish #*/
    public int row(){return row;}
    public int col(){return col;}
    public int type(){return type;}
    public boolean checked(){return checked;}
    
    public void check(){checked = true;}
    
    public boolean equals(Spot other) {
        return row == other.row() && col == other.col() && type == other.type();
    }
    
    public String toString() {
        return "Row: "+row+" Col: "+col;
    }
}