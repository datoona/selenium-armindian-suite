package api;

import base.BasePage;
import okhttp3.*;

import java.io.IOException;

public class LoginApi {
    public void loginViaAPI() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"davetest@mailinator.com\",\"password\":\"davetest\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("auth_token", "eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjozMzQ3MDB9:1gSq1t:MzsmLDmgyOIQUaF7RADx-9yvbos")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "d7420862-9c3d-450a-a265-3098a3c77bc4")
                .build();

        Response response = client.newCall(request).execute();
    }
}
