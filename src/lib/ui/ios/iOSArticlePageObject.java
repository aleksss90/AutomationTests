package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {

    static {
        SAVE_ARTICLE = "id:Kotlin (programming language)";
        //OPTIONS_ADD_TO_MY_LIST = "id:Save for later";
        ADD_TO_MY_LIST_OVERLAY = "id:Save for later";
        CLOSE_ARTICLE = "id:Back";
        SAVED_ARTICLES = "id:Saved";
        //SAVED_ARTICLES = "xpath://XCUIElementTypeButton[@name='Saved']";

        CREATE_NEW_LIST = "xpath://XCUIElementTypeButton[@name='Create a new list']";
        BACK_TO_HOME_PAGE = "id:Wikipedia, return to Explore";
        //BACK_TO_HOME_PAGE = "xpath://XCUIElementTypeButton[@name='Wikipedia, return to Explore']";
        ADD_NAME_SAVED_LIST = "xpath://XCUIElementTypeApplication[@name='Wikipedia']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeTextField";
        BUTTON_CREATE_LIST = "xpath://XCUIElementTypeButton[@name='Create reading list']";
        BUTTON_READING_LISTS = "xpath://XCUIElementTypeButton[@name='Reading lists']";
        SAVED_LIST = "id:iOS reading list";
    }

    public iOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

}
