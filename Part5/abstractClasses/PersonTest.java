package abstractClasses;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        /* 在这里也是直接用到了“多态”和“动态绑定”；
         * 在这里需要注意的是，
         * 虽然p是Person类的实例，
         * 但是由于不能构造抽象类Person的对象，
         * 所以变量p永远不会引用Person对象，
         * 而是引用诸如Employee或者Student这样具体的子类对象
         */
        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}
