package Lesson3;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ScreenOrientation;

import java.net.URL;

import org.junit.Assert;


public class Test3_rotateScreen {
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
        driver.rotate((ScreenOrientation.PORTRAIT));
    }

    @After
    public void tearDown() {
        driver.rotate((ScreenOrientation.PORTRAIT));
        driver.quit();
    }

    @Test
    public void rotate1() {
        String name1_of_folder = "Kotlin (programming language)";
        String search_line = "Kotlin";

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + name1_of_folder + "']"),
                "Cannot find article Kotlin",
                10
        );
        String title_before_rotation = waitForElementAndGetAttribute
                (
                        By.id("org.wikipedia:id/view_page_title_text"),
                        "text",
                        "Cannot find title of article before rotation",
                        15
                );

        driver.rotate((ScreenOrientation.LANDSCAPE));

        String title_after_rotation = waitForElementAndGetAttribute
                (
                        By.id("org.wikipedia:id/view_page_title_text"),
                        "text",
                        "Cannot find title of article after rotation",
                        15
                );

        Assert.assertEquals(
                "Article title have been changed after rotation",
                title_before_rotation,
                title_after_rotation
        );

        driver.rotate((ScreenOrientation.PORTRAIT));

        String title_after_second_rotation = waitForElementAndGetAttribute
                (
                        By.id("org.wikipedia:id/view_page_title_text"),
                        "text",
                        "Cannot find title of article",
                        15
                );

        Assert.assertEquals(
                "Article title have been changed after second rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }

    //
    @Test
    public void rotate2() {
        String name2_of_folder = "Football";

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                name2_of_folder,
                "Cannot find input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='" + name2_of_folder + "']"),
                "Cannot find article Football",
                10
        );
        String title_before_rotation = waitForElementAndGetAttribute
                (
                        By.id("org.wikipedia:id/view_page_title_text"),
                        "text",
                        "Cannot find title of article before rotation",
                        15
                );

        driver.rotate((ScreenOrientation.LANDSCAPE));

        String title_after_rotation = waitForElementAndGetAttribute
                (
                        By.id("org.wikipedia:id/view_page_title_text"),
                        "text",
                        "Cannot find title of article after rotation",
                        15
                );

        Assert.assertEquals(
                "Article title have been changed after rotation",
                title_before_rotation,
                title_after_rotation
        );

        driver.rotate((ScreenOrientation.PORTRAIT));

        String title_after_second_rotation = waitForElementAndGetAttribute
                (
                        By.id("org.wikipedia:id/view_page_title_text"),
                        "text",
                        "Cannot find title of article",
                        15
                );

        Assert.assertEquals(
                "Article title have been changed after second rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }
}
