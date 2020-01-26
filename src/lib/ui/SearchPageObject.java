package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {
    private static final String
            SEARCH_INIT_ELEMENT = "org.wikipedia:id/search_container",
            SEARCH_INPUT = "org.wikipedia:id/search_src_text",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[contains(@text,'{SUBSTRING}')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(By.id(SEARCH_INIT_ELEMENT), "Cannot find Search Wikipedia input", 5);
        this.waitForElementPresent(By.id(SEARCH_INIT_ELEMENT), "Cannot find input", 5);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.id(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public String waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result with substring " + substring, 5);
        return search_result_xpath;
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(By.id(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear() {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still on the page", 5);
    }

    public void clearSearchField() {
        this.waitForElementAndClear(By.id(SEARCH_INPUT), "Cannot find and type into search input", 10);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click article " + substring, 10);
    }
}
