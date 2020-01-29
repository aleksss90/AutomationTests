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

public class Test1_saveArticles {
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
        String name1_of_folder ="Kotlin (programming language)";
        String name2_of_folder ="Football";

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_container"),
                "Cannot find Search Wikipedia input",
                10
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Kotlin",
                "Cannot find input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='"+name1_of_folder+"']"),
                "Cannot find article Kotlin",
                10
        );
        //!!!
        waitForElementPresent(
                By.xpath("//*[@content-desc='"+name1_of_folder+"']"),
                "Cannot find article Kotlin in page",
                10
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to add in reading list",
                10
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot skip info menu about reading lists",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Saved']"),
                "Cannot find button saved articles",
                10
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article because not find button back",
                5
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/dialog_checkbox"),
                "Cannot find checkbox do not remind later",
                10
        );

        waitForElementAndClick(
                By.id("android:id/button2"),
                "Cannot find button 'No thanks' to skip tutorial",
                10
        );
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
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='"+name2_of_folder+"']"),
                "Cannot find article Football",
                10
        );
        waitForElementPresent(
                By.xpath("//*[@content-desc='"+name2_of_folder+"']"),
                "Cannot find article Football in page",
                10
        );
        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to add in reading list",
                10
        );
        waitForElementAndClick(
                By.xpath("//*[@text='Saved']"),
                "Cannot find button saved articles",
                10
        );
        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article because not find button back",
                5
        );
        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find button 'My lists'",
                10
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/item_title"),
                "Cannot find 'Saved' articles ",
                5
        );
        /*swipeElementToLeft(
                By.xpath("//*[@text='"+name1_of_folder+"']"),
                "Cannot swipe to delete Kotlin (programming language)"
        );*/

        waitForElementNotPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='"+name1_of_folder+"']"),
                "not delete article Kotlin (programming language)",
                5
        );
        waitForElementPresent(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='"+name2_of_folder+"']"),
                "article Football is still on saved list",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='"+name2_of_folder+"']"),
                "Cannot find article Football",
                10
        );
        waitForElementPresent(
                By.xpath("//*[@content-desc='"+name2_of_folder+"']"),
                "Cannot find article Football in page",
                10
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

        private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(by)
            );
        }
    /*protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action
                .press(right_x, middle_y)
                .waitAction(300)
                .moveTo(left_x, middle_y)
                .release()
                .perform();
    }*/
}
