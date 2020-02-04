package Lesson4_refactoring;

import lib.CoreTestCase;
import lib.ui.MyListPageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ex6_assertElement_ref extends CoreTestCase {
    @Test
    public void testAssertElementRef() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("The Witcher");
        SearchPageObject.clickByArticleWithSubstring("The Witcher (TV series)");

        lib.ui.MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.checkAvailabilityTitle();
    }
}
