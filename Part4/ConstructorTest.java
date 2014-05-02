import java.util.*;

/* 
 * 调用构造器的具体处理步骤：
 * 1. 所有的数据域被初始化为默认值（0、false或者null）
 * 2. 按照在类声明中出现的次序，依次执行所有的域初始化语句和初始化块
 * 3. 如果构造器第一行调用了第二个构造器（详细见《Core Java Volumn I》第129页），则执行第二个构造器主体
 * 4. 执行这个构造器的主体
 */

public class ConstructorTest {
    public static void main(String[] args) {
        Emplogee[] staff = new Emplogee[3];
        
        /* 
         * 这里利用到了Java中的“重载”进行初始化，
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

    /* 
     * 下面的代码块用到的是“静态初始化块”
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

    /* 
     * 这是“无参数构造器”，
     * 对象由无参数构造器构造时，其状态会被设置为适当的默认值。
     * 值得注意的是：
     *     仅当在编写一个类没有提供构造器时候，
     *     系统会自动提供一个无参数的默认的构造器，
     *     这个构造器将所有的实例域都设置为默认值（0、false或者null）。
     *     当类中提供了至少一个构造器，
     *     但是没有提供无参数的构造器的时候，
     *     则在构造对象的时候如果没有提供相应的参数则被视为不合法。
     */
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
