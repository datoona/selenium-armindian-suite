package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {
    private static String ACCESS_TOKEN = null;
    private static final String BASE_URL = "https://api.taiga.io/api/v1";

    public static JsonObject login(String email, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"" + email + "\",\"password\":\"" + password + "\",\"type\":\"normal\"}\r\n");
        Request request = new Request.Builder()
                .url(BASE_URL + "/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "3e2fe44e-ebbc-ffdc-ed6e-8c9637bb3608")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        ACCESS_TOKEN = object.get("auth_token").getAsString();
        return object;

    }

    public static Response post(String url, JsonObject jsonObject) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .build();
        Response response = null;
        try {
             response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()){
            throw new Error("HTTP error code: " + String.valueOf(response.code()));
        }
        return response;
    }

    public static Response get(String url){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1" + url)
                .get()
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        }catch (IOException e){
            e.printStackTrace();
        }

        assert response !=null;
        if (!response.isSuccessful()){
            throw new Error("HTTP error code: "+ String.valueOf(response.code()));
        }
        return response;
    }

    public static void delete(String url, JsonObject jsonObject) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(BASE_URL + url + "/" + jsonObject.get("id").getAsString())
                .delete(null)
                .addHeader("Authorization", "Bearer " + ACCESS_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert response != null;
        if (!response.isSuccessful()) {
            throw new Error("HTTP error code: " + String.valueOf(response.code()));
        }
    }

}
