/** Look in the ReadMe for info on this project **/
/** LOOK BUT DON' TOUCH **/

import java.util.HashMap;//Hashmap? more like hashbrown

public class NameGenerator
{
    private static HashMap<String, Boolean> names = new HashMap<String, Boolean>();
    private static String[] first = {"Alice", "Bob", "Cindy", "Dillon", "Ethan", "Frank", "Gina", "Harry",
                          "Irene", "Jessica", "Kyle", "Lenny", "Matt", "Nina", "Opera", "Pat",
                          "Quentin", "Rachel", "Sam", "Tim", "Umberto", "Vicky", "Wanda", "Xander",
                          "Yvette", "Zack"};
    private static String[] last = {"Abajian", "Bacani", "Califano", "Dara", "Eagle", "Fabricius", "Galliano",
                         "Halberstadt", "Idler", "Jackovich", "Kadlec", "Lagomarsino", "Madland",
                         "Navratil", "Obermann", "Panella", "Quijada", "Rajotte", "Sahlberg", 
                         "Tacke", "Unroe", "Vance", "Walde", "Xiong", "Yamaguchi", "Zani"};
                   
    
    public static String newPlayerName()
    {
        String toReturn = "";
        do{
            toReturn = first[(int) (Math.random()*first.length)] + " " + 
                       first[(int) (Math.random()*first.length)].substring(0,1) + " " + 
                       last[(int) (Math.random()*last.length)];
        }while(names.containsKey(toReturn));
        names.put(toReturn, true);
        return(toReturn);
    }
}
