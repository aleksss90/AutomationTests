package Lesson4_refactoring;

import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;


public class ex3_cancellationSearch_ref extends CoreTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testCancellationSearch() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Automation");
        SearchPageObject.waitForSearchResult("Automation Master");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clearSearchField();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }
}

