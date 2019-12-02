package Lesson0.Test2;

import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass {
    @Test
    public void testGetClassNumber() {
        int number2 = getClassNumber();
        //System.out.println("возвращаемое число равно");
        {
            Assert.assertTrue("возвращаемое число не больше 45", number2 > 45);
        }
    }
}
