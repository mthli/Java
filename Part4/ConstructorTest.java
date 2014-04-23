import java.util.*;

public class ConstructorTest {
    public static void main(String[] args) {
        Emplogee[] staff = new Emplogee[3];
        
        /* 这里利用到了Java中的“重载”进行初始化，
         * 当然在这里就不能像C++中叫“函数重载”了，
         * 在Java中，应该叫做“方法重载”
         */
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

    /* 下面的代码块用到的是“静态初始化块”
     * 当对类的静态域进行初始化的代码比较复杂的时候，
     * 可以考虑使用“静态初始化块”进行初始化
     */
    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    /* 这里用到的是普通的初始化块 */
    {
        id = nextId;
        nextId++;
    }

    /* 下面三个构造器代码块体现了所谓的“方法重载” */
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
