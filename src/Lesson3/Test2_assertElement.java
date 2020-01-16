package Lesson3;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
public class Test2_assertElement {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/Alex/Desktop/AutomationTests/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        /*waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find Skip button",
                10
        );*/
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void assertElement() {
        String name1_of_folder = "The Witcher (TV series)";

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "The Witcher",
                "Cannot find input",
                5
        );
        String search_title_locator = "//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + name1_of_folder + "']";
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + name1_of_folder + "']"),
                "Cannot find article 'The Witcher (TV series)'",
                10
        );
        assertElement(
                By.id("org.wikipedia:id/view_page_title_text")
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }
    private void assertElement(By by) {
        try {
            WebElement element = driver.findElement(by);
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            throw new AssertionError("element " + by.toString() + "not found element on the page");
        }
    }
}
