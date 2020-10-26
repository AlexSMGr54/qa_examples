package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


/**
 * Класс содержит методы для взаимодействия с элементами
 */
public class ActionsHelper {

    /**
     * Кликнуть по элементу
     *
     * @param element WebElement по которому необходимо кликнуть
     * @return true, если удалось кликнуть по элементу, в противном случае - false
     */
    public static boolean clickOnElement(WebElement element) {
        try {
            element.click();
            return true;
        } catch (Exception e) {
            System.err.println("Не удалось кликнуть по элементу");
            return false;
        }
    }

    /**
     * Ввести текст в элемент
     *
     * @param element WebElement в который неоходимо ввести текст
     * @param text Текст для ввода
     * @return true, если текст удалось ввести, в противном случае - false
     */
    public static boolean writeToElement(WebElement element, String text) {
        try {
            element.sendKeys(Keys.LEFT_CONTROL + "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(text);
            return true;
        } catch (Exception e) {
            System.err.println("Не удалось ввести текст");
            return false;
        }
    }

    /**
     * Получить текст из элемента
     *
     * @param element WebElement из которого необходимо получить текст
     * @return Текст, если его удалось получить, в противном случае - null
     */
    public static String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e){
            System.err.println("Не удалось получить текст из элемента");
            return null;
        }
    }

    /**
     * Получить значение с плавающей точкой из элемента
     *
     * @param element WebElement из которого необходимо получить значение с плавающей точкой
     * @return float, если его удалось получить, в противном случае - null
     */
    public static Float getFloatFromElement(WebElement element) {
        try {
            return Float.parseFloat(element.getText().replace(",", "."));
        } catch (Exception e){
            System.err.println("Не удалось получить значение с плавающей точкой из элемента");
            return null;
        }
    }
}
