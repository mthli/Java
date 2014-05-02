public class StaticTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        
        staff[0] = new Employee("Tom", 40000);
        staff[1] = new Employee("Dick", 60000);
        staff[2] = new Employee("Harry", 65000);

        for (Employee e : staff) {
            e.setId();
            System.out.println(
                    "name = " + e.getName() +
                    ", id = " + e.getID() +
                    ", salary = " + e.getSalary()
                    );
        }
        int n = Employee.getNextId();
        System.out.println("Next available id = " + n);
    }
}

class Employee {
    private static int nextId = 1;


    private String name;
    private double salary;
    private int id;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getID() {
        return id;
    }
    
    /* 
     * 在这里我们可以看到，
     * 实际上被定义成static变量的nextId也是可以被修改的，
     * 因为静态变量也是变量；
     * 如果不想被修改的话，
     * 还需要加上final进行修饰
     */
    public void setId() {
        id = nextId;
        nextId++;
    }

    /* 只能通过静态方法访问自身的静态域 */
    public static int getNextId() {
        return nextId;
    }

    public static void main(String[] args) {
        Employee e = new Employee("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
