package Lesson4_refactoring;

import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Test;

public class ex5_saveArticle_ref extends CoreTestCase {
    private lib.ui.MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSaveArticleRef() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Kotlin");
        SearchPageObject.clickByArticleWithSubstring("Kotlin (programming language)");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.clickToSaveArticle();
        ArticlePageObject.addToMyListOverlay();
        ArticlePageObject.clearListName();
        ArticlePageObject.addArticleToMyList("To read later");
        ArticlePageObject.clickOkSaveMyList();
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Football");
        SearchPageObject.clickByArticleWithSubstring("Team sports that involve, to varying degrees, kicking a ball to score a goal");

        ArticlePageObject.clickToSaveArticle();
        ArticlePageObject.saveArticleInFolder("To read later");
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyList();

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        MyListPageObject.openFolder();
        MyListPageObject.swipeToDeleteArticle("programming language");
        MyListPageObject.waitForArticleTitle("Team sports that involve, to varying degrees, kicking a ball to score a goal");
        MyListPageObject.clickOnArticle("Football");
        MyListPageObject.checkToRightTitle("Football");
    }
}
