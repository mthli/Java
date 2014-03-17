import java.util.*;

public class ConstructorTest {
    public static void main(String[] args) {
        Emplogee[] staff = new Emplogee[3];
        staff[0] = new Emplogee("Harry", 40000);
        staff[1] = new Emplogee(60000);
        staff[2] = new Emplogee();

        for (Emplogee e : staff) {
            System.out.println(
                    "name = " + e.getName() +
                    ", id = " + e.getId() + 
                    ", salary = " + e.getSalary()
                    );
        }
    }
}

class Emplogee {
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    {
        id = nextId;
        nextId++;
    }

    public Emplogee(String n, double s) {
        name = n;
        salary = s;
    }

    public Emplogee(double s) {
        this("Emplogee #" + nextId, s);
    }

    public Emplogee() {
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}

