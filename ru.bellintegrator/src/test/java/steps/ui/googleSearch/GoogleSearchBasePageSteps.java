package steps.ui.googleSearch;

import io.cucumber.java.ru.Когда;
import ui.pages.googleSearch.GoogleSearchBasePage;
import steps.ui.BaseStep;

public class GoogleSearchBasePageSteps extends BaseStep {

    private final GoogleSearchBasePage page = new GoogleSearchBasePage(driver);

    @Когда("Пользователь на странице Google выполняет поиск по ключевому слову - {string}")
    public void search(String text) {
        page.fldSearch
                .type(text);
    }

    /*
    Тут можно дописать методы для взаимодействия с элементами доступными на всех страницах
     */
}
