package ui.pages.openBank;

import ui.elements.BaseElement;
import ui.helpers.ActionsHelper;
import ui.helpers.FindHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OpenBankMainPage extends OpenBankBasePage {

    public OpenBankMainPage(WebDriver driver) { super(driver); }

    final private BaseElement currencyCourseContext = new BaseElement(By.xpath(
            "//div[@data-react-class='MainPageInfo']/descendant::div[contains(@class, 'main-page-exchange')]"),
            driver);

    public float currencyBuy;
    public float currencySell;

    //Метод необходим для инициализации переменных currencyBuy и currencySell для указанной валюты
    public boolean getExchangeRate(String currencyName) {
        List<WebElement> resultsTableContent = FindHelper.findElements(
                currencyCourseContext.getElement(),
                By.xpath("//tr[@class='main-page-exchange__row main-page-exchange__row--with-border']"));
        WebElement resultsTableHeader = FindHelper.findElement(
                currencyCourseContext.getElement(),
                By.xpath("//tr[@class='main-page-exchange__table-header']"));

        if (resultsTableContent != null && resultsTableHeader != null) {

            Integer currencyBuyCol = null;
            Integer currencySellCol = null;

            List<WebElement> tableCol = FindHelper.findElements(resultsTableHeader, By.tagName("td"));
            for (int i = 0; i < tableCol.size(); i++) {
                if (ActionsHelper.getTextFromElement(tableCol.get(i)).contains("Банк покупает")) {
                    currencyBuyCol = i + 1;
                } else if (ActionsHelper.getTextFromElement(tableCol.get(i)).contains("Банк продает")) {
                    currencySellCol = i + 1;
                }
            }

            for (WebElement element : resultsTableContent) {
                String result = ActionsHelper.getTextFromElement(
                        FindHelper.findElement(
                                element,
                                By.xpath("td/descendant::span[contains(@class, 'largeText')]"))
                );
                if (result != null && result.equals(currencyName)) {
                    currencyBuy = ActionsHelper.getFloatFromElement(
                            FindHelper.findElement(element, By.xpath("td[" + currencyBuyCol + "]")));
                    currencySell = ActionsHelper.getFloatFromElement(
                            FindHelper.findElement(element, By.xpath("td[" + currencySellCol + "]")));
                    System.out.println(currencyBuy);
                    System.out.println(currencySell);
                    return true;
                }
            }
        }
        return false;
    }
}
