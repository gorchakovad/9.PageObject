package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle(){
        return driver.findElement(By.className("display-6")).getText();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
