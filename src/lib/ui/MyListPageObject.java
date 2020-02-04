package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

public class MyListPageObject extends MainPageObject {
    public static final String
            MY_FOLDER = "id:org.wikipedia:id/item_title",
            SEARCH_TITLE_TEXT__TPL = "xpath://*[@resource-id='org.wikipedia:id/view_page_title_text'][@text='{NAME}']",
            ARTICLE_TITLE_TPL = "xpath://*[@text='{ARTICLE}']",
            ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[@name='{TITLE}']",
            ARTICLE_ITEM_DESCRIPTION_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{DESCRIPTION}']",
            TITLE_ELEMENT = "id:org.wikipedia:id/view_page_title_text";

    private static String getSavedItemDescription(String item_description) {
        return ARTICLE_ITEM_DESCRIPTION_TPL.replace("{DESCRIPTION}", item_description);
    }

    public MyListPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolder() {
        this.waitForElementAndClick(
                MY_FOLDER,
                "Cannot find created folder",
                10
        );
    }

    private static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public void waitForArticleToAppearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article by title: " + article_title, 15);
    }

    public void waitForArticleToDisappearByTitle(String article_title) {
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title: " + article_title, 10);
    }

    public void swipeToDeleteArticle(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedArticleXpathByTitle(article_title);
        this.swipeElementToLeft(article_xpath, "Cannot find saved article: " + article_title);
        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article: " + article_title);
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    private static String getArticleItemDescription(String article_title) {
        return ARTICLE_TITLE_TPL.replace("{ARTICLE}", article_title);
    }

    public void waitForArticleTitle(String article_title) {
        String search_article_xpath = getArticleItemDescription(article_title);
        this.waitForElementNotPresent(
                search_article_xpath,
                "Cannot find remaining article",
                10
        );
    }

    public void clickOnArticle(String article_title) {
        String search_article_xpath = getArticleItemDescription(article_title);
        this.waitForElementAndClick(
                search_article_xpath,
                "Cannot click created folder",
                10
        );
    }

    private static String getResultSearchElement(String name_title) {
        return SEARCH_TITLE_TEXT__TPL.replace("{NAME}", name_title);
    }

    public void checkToRightTitle(String name_title) {
        String name_title_xpath = getResultSearchElement(name_title);
        this.waitForElementPresent(name_title_xpath, "Cannot find article " + name_title, 25);
    }

    public void checkAvailabilityTitle() {
        this.assertElementPresent(TITLE_ELEMENT, "Cannot find article title");
    }


}
