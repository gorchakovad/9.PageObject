package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }
    @Step("Get web title")
    public String getWebTitle() {
        return driver.getTitle();
    }
}
