public class main
{
    public static void main() {
        
    }
    
    public static void recursive(int x) {
        if(x == 4)
            return;
        else
            recursive(x+1);
    }
    /**
     * Commands stack one upon each other until the stack overflows
     * c() runs, ends, method d() takes its place
     * b()
     * a()
     * main()
     */
}
