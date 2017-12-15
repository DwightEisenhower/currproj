import java.util.*;
public class HashQuestions
{
    /** Return true if small is a subset of large. That is, all the elements in small are in large **/
    /*#
     * Analysis: This method can be solved in nlog(n) time where n is the length of the large array.
     * This is done by sorting large, then verifying whether each element in small is in large via a
     * binary search.
     * 
     * Complete this method with a Hashset in O(n) time.
     */
    public static boolean isSubset(int[] large, int[] small){
        HashSet<Integer> hs = new HashSet<>(20, 0.9f);
        for(int i : large)
            hs.add(new Integer(i));
        for(int i = 0; i < small.length; i++)
            if(!hs.contains(small[i]))
                return false;
        return true;
    }
    
    /** Return true if the two numbers in pair have an opposite pair in the array. (1,2) <--> (2,1) for example **/
    /*#
     * Analysis: This method can be solved in n^2 time where n is the length of the array.
     * This is done by comparing every pair to every other pair in the array and looking for an opposite.
     * 
     * Complete this method with a Hash in O(n) time.
     */
    public static boolean opposites(Pair[] data){
        HashSet<Pair> hs = new HashSet<>(20, 0.9f);
        for(Pair p : data) {
            if(hs.contains(new Pair(p.b(), p.a())))
                return true;
            hs.add(p);
        }
        return false;
    }
    
    /** data contains unique values. Find and display 4 different ints such that a + b == c + d. Print error if none **/
    /*#
     * Analysis: This method can be completed in n^2 time where n is the length of the array.
     * This is done by using 4 nested for loops comparing every possible combination of values.
     * 
     * Complete this method in O(n^2) time using a Hash. The time cannot be improved, but the code will be more
     * simple and easier to read.
     */
    public static void fourSum(int[] data){
        HashMap<Integer,Pair> set = new HashMap<>();//integer = sum, pair are the nums
        for(int i = 0; i < data.length; i++)
            for(int j = i+1; j < data.length; j++) {
                Pair check = set.get(i+j);
                if(check != null) {
                    System.out.println("fauifa");
                    return;
                }
                set.put(check.a()+check.b(), check);
            }
        System.out.println("None found.");
    }
    
    /** Print the longest length of the subset of data that contains consecutive values. {7, 2, 3, 9, 4} would be 3 **/
    /*#
     * Analysis: This method can be completed in nlogn time where n is the length of the array. 
     * This can be done by sorting the array and then iterating through it to find the longest list of consecutive elements.
     * 
     * Complete this method with a Hashset in O(n) time.
     */
    public static void sequence(int[] data){
        HashSet<Integer> hmmm = new HashSet<>();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for(int i : data) {
            hmmm.add(new Integer(data[i]));
            
        }
        int biggestLength = 0;
        for(int i = 0; i < data.length; i++) {
            Integer temp = data[i];
            int length = 1;
            while(hmmm.contains(temp+1)) {
                temp = temp+1;
                length++;
            }
            if(length > biggestLength)
                biggestLength = length;
        }
        System.out.println(biggestLength);
    }
    
    /** Calculate f(n) recursively. This sequence is calculated by summing the two previous numbers.
     * f(5) is equal to f(4) + f(3). This creates a sequence with the following values:
     * n    0 1 2 3 4 5 6  7  8
     * f(n) 0 1 1 2 3 5 8 13 21
     */
    /*#
     * Analysis: This calculation requires numerous redundant calculations. For example to calculate f(5) you must 
     * calculate f(4) and f(3). To calculate f(4) you need f(3) and f(2). But we've already gone through the trouble
     * of calculating f(3)! This makes the runtime of a strict recursive solution 2^n.
     * 
     * Complete this method recursively with a Hash in O(n) time. Do this by avoiding redundant calculations.
     */
    public static int f(int value){
        HashMap<Integer, Integer> map = new HashMap<>();
        return fHelper(map, value);
    }
    private static int fHelper(HashMap<Integer, Integer> hash, int value) {
        if(value == 0)
            return 0;
        else if(value == 1)
            return 1;
        else if(hash.containsKey(value-1) && !hash.containsKey(value-2))
            hash.put(value-2, fHelper(hash, value-2));
        else if(!hash.containsKey(value-1) && hash.containsKey(value-2))
            hash.put(value-1, fHelper(hash, value-1));
        else if(!hash.containsKey(value-1) && !hash.containsKey(value-2)) {
            hash.put(value-2, fHelper(hash, value-2));
            hash.put(value-1, fHelper(hash, value-1));
        }
        return hash.get(value-1) + hash.get(value-2);
    }
}