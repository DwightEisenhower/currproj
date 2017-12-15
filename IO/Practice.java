import java.io.*;
public class Practice {
    public static void ex1() {
        try {
            int denom = 0;
            System.out.println(5/denom);
        } catch(ArithmeticException ex) {
            System.out.println("Dammit, you cannot enter 0!");
        }
    }
    
    public static void ex2() {
        try {
            int[] a = {1, 100, 3, 4};
            int i = 0;
            while(i < 10000) {
                System.out.println(5/a[i]);
                i++;
            }
            throw new IOException();
        } catch(ArithmeticException ex) {
            System.out.println("Dammit, you cannot have a 0 in the array!");
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Index doesn't exist");
        } catch(Exception ex) {
            System.out.println("I don't what you did but you did it.");
        } finally {
            System.out.println("Ich kann nicht, Kamerad...");
            return;
        }
    }
    
    public static void main() {
        // if(age < 13)
            // throw new UnderThirteenException(age);
    }
}