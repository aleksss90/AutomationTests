package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class AndroidSearchPageObject extends SearchPageObject {
    private static final String
            SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/search_container",
            SEARCH_INPUT = "id:org.wikipedia:id/search_src_text",
            SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[contains(@text,'{SUBSTRING}')]";
        public AndroidSearchPageObject(AppiumDriver driver)
        {
            super(driver);
        }
    }
