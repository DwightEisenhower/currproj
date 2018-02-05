import java.util.*;
import java.util.regex.*;
public class Enclosure {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++) {
            ArrayList<Integer> answers = new ArrayList<>();
            String regex = "(\\p{Punct}\\d+)";
            Pattern pat = Pattern.compile(args[i]);
            Matcher mat = pat.matcher(regex);
            int next = 1;
            while(mat.find())
                answers.add(args[i].indexOf(mat.group(next))+1);
            System.out.println(answers);
        }
    }
}