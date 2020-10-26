package elements;

import helpers.ActionsHelper;
import helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputElement extends BaseElement {

    public InputElement(By locator, WebDriver driver) { super(locator, driver); }


    public InputElement type(String text) {
        element = WaitHelper.waitForElementToBeClickable(driver, getLocator());
        ActionsHelper.writeToElement(element, text);
        return this;
    }

    /*
    Тут можно написать дополнительные методы для элемента.
    Например - Получить плейсхолдер в элементе, очистить элемент и т.д.
     */
}
