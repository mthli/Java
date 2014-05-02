package abstractClasses;

/* 
 * 因为Employee类中实现了Person抽象类中的所有抽象方法，
 * 所以不需要使用abstract关键字进行修饰
 */
public class Student extends Person {
    private String major;

    public Student(String n, String m) {
        super(n);
        major = m;
    }

    /* 这里对Person抽象类中的getDescription抽象方法进行了重写 */
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
