package enums;

import java.util.*;

/* 所有的枚举变量都是Enum类的子类，它们继承了这个类的许多方法 */
public class EnumTest {  
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        /* toString的逆方法是valueOf */
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");      
    }
}

/* 
 * 如果需要的话，可以在枚举类型中添加一些构造器、方法和域，
 * 当然，构造器只是在构造枚举常量时被调用
 */
enum Size {
    /* 通过括号进行赋值 */
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private Size(String abbreviation) { this.abbreviation = abbreviation; }
    public String getAbbreviation() { return abbreviation; }

    private String abbreviation;
}
