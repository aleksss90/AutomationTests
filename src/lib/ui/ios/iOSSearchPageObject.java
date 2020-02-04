package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "id:Search Wikipedia";
        SEARCH_INPUT = "id:Search Wikipedia";
        SEARCH_CANCEL_BUTTON = "xpath://XCUIElementTypeButton[@name='Cancel']";
        SEARCH_ARTICLES_IN_SAVED_LISTS = "id:Kotlin (programming language)";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name,'{SUBSTRING}')]";
        //XCUIElementTypeLink[@name="Kotlin (programming language) General-purpose programming language"]

    }

    public iOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
