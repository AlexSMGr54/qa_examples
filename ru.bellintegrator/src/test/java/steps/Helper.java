package steps;


import io.cucumber.java.After;
import io.cucumber.java.ru.Допустим;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Helper extends BaseStep {

    @Допустим("Пользователь открывает браузер - {string}")
    public void openBrowser(String browserName) {
        switch (browserName) {
            case "Mozilla FireFox":
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "target\\browser.log");

                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                break;
            case "Google Chrome":
                //Тут добавить инициализацию хрома
                break;
        }

    }

    @Допустим("Пользователь переходит на страницу - {string}")
    public void goTo(String url) {
        driver.get(url);
    }

    @After()
    public void tearDown() { driver.quit(); }
}
