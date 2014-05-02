package inheritance;

/* 
 * Java中使用extends关键字来表示“继承”的概念，
 * extends关键字表明正在构造的新类派生于一个已经存在的类；
 * 需要注意的是：
 *     在Java中，所有的继承都是公用继承，
 *     而没有C++中的私有继承和保护继承
 *
 * 在这里顺路总结一下Java中用于控制可见性的4个访问修饰符：
 * 1. private   -- 仅对本类可见
 * 2. public    -- 对所有类可见
 * 3. protected -- 对本包和所有子类可见
 * 4. 没有修饰符的情况下。默认对本包可见
 */
public class Manager extends Employee {
    private double bonus;

    /* 
     * 下面这段代码块使用了super来调用其父类（超类）的构造器，
     * super是一个指示编译器调用超类方法的特殊关键字；
     * 注意super并不是一个对象的引用，不能将super赋给另一个变量对象
     */
    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        bonus = 0;
    }

    /* 
     * 在这里对其超类（Employee）中的getSalary方法进行了重写（override）；
     * 由于在Manager类中也提供了getSalary方法，
     * 相当于将Employee类中的getSalary方法进行了覆盖，
     * 当直接调用getSalary类的时候，实际上是调用Manager类中的getSalary，
     * 而不是Employee类中的getSalary；
     * 所以如果要使用Employee类中提供的getSalary方法，需要使用super关键字
     */
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }

    public void setBonus(double b) {
        bonus = b;
    }
}
