package steps.ui.openBank;

import io.cucumber.java.ru.Тогда;
import ui.pages.openBank.OpenBankMainPage;
import steps.ui.BaseStep;


public class OpenBankMainPageSteps extends BaseStep {

    private final OpenBankMainPage page = new OpenBankMainPage(driver);

    @Тогда("На странице банка 'Открытие' присутствует курс для - {string}")
    public void getExchangeRate(String currency) {
        customAssert("На странице отсутствует курс для " + currency,
                page.getExchangeRate(currency),
                driver);
    }

    @Тогда("На странице банка 'Открытие' курс покупки должен быть меньше курса продажи")
    public void compareRate() {
        customAssert("Курс покупки больше или равен курсу продажи",
                page.currencyBuy < page.currencySell,
                driver);
    }

}
