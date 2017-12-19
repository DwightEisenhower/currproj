import java.io.*;
import java.util.*;

public class FileStuff
{
    public static void main()
    {
        /*
        File f = new File("/Volumes/J/IO/README.TXT");
        System.out.println(f.getName());
        System.out.println(f.getParent());
        System.out.println(f.getPath());

        System.out.println(f.canWrite());
        System.out.println(f.isFile());

        System.out.println(f.renameTo(new File("/Volumes/J/IO/readme.TXT")));
        //System.out.println(f.setReadOnly());

        File g = new File("/Volumes/J/IO/example.txt");
        try{
        g.createNewFile();
        }catch(IOException e){
        System.out.println("no permissions");
        System.exit(1);
        }

        g.delete();

        File h = new File("/Volumes/J/IO/NEWFOLDER");

        h.mkdir();

        File j = new File("/Volumes/J/IO/example.txt");
        try{
        FileWriter w = new FileWriter(j);

        w.write("text text text \n");
        w.write("more more more");

        w.close();
        }catch(IOException e){
        System.out.println("Could not open file for writing");
        System.exit(1);
        }

        File j = new File("/Volumes/J/IO/example.txt");
        try{
        FileReader r = new FileReader(j);
        int info = -1;
        while((info = r.read()) != -1)
        {
        System.out.println(info);
        }
        r.close();
        }catch(IOException e){
        System.out.println("no");
        System.exit(1);
        }
         */
        File j = new File("/Volumes/J/IO/example.txt");
        try{
            BufferedReader br = new BufferedReader(new FileReader(j));
            String read;
            
            while((read = br.readLine()) != null){
                System.out.println(read);
            }
        }catch(IOException e){
            System.out.println("NO");
            System.exit(1);
        }
    }

    public static void folders()
    {
        String thing = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < thing.length(); i++)
        {
            File a = new File("/Users/summit/Desktop/IOCatch/" + thing.substring(i, i+1));
            a.mkdir();
            File b = new File("/Users/summit/Desktop/IOCatch/" + thing.substring(i, i+1) + "/" + thing.substring(i, i+1));
            try{
                b.createNewFile();
            }catch(IOException e){
                System.out.println("No permission");
                System.exit(1);
            }

            try{
                FileWriter w = new FileWriter(b);
                w.write(thing.substring(i, i+1));
                w.close();
            }catch(IOException e){
                System.out.println("Could not open file for writing");
                System.exit(1);
            }
        }
    }
}
