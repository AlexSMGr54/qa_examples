package ui.elements;

import ui.helpers.ActionsHelper;
import ui.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonElement extends BaseElement {

    public ButtonElement(By locator, WebDriver driver) { super(locator, driver); }

    public void push() {
        element = WaitHelper.waitForElementToBeClickable(driver, getLocator());
        ActionsHelper.clickOnElement(element);
    }

    /*
    Тут можно дописать дополнительные методы для элемента
    Например - навести курсор на кнопку, зажать кнопку, отпустить кнопку и т.д.
     */
}
