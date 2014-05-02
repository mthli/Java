import java.util.*;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Calrl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        
        for (Employee e : staff) {
            e.raiseSalary(5);
        }

        for (Employee e : staff) {
            System.out.println(
                    "name = " + e.getName() + 
                    ", salary = " + e.getSalary() + 
                    ", hireDay = " + e.getHireDay()
                    );
        }
    }
}

/* 
 * 如前CalendarTest.java开头的注释所述，
 * 这里的Employee就是一个非公有类，
 * 但它不是一个私有类
 */
class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    /* 
     * 下面这段代码块是一个构造器，
     * 顾名思义，构造器是用来构造一个新的对象实例的，
     * 需要注意的是：
     *     构造器的名字应该与所属类的名字相同
     */
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    /* 
     * 以下的几处代码块是一些访问器和更改器，
     * 通常的习惯是，
     * 在访问器方法名前面加上前缀get，
     * 而在更改器方法前面加上前缀set
     */
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    /* 
     * 如果愿意的话，可以使用下面这段代码来书写raiseSalary：
     *     public void raiseSalary(double byPercent) {
     *         double raise = this.salary * byPercent / 100;
     *         this.salary += raise;
     *    }
     *  在这里this表示“隐式参数（implicit）”，
     *  指代了出现在方法名前面的Employee类对象，
     *  可以理解为“这个对象的XXX”。
     *  用this的优点在于，
     *  可以将实例域与局部变量明显的区分开来
     */
    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

