package ui.elements;

import ui.helpers.ActionsHelper;
import ui.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseElement {

    protected By locator;
    protected WebDriver driver;
    protected WebElement element;

    public BaseElement(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    /**
     * Получить локатор элемента
     *
     *@return возвращает локатор элемента
     */
    public By getLocator() {
        return locator;
    }

    /**
     * Получить элемент
     *
     * @return возвращает элемент
     */
    public WebElement getElement() {
        return WaitHelper.waitForElementToBeVisible(driver, locator);
    }

    /**
     * Получить текст элемента
     *
     *@return возвращает текст элемента
     */
    public String getText() {
        element = WaitHelper.waitForElementToBeVisible(driver, locator);
        return ActionsHelper.getTextFromElement(element);
    }
}
