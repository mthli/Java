package clone;

/* 
 * 以下实现的是深拷贝；
 * 而Java默认的是浅拷贝，
 * 浅拷贝并没有克隆包含在对象中的内部对象；
 * 通常来说，使用浅拷贝的情况下，
 * 如果原始对象与浅克隆对象共享的子对象是不可变的话，
 * 将不会产生任何问题；
 * 但更常见的情况是子对象可变，
 * 所以必须重新定义clone方法，
 * 以便实现克隆子对象的深拷贝
 *
 * 对于每一个类，都需要做出下列判断：
 * 1. 默认的clone方法是否满足需求
 * 2. 默认的clone方法是否能够通过调用可变子对象的clone得到修补
 * 3. 是否应该不是用clone
 * 实际上，选项3是默认的。如果要选择1或2，类必须：
 * 1. 实现Cloneabel接口
 * 2. 使用public访问修饰符重新定义clone方法
 *
 * 注意，在Object类中，clone被声明为protected，
 * 因此无法直接调用anObject.clone()（参阅《Core Java Volumn I》第五章内容）。
 * 子类只能调用受保护的clone方法克隆它自己。
 * 为此，必须重新定义clone方法，并将它声明为public，
 * 这样才能让所有方法克隆对象
 */
public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
