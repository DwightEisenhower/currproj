import java.util.*;
public class Backtracking
{
    public static void main(){
        
        boolean[][] path = {{true, true, true, true, true},
                            {true, false, false, false, true},
                            {true, true, true, true, true},
                            {true, false, true, true, false},
                            {true, true, false, true, true}
                        };
        easyPathways(path);
    }
    
    public static void easyPathways(boolean [][] path)
    {
        Pair[][] wPath = new Pair[path.length][path[0].length];
        for(int r = 0; r < path.length; r++)
            for(int c = 0; c < path[0].length; c++)
                wPath[r][c] = new Pair(r, c, path[r][c]);
        Stack<Pair> s = new Stack<>();
        s.push(wPath[0][0]);
        wPath[0][0].setChecked(true);
        int cRow = 0; int cCol = 0;
        while(!s.isEmpty()) {
            cRow = s.peek().row();
            cCol = s.peek().col();
            if(cRow == wPath.length-1 && cCol == wPath[0].length-1) {
                System.out.println(s);
                return;
            }
            if(cRow+1 != path.length)
                if(wPath[cRow+1][cCol].allowed() && !wPath[cRow+1][cCol].checked()) {
                    s.push(wPath[cRow+1][cCol]);
                    wPath[cRow+1][cCol].setChecked(true);
                    System.out.println("Going South to "+(cRow+1)+", "+cCol);
                    cRow++;
                }
            if(cCol+1 != path[0].length)
                if(wPath[cRow][cCol+1].allowed() && !wPath[cRow][cCol+1].checked()) {
                    s.push(wPath[cRow][cCol+1]);
                    wPath[cRow][cCol+1].setChecked(true);
                    System.out.println("Going East to "+(cRow)+", "+(cCol+1));
                    cCol++;
                }
            if((cCol+1 == path[0].length || !wPath[cRow][cCol+1].allowed() || wPath[cRow][cCol+1].checked())
            && cRow+1 == path.length || !wPath[cRow+1][cCol].allowed() || wPath[cRow+1][cCol].checked()) {
                s.pop();
                if(!s.isEmpty())
                    System.out.println("BACK to "+s.peek().row()+", "+s.peek().col());
            }
        }
        System.out.println("No path.");
    }
}
class Pair
{
    private final boolean allowed;
    private final int row,col;
    private boolean checked = false;
    public Pair(int row, int col, boolean al) {
        this.row = row;
        this.col = col;
        allowed = al;
    }
    
    public boolean allowed(){return allowed;}
    public int row(){return row;}
    public int col(){return col;}
    public boolean checked(){return checked;}
    
    public void setChecked(boolean nc){checked = nc;}
    
    public String toString() {
        return "row: "+row+" Col: "+col;
    }
}