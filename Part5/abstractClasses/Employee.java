package abstractClasses;

import java.util.Date;
import java.util.GregorianCalendar;

/* 因为Employee类中实现了Person抽象类中的所有抽象方法，
 * 所以不需要使用abstract关键字进行修饰
 */
public class Employee extends Person {
   private double salary;
   private Date hireDay;

   public Employee(String n, double s, int year, int month, int day) {
      super(n);
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      hireDay = calendar.getTime();
   }

   public double getSalary() {
      return salary;
   }

   public Date getHireDay() {
      return hireDay;
   }

   /* 这里对Person抽象类中的getDescription抽象方法进行了重写 */
   public String getDescription() {
      return String.format("an employee with a salary of $%.2f", salary);
   }

   public void raiseSalary(double byPercent) {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
}
