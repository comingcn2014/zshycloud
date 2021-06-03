package com.zshy.code.util;

import feign.Request;
import feign.Response;
import feign.okhttp.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author yanghf
 * @date 2021年05月30日 16:56
 */
public class Test {
    public static void main(String[] args) {
        String baseUrl = "http://192.168.10.14:20002/provider/user/username?userName=admin";
        try {
            OkHttpClient client = new OkHttpClient();
            Map<String, Collection<String>>  headerMap = new HashMap<>();
//            RequestBody body = RequestBody.create(JSON,ObjToJson.tojson(user));
            Request request = Request.create("GET", baseUrl, headerMap, null, null);
            Response response = client.execute(request,new Request.Options());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
