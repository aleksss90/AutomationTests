package Lesson0.Test3;

import org.junit.Test;


public class MainClassTest extends MainClass {
    @Test
    public void testGetClassString () {
        String c = getClassString();
        Boolean isHello1 = c.contains("Hello");
        Boolean isHello2 = c.contains("hello");

        if (isHello1 || isHello2) {
            System.out.println("Содержит Hello или hello");
        } else {
            System.out.println("Не содержит Hello или hello");
        }
    }
}
