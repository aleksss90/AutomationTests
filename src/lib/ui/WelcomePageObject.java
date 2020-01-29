package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {
    private static final String
    STEP_LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
    PUSH_BUTTON_SKIP = "xpath://XCUIElementTypeStaticText[@name='Skip']";
public  WelcomePageObject(AppiumDriver driver)
{
    super(driver);
}
public void waitForLearnMoreLink()
{
    this.waitForElementPresent(STEP_LEARN_MORE_LINK,"Cannot find Learn more about Wikipedia",10);
}
    public void clickSkipButton()
    {
        this.waitForElementAndClick(PUSH_BUTTON_SKIP,"Cannot find button Skip",10);
    }
}
