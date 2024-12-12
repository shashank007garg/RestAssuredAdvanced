package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportUtil;

import java.util.Collections;
import java.util.Map;

public class RestUtils {
    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint )
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);

    }

    private static RequestSpecification getRequestSpecification(String endPoint, String id,Object requestPayload, Map<String, String> headers) {
        return RestAssured.given()
                .baseUri(endPoint+"/"+ id)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);

    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportUtil.logInfoDetails("EndPoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportUtil.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportUtil.logInfoDetails("Headers are");
        ExtentReportUtil.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportUtil.logInfoDetails("Request body ");
        ExtentReportUtil.logJson(queryableRequestSpecification.getBody());

    }

    private static void printResponseLogInReport(Response response) {


        ExtentReportUtil.logInfoDetails("Response status " + response.getStatusCode());
        ExtentReportUtil.logInfoDetails("Response Headers are");
        ExtentReportUtil.logHeaders(response.getHeaders().asList());
        ExtentReportUtil.logInfoDetails("Response body ");
        ExtentReportUtil.logJson(response.getBody().prettyPrint());

    }

    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

    public static Response performPost(String endPoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;


    }

    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }
    public static Response performGet(String endPoint, String id, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, id,"{}",headers);
        Response response = requestSpecification.get();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }
}
