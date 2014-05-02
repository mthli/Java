package inheritance;

public class ManagerTest {
    public static void main(String[] args) {
        /* 构造一个对象 */
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        /* 
         * 这里e.getName()能够自行确定调用哪个类的getSalary方法；
         * 当一个对象变量（比如在这里就是e）可以指示多种实际类型的时候，
         * 我们就把这种现象称之为“多态（polymorphism）”；
         * 在运行时能够自动选择调用哪个方法的现象我们称之为“动态绑定（dynamic binding）”；
         * 关于“多态”和“动态绑定”的详细说明见后方的代码
         */
        for (Employee e : staff)
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
    }
}
