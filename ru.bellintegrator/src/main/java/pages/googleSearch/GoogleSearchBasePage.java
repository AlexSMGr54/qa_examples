package pages.googleSearch;

import elements.InputElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class GoogleSearchBasePage extends BasePage {

    public GoogleSearchBasePage(WebDriver driver) { super(driver); }

    public InputElement fldSearch = new InputElement(By.xpath("//input[@name='q']"), driver);

    /*
    Тут можно добавить остальные элементы, доступные на всех страницах google
    Например - кнопка "Войти", кнопка "Приложения", экранная клавиатура,  ссылки в футере и т.д.
     */
}
