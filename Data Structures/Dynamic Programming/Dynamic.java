import java.util.*;
public class Dynamic
{
    public static void main(String[] args) {
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(30);
        coins.add(50);
        coins.add(15);
        coins.add(10);
        coins.add(80);
        coins.add(55);
        maxDonations(coins);
    }
    
    public static void f(int value) {
        ArrayList<Integer> answers = new ArrayList<>(value + 1);
        answers.add(0);
        answers.add(1);
        for(int i = 2; i <= value; i++) {
            answers.add(answers.get(i-1) + answers.get(i-2));
        }
        System.out.println(answers.get(answers.size()-1));
    }
    
    public static void fewestCoins(int amount, ArrayList<Integer> coins) {
        ArrayList<Integer> answers = new ArrayList<>(amount + 1);
        answers.add(0); //add simplest example
        for( int i = 1; i < amount + 1; i ++) {
            int smallest = Integer.MAX_VALUE;
            for(int c = 0; c < coins.size(); c ++) {
                if(i-coins.get(c) >= 0 && answers.get(i-coins.get(c)) < smallest)
                    smallest = answers.get(i - coins.get(c));
            }
            answers.add(smallest + 1);
        }
        System.out.println(answers);
    }
    
    public static void maxDonations(ArrayList<Integer> offers) {
        ArrayList<Integer> answers = new ArrayList<>(offers.size());
        answers.add(offers.get(0));
        if(offers.get(1) > offers.get(0))
            answers.add(offers.get(1));
        else
            answers.add(offers.get(0));
        for(int i = 2; i < offers.size(); i++) {
            int take = offers.get(i) + answers.get(i-2);
            int skip = answers.get(i-1);
            if(take > skip)
                answers.add(take);
            else
                answers.add(skip);
        }
        System.out.println(answers);
    }
}