package steps.ui.googleSearch;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ui.pages.googleSearch.GoogleSearchResultsPage;
import steps.ui.BaseStep;
import steps.ui.Helper;

public class GoogleSearchResultPageSteps extends BaseStep {

    private final GoogleSearchResultsPage page = new GoogleSearchResultsPage(driver);

    @Когда("Пользователь на странице с результатом поиска Google переходит на найденный ресурс")
    public void openLink() {
        page.lnkResult.click();
    }

    @Тогда("На странице с результатами поиска присутствует - {string}")
    public void resultsIsPresent(String text) {
        Helper.customAssert("Искомый результат отсутствует на странице",
                page.findInResults(text),
                driver);
    }

    /*
    Тут можно дописать методы для взаимодействия с элементами доступными на всех страницах
     */
}
