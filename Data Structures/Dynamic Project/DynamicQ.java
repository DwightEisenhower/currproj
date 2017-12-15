import java.util.*;
public class DynamicQ
{
    public static void main(){
        // ArrayList<Integer> temp = new ArrayList<Integer>();
        // temp.add(3);
        // temp.add(5);
        // temp.add(4);
        // temp.add(7);
        // temp.add(9);
        // temp.add(6);
        // longestSub(temp);
        
        int[][] temp = new int[][]{
            new int[]{5,2,1,1},
            new int[]{3,2,4,1},
            new int[]{10,7,1,1},
            new int[]{6,3,15,2}
        };
        pointPicker(temp);
    }

    /*#
     * Olympic weight lifting has strict rules for loading weight on the bar. Each lifter identifies
     * the amount of weight they will attempt to lift (liftWeight) in kg and the bar is loaded as 
     * follows.
     * 
     * An equal amount of weight is added to each side of the barbell using the fewest number of 
     * weightlifting plates as possible. 
     * Plates comes in the following weights: 1/2kg, 1kg, 2kg, 5kg, 10kg, 20kg, 50kg
     * In addition, the barbell itself weighs 50kg.
     * 
     * Identify the fewest number of plates necessary to add to the barbell for the given weight.
     */
    public static void barbellWeights(int liftWeight) {//assuming that this is 50+ kg
        Stack<Double> stack = new Stack<>();
        stack.push(0.5);
        stack.push(1.0);
        stack.push(2.0);
        stack.push(5.0);
        stack.push(10.0);
        stack.push(20.0);
        stack.push(50.0);
        int numPlates = 0;
        int weightRemaining = (liftWeight - 50) / 2;
        if(weightRemaining == 0) {
            System.out.println("The given weight is that of the barbell, nothing added.");
            return;
        }
        while(!stack.isEmpty()) {
            Double temp = stack.pop();
            while(weightRemaining - temp >= 0) {
                numPlates++;
                weightRemaining -= temp;
            }
        }
        System.out.println(numPlates*2);
    }

    /*#
     * Given an array data find the length of the longest sublist in data that contains strictly 
     * increasing values. You should not rearrange the values in data. 
     * 
     * For example: {3, 5, 4, 7, 9, 6} would return 4 as the longest increasing sublist is {3, 4, 7, 9}
     * {3, 5, 4, 7, 10, 8, 10} would return 5
     * {3} would return 1
     * {3, 0, 1, -4, 1, 4, 2} would return 3
     */
    public static void longestSub(ArrayList<Integer> data){
        if(data.isEmpty())
            return;
        if(data.size() == 1) {
            System.out.println(1);
            return;
        }
        ArrayList<Integer> longest = new ArrayList<>();
        longest.add(data.get(0));
        for(int i = 1; i < data.size(); i++) {
            if(data.get(i) > longest.get(longest.size()-1))
                longest.add(data.get(i));
        }
        System.out.println(longest + ", length "+longest.size());
    }

    /*#
     * You start in the [0][0] position of the points 2D array and must end at bottom right. On each
     * spot you may move either down or right, never left or up. Each spot is worth some number of
     * points identified by the value at each spot in the array. Identify the maximum amount of
     * points you can earn during your travel from the beginning to the end. 
     * 
     * The values in the points array may be either positive, 0 or negative. You may always add the
     * points in the [0][0] spot to your score.
     * 
     * Hint: This may seem tricky now that there is a two dimensional array, but the dynamic programming logic is the 
     * same. Draw some possible inputs and find the answer by hand using dynamic programming to get an idea of how
     * you should code this.
     */
    public static void pointPicker(int[][] points){
        Stack<Integer> stack = new Stack<>();
        stack.push(points[0][0]);
        int[][] values = new int[points.length][points[0].length];
        values[0][0] = points[0][0];
        for(int i = 1; i < points.length; i++) {
            values[i][0] = values[i-1][0] + points[i][0];
            for(int j = 1; j < points[0].length; j++) {
                values[i][j] = values[i][j-1]+points[i][j];
            }
        }
        System.out.println(values[values.length-1][values[0].length-1]);
    }

    /*#
     * You have broken into a bank vault and are about to commit a brilliant robbery. The vault
     * contains a variety of items that all have monetary values (the value in the hashmap). Each
     * of these items has a unique associated weight (the key in the hashmap). 
     * 
     * You can only carry so much out of the bank vault and you want to maximize the amount of money
     * you make. Identify the maximum amount of money you can make without going over the maxWeight
     * you can hold.
     * 
     * You may assume there is unlimited of each item and each item has a positive weight and value.
     */
    public static void bankRobbery(int maxWeight, HashMap<Integer, Integer> valuables){
        HashMap<Integer, Integer> copy = new HashMap<>();
        valuables.putAll(copy);
        int heaviestWeight = 
        int maxValue = Collections.max(copy.values());
        int maxMoney = 0; int currWeight = 0;
        while(currWeight <= maxWeight) {
            while(
        }
    }
}