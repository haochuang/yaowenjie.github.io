package com.wenjie.blog;

import com.wenjie.blog.pages.HomePage;
import com.wenjie.blog.pages.PostPage;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePageTest{
    FirefoxDriver driver = new FirefoxDriver();
    HomePage homePage = initElements(driver, HomePage.class);
    PostPage postPage = initElements(driver, PostPage.class);

    @Test
    public void shouldClickSearchButtonAndGoToAnArticle() throws InterruptedException {
        driver.get("http://localhost:4000");

        homePage.searchKeywordAndEnterPost("Powershell");

        assertContainsIngoreCase(postPage.getArticleTitle(), "Powershell");
        driver.close();
    }

    public void assertContainsIngoreCase(String set, String subset) {
        assertThat(set.toLowerCase(), containsString(subset.toLowerCase()));
    }

}