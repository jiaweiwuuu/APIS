package com.example.imagedownload.android_client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class RequestUtil {
    private static String URL_PREFIX = "http://35.244.106.99:8000/forum";

    public static HttpURLConnection setConnection(String path,String method, boolean hasParams) throws IOException {
        URL url = new URL(URL_PREFIX + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
        connection.setDoOutput(hasParams);
        return connection;
    }

    public static void setParams(Map<String,Object> paramMap, HttpURLConnection connection) throws IOException {
        StringBuffer params = new StringBuffer();
        for(String key : paramMap.keySet()){
            params.append(key);
            params.append("=");
            params.append(paramMap.get(key));
            params.append("&");
        }
        byte[] bytes = params.toString().getBytes();
        connection.getOutputStream().write(bytes);
    }

    public static String getToken(HttpURLConnection connection){
        Map<String, List<String>> map = connection.getHeaderFields();
        for (String key : map.keySet()) {
            if (key != null && key.equals("Set-Cookie")) {
                List<String> list = map.get(key);
                StringBuilder sb = new StringBuilder();
                for (String item : list) {
                    sb.append(item);
                }
                return sb.toString().split(";")[0];
            }
        }
        return null;
    }

    public static String getResponse(HttpURLConnection connection) throws IOException {
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String result = br.readLine();
        return result;
    }
}
