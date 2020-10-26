package steps.googleSearch;

import io.cucumber.java.ru.Когда;
import pages.googleSearch.GoogleSearchMainPage;
import steps.BaseStep;

public class GoogleSearchMainPageSteps extends BaseStep {

    private final GoogleSearchMainPage page = new GoogleSearchMainPage(driver);

    @Когда("Пользователь на странице Google подтверждает поиск")
    public void search() {
        page.btnSearch.push();
    }

    /*
    Тут можно дописать методы для взаимодействия с элементами доступными на главной странице
     */
}
