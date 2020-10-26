package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Класс содержит методы для поиска элементов
 */
public class FindHelper {

    /**
     * Искать элемент в контексте
     *
     * @param context Контекст в котором выполняется поиск элемента.
     *                Вкачестве контекста может использоваться как
     *                WebElement, в котором необходимо найти вложенный
     *                элемент, так и WebDriver
     * @param locator Любой локатор типа By
     * @return WebElement, если он был найден, в противном случае - null
     */
    public static WebElement findElement(SearchContext context, By locator) {
        try {
            return context.findElement(locator);
        } catch (Exception e) {
            System.err.println("Не удалось найти элемент - " + locator.toString());
            return null;
        }
    }

    /**
     * Искать элементы в контексте
     *
     * @param context Контекст в котором выполняется поиск элементов.
     *                Вкачестве контекста может использоваться как
     *                WebElement, в котором необходимо найти вложенные
     *                элементы, так и WebDriver
     * @param locator Любой локатор типа By
     * @return Список WebElement, если был найден хотя бы один элемент, в противном случае - null
     */
    public static List<WebElement> findElements(SearchContext context, By locator) {
        try {
            return context.findElements(locator);
        } catch (Exception e) {
            System.err.println("Не удалось найти элементы - " + locator.toString());
            return null;
        }
    }
}
