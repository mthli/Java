package interfaces;

/* 
 * 假设希望使用Arrays类的sort方法对Employee对象数组进行排序，
 * Employee类就必须实现Comparable接口
 *
 * 为了让类实现一个接口，通常需要下面几个步骤：
 * 1. 将类声明为实现给定的接口
 * 2. 让接口中的所有方法进行定义
 *
 * 在这里讨论一下接口与抽象类之间的区别：
 *     但是由于Java只支持单继承，而不是C++那样的多重继承，
 *     所以使用抽象类的时候，每个类都只能扩展于一个类；
 *     但是却可以实现多个接口，
 *     接口可以提供多重继承的大多数好处，
 *     同时还能避免多重继承的复杂性和低效性
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
