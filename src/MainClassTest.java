import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass
{
    @Test

    public void testGetLocalNumber() {
        int number = getLocalNumber();
            /*либо можно сделать без assert
            if (number != 14)
            System.out.println("возвращаемое число равно 14");
        else
            System.out.println("возвращаемое число не равно 14");*/
        {
            Assert.assertTrue("возвращаемое число не равно 14", number == 14);
        }
    }
}
