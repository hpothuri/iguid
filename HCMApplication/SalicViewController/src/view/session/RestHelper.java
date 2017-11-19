package view.session;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import java.util.HashMap;
import oracle.dms.http.Base64Encoder;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestHelper {
    public RestHelper() {
        super();
    }

    public static HttpResponse<JsonNode> invokeJsonRequestViaUnirestClient(String username, String password,
                                                                           String inputPayload, String restServiceUrl,
                                                                           String restOpr, String contentType,
                                                                           HashMap additionalHeaders,
                                                                           boolean authReqd) throws Exception {
        String authHeader = null;
        HttpResponse<JsonNode> jsonResponse = null;
        String encoding = Base64Encoder.encode(username + ":" + password);
        HttpClient client = new DefaultHttpClient();
        if (authReqd) {
            authHeader = "Basic " + encoding;
        }
        Unirest.setHttpClient(client);
        if ("REST_SERVICE_GET".equals(restOpr)) {
            if (authReqd) {
                jsonResponse = Unirest.get(restServiceUrl)
                                      .header("Authorization", authHeader)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .asJson();
            } else {
                jsonResponse = Unirest.get(restServiceUrl)
                                      .header("Authorization", authHeader)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .asJson();
            }
        } else if ("REST_SERVICE_PATCH".equals(restOpr)) {
            if (authReqd) {
                jsonResponse = Unirest.patch(restServiceUrl)
                                      .header("Authorization", authHeader)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .body(inputPayload)
                                      .asJson();
            } else {
                jsonResponse = Unirest.patch(restServiceUrl)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .body(inputPayload)
                                      .asJson();
            }
        } else if ("REST_SERVICE_DELETE".equals(restOpr)) {
            if (authReqd) {
                jsonResponse = Unirest.delete(restServiceUrl)
                                      .header("Authorization", authHeader)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .body(inputPayload)
                                      .asJson();
            } else {
                jsonResponse = Unirest.delete(restServiceUrl)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .body(inputPayload)
                                      .asJson();
            }
        } else if ("REST_SERVICE_POST".equals(restOpr)) {
            if (authReqd) {
                jsonResponse = Unirest.post(restServiceUrl)
                                      .header("Content-Type", contentType)
                                      .header("Authorization", authHeader)
                                      .headers(additionalHeaders)
                                      .body(inputPayload)
                                      .asJson();
            } else {
                jsonResponse = Unirest.post(restServiceUrl)
                                      .header("Content-Type", contentType)
                                      .headers(additionalHeaders)
                                      .body(inputPayload)
                                      .asJson();
            }
        } else {
            throw new RuntimeException("This client(Unirest) does not support HTTP operations other than get/post/patch/delete.");
        }
        if (jsonResponse != null) {
            System.out.println("jsonResponse status=" + jsonResponse.getStatusText());
        }

        return jsonResponse;
    }
}
