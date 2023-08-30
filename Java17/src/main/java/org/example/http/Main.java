package org.example.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://dummyjson.com/products")
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String string = response.body().string();
        System.out.println(string);

        ObjectMapper mapper = new ObjectMapper();
        ProductResponse productResponse = mapper.readValue(string, ProductResponse.class);
        System.out.println(productResponse.getTotal());
        System.out.println(productResponse);

    }
}
