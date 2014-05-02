package interfaces;

/* 
 * 假设希望使用Arrays类的sort方法对Employee对象数组进行排序，
 * Employee类就必须实现Comparable接口
 *
 * 为了让类实现一个接口，通常需要下面几个步骤：
 * 1. 将类声明为实现给定的接口
 * 2. 让接口中的所有方法进行定义
 */
public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    /* 在这里实现了需要提供的compareTo方法 */
    public int compareTo(Employee other) {
        return Double.compare(salary, other.salary);
    }
}
