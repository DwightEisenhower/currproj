public class UnderThirteenException extends Exception
{
    private int age;
    public UnderThirteenException(int age) {
        this.age = age;
    }
    
    public void getError() {
        System.out.println("Come back in "+(13-age)+" years");
    }
}