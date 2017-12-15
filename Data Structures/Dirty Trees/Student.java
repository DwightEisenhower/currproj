import java.util.Comparator;
public class Student {
    private int id;
    private double gpa;
    private String name;
    public Student(String name, int id, double gpa) {
        this.id = id;
        this.gpa = gpa;
        this.name = name;
    }

    public int getid(){return(id);}
    public double getgpa(){return(gpa);}
    public String getname(){return(name);}
    
    public String toString(){
        return(name + " id: " + id + " gpa: " + gpa);
    }
    
    static class IDComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if(s1.getid() < s2.getid())
                return -1;
            else if(s1.getid() == s2.getid())
                return 0;
            else
                return 1;
        }
    }
    static class GPAComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            if(s1.getgpa() < s2.getgpa())
                return -1;
            else if(s1.getgpa() == s2.getgpa())
                return 0;
            else
                return 1;
        }
    }
    static class NameComparator implements Comparator<Student> {
        public int compare(Student s1, Student s2) {
            return s1.getname().compareTo(s2.getname());
        }
    }
}







