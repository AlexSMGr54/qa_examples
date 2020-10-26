package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Класс содержит методы для ожидания событий с элементом
 */
public class WaitHelper {

    final private static int DEFAULT_TIMEOUT = 5;  //Время ожидания по-умолчанию

    /**
     * Ожидать пока элемент не станет видимым
     *
     * @param driver WebDriver страницы на которой ожидается элемент
     * @param locator Любой локатор типа By
     * @param timeout Максимальное время ожидания элемента в секундах
     * @return WebElement, если он стал видимым, в противном случае - null
     */
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.err.println("Элемент " + locator + " не стал видимым в течение " + timeout + "cекунд");
            return null;
        }
    }

    /**
     * Ожидать пока элемент не станет видимым
     * Время ожидания по-умолчанию - DEFAULT_TIMEOUT
     *
     * @param driver WebDriver страницы на которой ожидается элемент
     * @param locator Любой локатор типа By
     * @return WebElement, если он стал видимым, в противном случае - null
     */
    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return waitForElementToBeVisible(driver, locator, DEFAULT_TIMEOUT);
    }

    /**
     * Ожидать пока элемент не станет кликабельным
     *
     * @param driver WebDriver страницы на которой ожидается элемент
     * @param locator Любой локатор типа By
     * @param timeout Максимальное время ожидания элемента в секундах
     * @return WebElement, если он стал кликабельным, в противном случае - null
     */
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.err.println("Элемент " + locator + " не стал кликабельным в течение " + timeout + "cекунд");
            return null;
        }
    }

    /**
     * Ожидать пока элемент не станет кликабельным
     * Время ожидания по-умолчанию - DEFAULT_TIMEOUT
     *
     * @param driver WebDriver страницы на которой ожидается элемент
     * @param locator Любой локатор типа By
     * @return WebElement, если он стал кликабельным, в противном случае - null
     */
    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        return waitForElementToBeClickable(driver, locator, DEFAULT_TIMEOUT);
    }
}
