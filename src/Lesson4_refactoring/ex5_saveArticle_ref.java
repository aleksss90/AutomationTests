package Lesson4_refactoring;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ex5_saveArticle_ref extends CoreTestCase {
    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSaveArticleRef() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Kotlin");
        SearchPageObject.clickByArticleWithSubstring("Kotlin (programming language)");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.clickToSaveArticle();
            ArticlePageObject.addToMyListOverlay();
            ArticlePageObject.clearListName();
            ArticlePageObject.addArticleToMyList("To read later");
            ArticlePageObject.clickOkSaveMyList();
            ArticlePageObject.clickToSaveArticle();
            ArticlePageObject.addToMyListOverlay();
            ArticlePageObject.clearListName();
            ArticlePageObject.addArticleToMyList("To read later");
            ArticlePageObject.clickOkSaveMyList();
            ArticlePageObject.closeArticle();
        } else {
            ArticlePageObject.addAtrticleToSavedIOS();
            ArticlePageObject.clickToSaveArticle();
            ArticlePageObject.addNameList("iOS reading list");
            ArticlePageObject.clickToCreateListIOS();//пыщ создать
            ArticlePageObject.closeArticle();//закрыли статью
            SearchPageObject.clearSearchField();
        }

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Football");
        SearchPageObject.clickByArticleWithSubstring("Football competition");
        if (Platform.getInstance().isAndroid()) {
            ArticlePageObject.clickToSaveArticle();
            ArticlePageObject.saveArticleInFolder("To read later");
            ArticlePageObject.closeArticle();
        } else {
            ArticlePageObject.addAtrticleToSavedIOS();
            ArticlePageObject.choseFolderSavedLists();
            ArticlePageObject.clickToHomePage();
        }

        NavigationUI NavigationUI = new NavigationUI(driver);
        if (Platform.getInstance().isAndroid()) {
            NavigationUI.clickMyList();
        } else {
            ArticlePageObject.openSavedArticles();
            ArticlePageObject.clickSavedList();
            ArticlePageObject.choseFolderSavedLists();
        }

        MyListPageObject MyListPageObject = new MyListPageObject(driver);
        if (Platform.getInstance().isAndroid()) {
            MyListPageObject.openFolder();
            MyListPageObject.swipeToDeleteArticle("Kotlin (programming language)");
            MyListPageObject.waitForArticleTitle("Football competition");
            MyListPageObject.clickOnArticle("Football");
            MyListPageObject.checkToRightTitle("Football");
        } else {
            MyListPageObject.swipeToDeleteArticle("Football at the Summer Olympics");
        }
    }
}
