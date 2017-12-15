import java.util.*;
public class TaskManager implements Iterable<Task> {
    private PriorityQueue<Task> queue;
    private long time;
    private int lowestImportance;
    public TaskManager() {
        queue = new PriorityQueue<Task>();
        time = System.currentTimeMillis();
        lowestImportance = 0;
    }
    
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.run();
    }
    public static void print(Object o) {
        System.out.println(o);
    }
    
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Task Manager, written by Danylo Mirin");
        System.out.println("Press 1 to add tasks, 2 to let the program execute them, 3 to pause execution and\n"+
        "add an emergency command with priority 0 (highest) that will be executed immediately.\n"+
        " Write 'exit' to close.\nWrite tasks in the format 'task name, importance'");
        
        int action = 0;
        String input = "";
        while(1==1) {
            long diff = System.currentTimeMillis()-time;
            System.out.println("Time - "+ diff);
            System.out.println("What do you wish to do?");
            if(sc.hasNextInt()) {
                action = sc.nextInt();
                switch(action) {
                    case 1:
                        while(sc.hasNextLine()) {
                            System.out.println("Add task:");
                            sc.nextLine();
                            input = sc.nextLine();
                            if(input.equals("exit"))
                                return;
                            Task t = breakdown(input);
                            if(t == null) {
                                System.out.println("Invalid format. Adding failed.");
                            } else {
                                queue.add(t);
                                System.out.println("Task added!");
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Executing tasks...");
                        int count = 0;
                        diff = System.currentTimeMillis()-time;
                        while(!queue.isEmpty()) {
                            if(count % 5 == 0) {
                                System.out.println("Type 3 to jump, 0 to continue.");
                                if(sc.hasNextInt()) {
                                    action = sc.nextInt();
                                    sc.nextLine();
                                    if(action == 3) {
                                        System.out.println("Write the emergency task in the format 'taskName,0'");
                                        if(sc.hasNextLine()) {
                                            input = sc.nextLine();
                                            sc.nextLine();
                                            Task t = breakdown(input);
                                            if(t == null)
                                                System.out.println("Invalid format. Adding failed.");
                                            else
                                                queue.add(t);
                                        }
                                    }
                                }
                            }
                            System.out.println(execute() + " - done!(" + diff + ")");
                            count++;
                        }
                        break;
                    default:
                        System.out.println("What?");
                        break;
                }
            }
            if(sc.hasNextLine() && sc.nextLine().equals("exit"))
                return;
        }
    }
    
    /**Adds a task to the queue*/
    public boolean add(Task t) {
        if(t.importance() > 0)
            return queue.add(t);
        else
            return false;
    }
    
    /**executes the first task*/
    public Task execute() {
        long diff = System.currentTimeMillis() - time;
        while(diff < 50000) {
            diff = System.currentTimeMillis() - time;
        }
        Task t = queue.poll();
        System.out.println(t);
        return t;
    }
    
    public boolean jump(Task t) {
        if(t.importance() != 0) {
            System.out.println("Invalid importance. For a jump it must be 0.");
            return false;
        } else {
            add(t);
            execute();
            return true;
        }
    }
    
    private Task breakdown(String input) {
        if(input.equals("") || !input.contains(","))
            return null;
        String[] parts = input.split(",");
        parts[1] = parts[1].trim();//to remove the possible space
        if(parts[1].equals(0))
            System.out.println("Zero priority is reserved for jumps. Adding failed.");
        Task t = new Task(parts[0], Integer.parseInt(parts[1]));
        System.out.println("Given task is "+t);
        return t;
    }
    
    @Override
    public Iterator<Task> iterator() {
        return queue.iterator();
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Task e : this)
            sb.append(e.toString() + "\n");
        return sb.toString();
    }
}
class Task implements Comparable<Task> {
    private String name;
    private int importance; //1 - highest, 0 is reserved for emergency tasks and goes first.
    public Task(String name) {
        this.name = name;
        importance = 0;
    }
    
    public Task(String name, int importance) {
        this.name = name;
        this.importance = importance;
    }
    
    public int compareTo(Task other) {
        if(other.importance == importance)
            return 0;
        else if(other.importance < importance)
            return 1;
        else
            return -1;
    }
    
    public void setName(String name){this.name = name;}
    public void setImportance(int neu){importance = neu;}
    
    public String name(){return name;}
    public int importance(){return importance;}
    
    @Override
    public String toString() {
        return name + ", priority "+importance;
    }
}