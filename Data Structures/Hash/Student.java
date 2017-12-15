public class Student
{
    private String name;
    private final int id;
    private static int idAssigner = 1;
    private double gpa;
    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
        id = idAssigner++;
    }
    
    public String name(){return(name);}
    public void setname(String newname){name = newname;}
    public int id(){return(id);}
    public double gpa(){return(gpa);}
    
    public void setgpa(double newgpa){gpa = newgpa;}
    
    //O(1)
    //give diverse answers to minimize collisions
    //Muse use immutable data
    @Override
    public int hashCode() {
        String[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".split("");
        return id;
    }
    
    @Override
    public boolean equals(Object other) {
        Student temp = (Student) other;
        return temp.id() == id;
    }
    
    @Override
    public String toString(){
        return(name + " GPA: " + gpa);
    }
}