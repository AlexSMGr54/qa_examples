package steps.googleSearch;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import pages.googleSearch.GoogleSearchResultsPage;
import steps.BaseStep;
import steps.Helper;

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
