package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {
    private static String Access_Token = null;
    public static void main(String[] args) throws IOException {
//        String accessToken = login("davetest@mailinator.com","davetest");
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"is_private\":false,\"creation_template\":1,\"description\":\"testik\",\"name\":\"testik\"}");
//        Request request = new Request.Builder()
//                .url("https://api.taiga.io/api/v1/projects")
//                .post(body)
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Authorization", "Bearer " + accessToken)
//                .addHeader("Cache-Control", "no-cache")
//                .addHeader("Postman-Token", "95476f30-9e9b-b10f-22ba-700e50dd22e9")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());

    }

    public static JsonObject login(String email, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"" + email + "\",\"password\":\"" + password + "\",\"type\":\"normal\"}\r\n");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cache-Control", "no-cache")
                .addHeader("Postman-Token", "3e2fe44e-ebbc-ffdc-ed6e-8c9637bb3608")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        Access_Token = object.get("auth_token").getAsString();
        return object;

    }

    public static JsonObject createProjetc(JsonObject project) throws IOException {
        OkHttpClient client = new OkHttpClient();


        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, project.toString());
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/projects")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer eyJ1c2VyX2F1dGhlbnRpY2F0aW9uX2lkIjozMzQ3MDB9:1gSOO6:vVsVmeovdMa46pUFCe0pHzKSVRg")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "dc09ac30-0438-461c-965f-e588b17caf91")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        return new JsonParser().parse(jsonString).getAsJsonObject();

    }

}
