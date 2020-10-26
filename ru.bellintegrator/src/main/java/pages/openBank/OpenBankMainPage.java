package pages.openBank;

import elements.BaseElement;
import helpers.ActionsHelper;
import helpers.FindHelper;
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
        List<WebElement> resultsList = FindHelper.findElements(
                currencyCourseContext.getElement(),
                By.xpath("//tr[@class='main-page-exchange__row main-page-exchange__row--with-border']"));

        if (resultsList != null) {
            for (WebElement element : resultsList) {
                String result = ActionsHelper.getTextFromElement(
                        FindHelper.findElement(
                                element,
                                By.xpath("td/descendant::span[contains(@class, 'largeText')]"))
                );
                if (result != null && result.equals(currencyName)) {
                    currencyBuy = ActionsHelper.getFloatFromElement(
                            FindHelper.findElement(element, By.xpath("td[2]")));
                    currencySell = ActionsHelper.getFloatFromElement(
                            FindHelper.findElement(element, By.xpath("td[4]")));
                    return true;
                }
            }
        }
        return false;
    }
}
