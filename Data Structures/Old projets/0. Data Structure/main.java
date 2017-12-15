public class main
{
    public static void main() {
        DataStructure x = new DataStructure();
        x.add(new Integer(5));
        x.add(new Integer(2));
        x.add(new Integer(3));
        x.add(new Integer(7));
        x.add(new Integer(6));
        x.add(new Integer(4));
        
        System.out.println(x);
        System.out.println(x.contains(new Integer(4)));
    }
}