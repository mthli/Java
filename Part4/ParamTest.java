/* 
 * 在这里需要对Java的传递机制进行了解：
 *     Java总是采用“按值传递”
 *
 * 一些概念：
 *     值传递：函数在调用的时候，传递的参数不是实参本身，而是它的副本（拷贝）
 *     引用传递：函数在调用的时候，传递的参数就是实参本身（的地址）
 */

public class ParamTest {
    public static void main(String[] args) {
        /* 
         * 第一个测试，
         * 调用的tripleValue方法不能够修改原先的数值
         */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("After: percent = " + percent);

        /* 
         * 第二个测试，
         * 调用的tripleSalary方法成功的改变了对象。
         * 你可能会奇怪了：
         *     Java明明是按值传递，为什么能够改变原来的对象呢？
         * 其实是因为这样的：
         *     Java中，对象（类的实例）都是通过引用来访问的，
         *     比如：
         *         Object foo = new Object();
         *     foo只是一个引用，指向了新创建的这个Object对象
         *     所以你在这里调用tripleSalary的时候，
         *     传进去的harry参数本身就是一个引用了，
         *     调用的方法对其进行拷贝，
         *     得到的临时变量依然是与harry相同的引用，
         *     所以自然就可以修改这个对象的状态了，
         *     
         *     详细的说明可以参考这个网址：
         *         http://zhi.hu/MBSN
         *     也可以参阅《Core Java Volume I》第122页
         */
        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("Harrt", 50000);
        System.out.println("Before: salary = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary = " + harry.getSalary());

        /* 
         * 第三个测试，
         * 调用的swap方法并不能交换两个对象：
         *     因为swap内部交换的是其拷贝过来的临时的对象，
         *     而不是实际的对象
         */
        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice", 70000);
        Employee b = new Employee("Bob", 60000);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swap(a, b);
        System.out.println("After: a = " + a.getName());
        System.out.println("After: b = " + b.getName());
    }

    public static void tripleValue(double x) {
        x = 3 * x;
        System.out.println("End of method: x = " + x);
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
        System.out.println("End of method: salary = " + x.getSalary());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x = " + x.getName());
        System.out.println("End of method: y = " + y.getName());
    }
}

class Employee {
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
}
