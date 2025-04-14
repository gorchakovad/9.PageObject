package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    @Step("Open homepage")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Open multiLang page")
    public MultiLangPage openMultiLangPage() {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 5. Browser-Specific Manipulation']/../a[@href = 'multilanguage.html']")).click();
        return new MultiLangPage(driver);
    }

    @Step("Open frames page")
    public FramesPage openFramesPage() {
        driver.findElement(By.xpath("//h5[text() = 'Chapter 4. Browser-Agnostic Features']/../a[@href = 'frames.html']")).click();
        return new FramesPage(driver);
    }

}
