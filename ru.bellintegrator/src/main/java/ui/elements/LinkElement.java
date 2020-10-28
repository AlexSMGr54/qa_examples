package ui.elements;

import ui.helpers.ActionsHelper;
import ui.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkElement extends BaseElement {

    public LinkElement(By locator, WebDriver driver) { super(locator, driver); }

    public void click() {
        element = WaitHelper.waitForElementToBeClickable(driver, getLocator());
        ActionsHelper.clickOnElement(element);
    }

    /*
    Тут можно дописать дополнительные методы для элемента
    Например - получить текст ссылки, получить url ссылки и т.д.
     */
}
