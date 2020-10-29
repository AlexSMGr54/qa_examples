package steps.rest.reqres;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import rest.dto.reqres.listUsers.ListUsersDTO;
import rest.requests.reqres.ReqresListUsersRequest;

import java.util.HashMap;
import java.util.Map;


public class ReqresListUsersRequestSteps {

    private RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("https://reqres.in")
            .setPort(443)
            .build();

    private Map<String, String> parameters = new HashMap<>();
    private ReqresListUsersRequest listUsersRequest = new ReqresListUsersRequest(spec, parameters);
    private Response usersListResponse;
    ListUsersDTO listUsersDTO;

    @Допустим("Параметры запроса - {string}")
    public void setParameters(String params) {
        String[] paramsList = params.split("&");
        for (String s : paramsList) {
            String[] parameter = s.split("=");
            parameters.put(parameter[0], parameter[1]);
        }
    }

    @Когда("Выполнен запрос USERS LIST на reqres.in")
    public void getResponse() {
        usersListResponse = listUsersRequest.get(listUsersRequest.listUsersSpec);
    }
    @Тогда("Код ответа - {int}")
    public void statusCodeIs(int code) {
        Assert.assertEquals(usersListResponse.then().extract().statusCode(), code);
    }

    @Тогда("В теле ответа присутствует список пользователей")
    public void getUsersList() {
        listUsersDTO = usersListResponse.then().extract().body().as(ListUsersDTO.class);
        Assert.assertNotNull(listUsersDTO);
    }

    @Тогда("У всех пользователей одинаковые имена аватаров")
    public void avatarsIsSame() {
        String[] avatarPath = listUsersDTO.getData().get(0).getAvatar().split("/");
        String avatarName = avatarPath[avatarPath.length - 1];
        for (int i = 0; i < listUsersDTO.getData().size(); i++) {
            String[] currentAvatarPath = listUsersDTO.getData().get(i).getAvatar().split("/");
            String currentAvatarName = currentAvatarPath[currentAvatarPath.length - 1];
            Assert.assertEquals(avatarName, currentAvatarName);
        }
    }
}
