package arrayList;

import java.util.*;

/*
 * ArrayList是一个采用类型参数的泛型类，
 * 为了指定数组列表保存的元素队形类型，
 * 需要用一对尖括号将类名括起来加在后面
 *
 * ArrayList有很多实用的方法：
 * 1. 使用add方法可以将元素添加到数组列表中
 * 2. 使用size方法可以获取数组列表中包含的实际元素项目
 * 3. ...（可参见《Core Java Volumn I》183页
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();

        staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
        staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
        staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
                + e.getHireDay());
    }
}
