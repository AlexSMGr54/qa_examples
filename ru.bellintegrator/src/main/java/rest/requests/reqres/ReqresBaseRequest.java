package rest.requests.reqres;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class ReqresBaseRequest {

    final protected RequestSpecification baseSpec;
    final protected Map<String, String> parameters;

    public ReqresBaseRequest(RequestSpecification baseSpec, Map<String, String> parameters) {
        this.baseSpec = baseSpec;
        this.parameters = parameters;
    }

    public Response get(RequestSpecification spec) {
        return given().spec(spec).when().get();
    }
}
