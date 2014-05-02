package equals;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee
{
    private String name;
    private double salary;
    private Date hireDay;

    /* 构造方法 */
    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /* 
     * equals方法的实现实例；
     *
     * 在这里记下《Core Java Volumn I》中编写一个完美的equals方法哦的建议：
     * 1. 显式参数命名为otherObject，稍后需要将她转换成另一个叫做other的变量
     * 2. 检测this与otherObject是否引用同一个对象：
     *        if (this == otherObject) return true;
     * 3. 检测otherObject是否为null，如果为null，返回false。这项检测是很有必要的
     * 4. 比较this与otherObject是否属于同一个类。如果equals的语义在每个子类中有所改变，就使用getClass检测：
     *        if (getClass() != otherObject.getClass()) return false;
     *    如果所有的子类都拥有统一的语义，就使用instanceof检测：
     *        if(!(otherObject instanceof ClassName)) return false;
     * 5. 将otherObject转换为相应的类类型变量：
     *        ClassName other = (ClassName) otherObject
     * 6. 现在开始对所有需要比较的域进行比较了。使用 == 比较基本类型域，使用equals比较对象域。
     *    如果所有的域都匹配，就返回true；否则返回false。
     *        return field1 == other.field1
     *            && Object.equals(field2, other.field2)
     *            && ...
     *    如果在子类中重新定义了equals，就要在其中包含调用super.equals(other)
     */
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (getClass() != otherObject.getClass()) return false;

        Employee other = (Employee) otherObject;

        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);
    }

    /* 
     * hashCode方法；
     * 散列码（hash code）是由对象导出的一个整型值，
     * 散列码是没有规律的；
     * 如果x和y是两个不同的对象，x.hashCode()和y.hashCode()基本上不会相同；
     * 注意，equals方法和hashCode方法的定义必须一致
     */
    public int hashCode() {
        return Objects.hash(name, salary, hireDay); 
    }

    /* 强烈建议为每一个自定义的类增加一个toString方法 */
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
            + "]";
    }
} 
