import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
/**
 * 4 letter word in a sentence
 * 4 letter word w/o "m"
 * 1 character that's anything
 * 
 * Find a word that has two non-consecutive a's --> \b\w*[Aa]\w+[Aa]\w*\b
 * Find a phrase that ends in a single period or any number of exclamation points --> \b[.]?\W*
 * Find a word that is at least 4 characters long --> \b\w\w\w\w+\b
 * Find if a word follows the "i before e except after c" rule --> \b\w*[^c]ie\w*\b
 */
public class Regex {
    public static void main() {
        String line = "Awesome! The swimmer is unbeatable in 500 freestyle.";
        String regex = "";
        Scanner in = new Scanner(System.in);
        System.out.println(line);
        System.out.print("Enter regex: ");
        regex = in.nextLine();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(line);
        if(m.find()) {
            System.out.println("Match found");
            System.out.println(m.group());//shows the match
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
 * \b - boundary, no physical space but represents the distance b/n 2 diff types of char-s
 * . - match any character
 * | - match either of the characters on the left and right sides of it (i|a --> either "i" or "a"). Can be combined
 *      (ab)|(bc)|(ca)
 * ? - previous character is optional (colou?r)
 * + - match as many characters as possible (hel+o --> will catch if someone types "helllllo")
 * * - match all or none (ay*lmao
 * 
 */