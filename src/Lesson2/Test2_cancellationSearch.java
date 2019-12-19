package Lesson2;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
public class Test2_cancellationSearch {
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/Alex/Desktop/AutomationTests/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Skip')]"),
                "Cannot find Skip button",
                10
        );
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void cancellationSearch() {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Automation",
                "Cannot find input",
                5
        );

        WebElement title1 = waitForElementPresent(
                By.xpath("//*[contains(@text,'Automation')]"),
                "Cannot find 'Automation' in topics",
                20
        );
        String expectedTitle1 = title1.getAttribute("text");
        Assert.assertEquals(
                "unexpected title1",
                "Automation",
                expectedTitle1
        );
        WebElement title2 = waitForElementPresent(
                By.xpath("//*[contains(@text,'Automation Master')]"),
                "Cannot find 'Automation Master' in topics",
                20
        );
        String expectedTitle2 = title2.getAttribute("text");
        Assert.assertEquals(
                "unexpected title2",
                "Automation Master",
                expectedTitle2
        );

        waitForElementAndClick(
              By.id("org.wikipedia:id/search_close_btn"),
             "Cannot find button X to cancel search",
          10
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_btn"),
                "button X is still present on the page",
                10
        );

        //альтернативный метод именно с выходом из поиска на главный экран
        /*public void cancellationSearch() {
        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Automation",
                "Cannot find input",
                5
        );

        WebElement title1 = waitForElementPresent(
                By.xpath("//*[contains(@text,'Automation')]"),
                "Cannot find 'Automation' in topics",
                20
        );
        String expectedTitle1 = title1.getAttribute("text");
        Assert.assertEquals(
                "unexpected title1",
                "Automation",
                expectedTitle1
        );
        WebElement title2 = waitForElementPresent(
                By.xpath("//*[contains(@text,'Automation Master')]"),
                "Cannot find 'Automation Master' in topics",
                20
        );
        String expectedTitle2 = title2.getAttribute("text");
        Assert.assertEquals(
                "unexpected title2",
                "Automation Master",
                expectedTitle2
        );

        waitForElementAndClick(
              By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageButton"),
             "Cannot find return button to cancel search",
          10
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/search_toolbar"),
                "search is not close",
                10
        );*/

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

    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

}

