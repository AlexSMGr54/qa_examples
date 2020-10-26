package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    final protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
