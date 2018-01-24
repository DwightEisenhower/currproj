import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
/**
 * 4 letter word in a sentence
 * 4 letter word w/o "m"
 * 1 character that's anything
 */
public class Regex {
    public static void main() {
        String line = "I have 2/3 of the longest races today.";
        String regex = "";
        Scanner in = new Scanner(System.in);
        System.out.println(line);
        System.out.print("Enter regex: ");
        regex = in.nextLine();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        if(m.find()) {
            System.out.println("Match found");
        } else {
            System.out.println("No match found");
        }
    }
}
/**
 * sw[iau]m - match all combos
 * [sS]w[iau] - use multiple
 * sw[^a] - anything but an A
 * [A-Z] - all capital letters
 * [A-Za-z] - all capital and lowercase letters
 * \d - digit
 * \D - non-digit
 * \D\d\d\d\D - find specifically a 3 digit #
 * \s - any space character (tab, space, return, etc)
 * \S - any non-space character
 * \w - same as [A-Za-z] but also includes word parts
 * \W - anything that isn't a word part
 */