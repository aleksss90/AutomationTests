package Lesson4_refactoring;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;


public class ex3_cancellationSearch_ref extends CoreTestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testCancellationSearch() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Automation");
        SearchPageObject.waitForSearchResult("Automation Master");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clearSearchField();
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();
    }
}

