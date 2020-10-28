package ui.pages.googleSearch;

import ui.elements.ButtonElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchMainPage extends GoogleSearchBasePage {

    public GoogleSearchMainPage(WebDriver driver) { super(driver); }

    public ButtonElement btnSearch = new ButtonElement(
            By.xpath("//div[contains(@class,'emcav')]/descendant::input[@value='Поиск в Google']"), driver);

    /*
    Тут можно добавить остальные элементы расположенные на главной странице
    Например - кнопка "Мне повезёт!", ссылка "Пожаловаться" и т.д.
     */
}
