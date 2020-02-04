package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        SAVE_ARTICLE = "xpath://android.widget.ImageView[@content-desc='Add this article to a reading list']";
        //SAVE_ARTICLE = "id:Add this article to a reading list";
        SAVE_ARTICLE_TO_FOLDER_TPL = "xpath://*[@resource-id='org.wikipedia:id/item_title'][@text='{FOLDER_NAME}']";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
