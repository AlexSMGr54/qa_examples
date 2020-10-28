package ui.pages.googleSearch;

import ui.elements.BaseElement;
import ui.elements.LinkElement;
import ui.helpers.ActionsHelper;
import ui.helpers.FindHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class GoogleSearchResultsPage extends GoogleSearchBasePage {

    public GoogleSearchResultsPage(WebDriver driver) { super(driver); }

    final private BaseElement searchResultContext = new BaseElement(By.xpath("//div[@id='search']"), driver);

    public LinkElement lnkResult = null;

    //Метод необходим для инициализации целевой ссылки
    public boolean findInResults(String text) {
        List<WebElement> resultsList = FindHelper.findElements(
                searchResultContext.getElement(),
                By.xpath("//div[@class='g']"));

        if (resultsList != null) {
            for (int i = 0; i < resultsList.size(); i++) {

                String result = ActionsHelper.getTextFromElement(
                        FindHelper.findElement(resultsList.get(i), By.tagName("a")));

                if (result != null && result.contains(text)) {
                    i++;
                    lnkResult = new LinkElement(By.xpath("//div[@class='g' and " + i + "]/descendant::a"), driver);
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Тут можно добавить другие элементы на странице с результатами поиска
    Например - Описание к найденным результатам, настройки поиска и т.д.
     */
}
