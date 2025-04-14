package ui;

import PageObjects.FramesPage;
import PageObjects.HomePage;
import PageObjects.MultiLangPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static PageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests extends BaseTest {


    @Test
    @DisplayName("Проверка URL'а главной")
    void urlHomePage() {
        HomePage homePage = new HomePage(driver);

        assertEquals(BASE_URL, homePage.getCurrentUrl());
    }

    @ParameterizedTest
    @DisplayName("Проверки открытия страниц и их тайтлов")
    @CsvFileSource(resources = "/openPagesSource.csv")
    void openPagesTests(String chapterName, String path, String title) {
        HomePage homePage = new HomePage(driver);

        driver.findElement(By.xpath("//h5[text() = '" + chapterName + "']/../a[@href = '" + path + "']")).click();

        String actualUrl = homePage.getCurrentUrl();
        String actualTitle = homePage.getTitle().getText();

        assertEquals(BASE_URL + path, actualUrl, "URLs don't match");
        assertEquals(title, actualTitle, "Titles don't match");
    }

    @Test
    @DisplayName("Проверка страницы Multilanguage page")
    void multilanguagePageTest() {
        HomePage homePage = new HomePage(driver);
        MultiLangPage multiLangPage = homePage.openMultiLangPage();

        String actualUrl = multiLangPage.getCurrentUrl();
        String actualTitle = multiLangPage.getTitle().getText();

        assertEquals(BASE_URL + "multilanguage.html", actualUrl, "URLs don't match");
        assertEquals("", actualTitle, "Titles don't match");
        assertEquals("Hands-On Selenium WebDriver with Java",multiLangPage.getWebTitle(), "Titles don't match");
    }

    @ParameterizedTest
    @DisplayName("Проверка фреймов")
    @CsvSource({"frames.html, Frames"})
    void frameTests(String path, String title) {
        HomePage homePage = new HomePage(driver);
        FramesPage framesPage = homePage.openFramesPage();

        WebElement frame = driver.findElement(By.cssSelector("frame[name='frame-header']"));
        driver.switchTo().frame(frame);

        assertEquals(BASE_URL + path, framesPage.getCurrentUrl(), "URLs don't match");
        assertEquals(title, framesPage.getTitle().getText(), "Titles don't match");
        assertEquals("Hands-On Selenium WebDriver with Java",framesPage.getWebTitle(), "Titles don't match");
    }
}
