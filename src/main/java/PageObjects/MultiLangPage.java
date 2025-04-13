package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiLangPage {
    WebDriver driver;

    public MultiLangPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get the TITLE")
    public String getTitle(){
        return driver.findElement(By.className("display-6")).getText();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
