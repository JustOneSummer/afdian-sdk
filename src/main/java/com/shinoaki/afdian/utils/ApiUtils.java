package com.shinoaki.afdian.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.shinoaki.afdian.model.Result;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtils {
    private static final HttpClient CLIENT = HttpClient.newBuilder().build();

    private ApiUtils() {
    }


    public static Result send(HttpRequest.Builder request) throws IOException, InterruptedException {
        return new JsonUtils().parse(HttpCodec.response(CLIENT.send(request.setHeader("content-type", "application/json").build(), HttpResponse.BodyHandlers.ofByteArray())), new TypeReference<Result>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
    }
}
