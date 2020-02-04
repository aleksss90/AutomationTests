package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            SAVE_ARTICLE,
            SAVE_ARTICLE_TO_FOLDER_TPL,
            ADD_TO_MY_LIST_OVERLAY,
            LIST_NAME_INPUT,
            LIST_OK_BUTTON,
            SAVED_ARTICLES,
            CREATE_NEW_LIST,
            ADD_NAME_SAVED_LIST,
            BUTTON_CREATE_LIST,
            BACK_TO_HOME_PAGE,
            SAVED_LIST,
            BUTTON_READING_LISTS,
            CLOSE_ARTICLE;


    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void clickSavedList() {
        this.waitForElementAndClick(
                BUTTON_READING_LISTS,
                "Cannot find button reading list",
                25
        );
    }

    public void choseFolderSavedLists() {
        this.waitForElementAndClick(
                SAVED_LIST,
                "Cannot find and choose my reading lists",
                25
        );
    }

    public void clickToCreateListIOS() {
        this.waitForElementAndClick(
                BUTTON_CREATE_LIST,
                "Cannot find button to create reading list",
                25
        );
    }

    public void clickToHomePage() {
        this.waitForElementAndClick(
                BACK_TO_HOME_PAGE,
                "Cannot find button to go homepage",
                40
        );
    }

    public void clickToSaveArticle() {
        this.waitForElementAndClick(
                CREATE_NEW_LIST,
                "Cannot find button to create new reading list",
                25
        );
    }

    public void addNameList(String search_line) {
        this.waitForElementAndSendKeys(
                ADD_NAME_SAVED_LIST,
                search_line,
                "Cannot put text for named reading list",
                25
        );
    }

    public void clickToCreateList() {
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

    private static String saveFolderName(String folder_name) {
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

    public void addArticlesToMySaved() {
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY, "", 15);
    }

    public void addAtrticleToSavedIOS() {
        this.waitForElementAndLongClick(ADD_TO_MY_LIST_OVERLAY, "fail", 15);
    }

    public void openSavedArticles() {
        this.waitForElementAndClick(SAVED_ARTICLES, "fail open saved lists", 15);
    }

}