package abstractClasses;

/* 
 * 下面的Person类使用了abstract关键字进行修饰，
 * 表示这是一个“抽象类”；
 * 下面具体说说abstract的一些用法：
 * 1. 修饰类：
 *        abstract修饰类的时候，表示这个类是一个“抽象类”，
 *        这个类不能生成实例对象，
 *        但是可以作为对象变量声明的类型，
 *        也就是编译时的类型；
 *        抽象类就相当于一个半成品，
 *        需要子类继承并覆盖其中的抽象方法
 * 2. 修饰方法：
 *        abstract修饰方法的时候，会使这个方法变成“抽象方法”，
 *        也就是只有声明（定义）而没有实现，
 *        它必须在子类继承实现（覆盖），
 *        除非子类本身也是抽象类
 * 
 * 需要注意几点：
 * 1. 父类如果是抽象类，其中包括抽象方法的话，
 *    当子类继承父类，并把父类中所有的抽象方法都实现（覆盖）了，
 *    子类才具有创建对象实例的能力，
 *    否则子类也必须是抽象类；
 *    差不多也就是说，
 *    一个类中只要有一个abstract方法，
 *    那么这个类就要被声明为abstract，
 *    但是其中可以有非abstract的方法存在
 * 2. 抽象类中可以有构造方法，
 *    是子类在构造子对象时需要调用的父类（抽象类）的构造方法
 * 
 * 总体来说，abstract有利于类的设计者创建方法的原型，
 * 而把真正的实现留个使用这个类的人
 */

public abstract class Person {
    /* 这里就定义了一个抽象方法 */
    public abstract String getDescription();
    private String name;

    /* 这里就体现出了抽象类中也可以有非abstract的方法存在 */
    public Person(String n) {
        name = n;
    }

    public String getName() {
       return name;
    }
}
