package lib.ui;

import io.appium.java_client.AppiumDriver;

public class ArticlePageObject extends MainPageObject {
    private static final String
            SAVE_ARTICLE = "xpath://android.widget.ImageView[@content-desc='Add this article to a reading list']",
            //SAVE_ARTICLE = "id:Add this article to a reading list",
            SAVE_ARTICLE_TO_FOLDER_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            LIST_OK_BUTTON = "xpath://*[@text='OK']",
            CLOSE_ARTICLE = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickToSaveArticle() {
        this.waitForElementAndClick(
                SAVE_ARTICLE,
                "Cannot find button to add in reading list",
                25
        );
    }

    public void addToMyListOverlay() {
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                25
        );
    }

    public void clearListName() {
        this.waitForElementAndClear(
                LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                25
        );
    }

    public void addArticleToMyList(String search_line) {
        this.waitForElementAndSendKeys(
                LIST_NAME_INPUT,
                search_line,
                "Cannot put text into article folder input",
                25
        );
    }

    public void clickOkSaveMyList() {
        this.waitForElementAndClick(
                LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE,
                "Cannot close article",
                5
        );
    }
    private static String saveFolderName (String folder_name) {
        return SAVE_ARTICLE_TO_FOLDER_TPL.replace("{FOLDER_NAME}", folder_name);
    }
    public void saveArticleInFolder(String folder_name) {
        String FolderName = saveFolderName(folder_name);
        this.waitForElementAndClick(
                FolderName,
                "Cannot find option to add article to reading list",
                10
        );
    }
}