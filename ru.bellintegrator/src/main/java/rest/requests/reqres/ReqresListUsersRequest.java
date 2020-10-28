package rest.requests.reqres;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import java.util.Map;


public class ReqresListUsersRequest extends ReqresBaseRequest {

    public ReqresListUsersRequest(RequestSpecification baseSpec, Map<String, String> parameters) {
        super(baseSpec, parameters);
    }

    public RequestSpecification listUsersSpec = new RequestSpecBuilder()
            .addRequestSpecification(baseSpec)
            .setBasePath("/api/users")
            .addQueryParams(parameters)
            .build();
}
