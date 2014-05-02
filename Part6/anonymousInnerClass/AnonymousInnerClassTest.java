package anonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock {
    public void start(int interval, final boolean beep) {
        /* 
         * 这里构造了一个匿名内部类；
         * 
         * 使用匿名内部类时需要注意：
         *     由于构造器的名字必须与类名相同，而匿名类没有类名，
         *     所以，匿名类不能有构造器。
         *     取而代之的是，将构造器参数传递给超类构造器。
         *     尤其是在内部类实现接口的时候，不能有任何构造参数。
         */
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Date now = new Date();
                System.out.println("At the tone, the time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }   
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }
}
