package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }
    public void assertElementPresent(String locator,String error_message)
    {
        try {
            WebElement element = driver.findElement(locator,error_message);
        }
        catch (org.openqa.selenium.NoSuchElementException exception){
            throw  new AssertionError("element" + locator + " not found element on page");
        }
    }
    protected void swipeElementToLeft(String locator, String error_message)
    {
        MobileElement element = (MobileElement) waitForElementPresent(
                locator,
                error_message,
                10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middel_y = (upper_y + lower_y)/2;

        TouchAction action = new TouchAction(driver);
        action
                .press(point(right_x,middel_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(point(left_x, middel_y))
                .release()
                .perform();
    }
   /*public void swipeByElements (MobileElement startElement, MobileElement endElement) {
       int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
       int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);

       int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
       int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

       new TouchAction(driver)
               .press(PointOption.point(startX,startY))
               .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
               .moveTo(PointOption.point(endX, endY))
               .release().perform();
   }*/
    private  By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];
        if (by_type.equals("xpath")){
            return By.xpath(locator);
        }else if (by_type.equals("id")) {
            return By.id(locator);
        }else {
            throw new IllegalArgumentException("Cannot get type of locator: " + locator_with_type);
        }
    }
}
