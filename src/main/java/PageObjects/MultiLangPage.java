package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultiLangPage extends BasePage {

    public MultiLangPage(WebDriver driver) {
        super(driver);
    }
    @Step("Get web title")
    public String getWebTitle() {
        return driver.getTitle();
    }
}
