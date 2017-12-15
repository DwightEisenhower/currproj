public class Pair
{
    private Integer a;
    private Integer b;
    public Pair(Integer a, Integer b){
        this.a = a;
        this.b = b;
    }
    
    public Integer a(){return(a);}
    public Integer b(){return(b);}
    
    public String toString(){
        return("Pair(a="+a+",b="+b+")");
    }
}
