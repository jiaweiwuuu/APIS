package com.example.myapplication.android_client;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.R;
import com.example.myapplication.android_client.entity.Contact;
import com.example.myapplication.android_client.entity.ResponseObject;
import com.example.myapplication.android_client.entity.*;
import com.example.myapplication.android_client.util.RequestUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.*;

public class Requests {
    static String POST = "POST";
    static String GET = "GET";
    static String token = "token=7ad48964433d489ea77f98909c4bd86c";


    public static ResponseObject<Object> signUp(String username, String password) {
        HttpURLConnection connection = null;
        try {
            connection = RequestUtil.setConnection("/user/signup", POST, true);

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("username", username);
            paramMap.put("password", password);
            RequestUtil.setParams(paramMap, connection);


            String result = RequestUtil.getResponse(connection);
            ResponseObject<Object> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Object>>() {
            }.getType());
            return res;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }

    public static ResponseObject<Object> signIn(String username, String password) {
        HttpURLConnection connection = null;

        try {
            connection = RequestUtil.setConnection("/user/signin", POST, true);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("username", username);
            paramMap.put("password", password);
            paramMap.put("rememberme", true);
            RequestUtil.setParams(paramMap, connection);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<Object> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Object>>() {
            }.getType());
            token = RequestUtil.getToken(connection);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<User> getUserInfo() {
        HttpURLConnection connection = null;
        try {
            connection = RequestUtil.setConnection("/user/userInfo", GET, false);
            connection.setRequestProperty("Cookie", token);
            String result = RequestUtil.getResponse(connection);

            ResponseObject<User> res = new Gson().fromJson(result, new TypeToken<ResponseObject<User>>() {
            }.getType());
            return res;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<Integer> createNews(String title, String content) {
        HttpURLConnection connection = null;

        try {
            connection = RequestUtil.setConnection("/question/create", POST, true);
            connection.setRequestProperty("Cookie", token);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("title", title);
            paramMap.put("content", content);
            RequestUtil.setParams(paramMap, connection);


            String result = RequestUtil.getResponse(connection);
            ResponseObject<Integer> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Integer>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<News> getNewsDetail(int id) {
        HttpURLConnection connection = null;

        try {
            connection = RequestUtil.setConnection("/question/detail" + "?qid=" + id, GET, false);
            connection.setRequestProperty("Cookie", token);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<News> res = new Gson().fromJson(result, new TypeToken<ResponseObject<News>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ResponseObject<Integer> createComment(int newsId, String content) {
        HttpURLConnection connection = null;

        try {
            connection = RequestUtil.setConnection("/comment/create", POST, true);
            connection.setRequestProperty("Cookie", token);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("entity_id", newsId);
            paramMap.put("entity_type", 0);
            paramMap.put("content", content);
            RequestUtil.setParams(paramMap, connection);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<Integer> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Integer>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<List<Comment>> getComments(int newsId) {
        HttpURLConnection connection = null;

        try {
            connection = RequestUtil.setConnection("/comment/list" + "?entity_id=" + newsId + "&entity_type=0", GET, false);
            connection.setRequestProperty("Cookie", token);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<List<Comment>> res = new Gson().fromJson(result, new TypeToken<ResponseObject<List<Comment>>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<List<News>> getMainPageNews(){
        HttpURLConnection connection = null;
        try {
            connection = RequestUtil.setConnection("/main/news", GET, false);
            connection.setRequestProperty("Cookie", token);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<List<News>> res = new Gson().fromJson(result, new TypeToken<ResponseObject<List<News>>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<Object> createTextMessage(int toId, String content){
        HttpURLConnection connection = null;

        try {
            connection = RequestUtil.setConnection("/message/send", POST, true);
            connection.setRequestProperty("Cookie", token);
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("to_id", toId);
            paramMap.put("content", content);
            RequestUtil.setParams(paramMap, connection);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<Object> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Object>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<List<Message>> getMessage(int toId){
        HttpURLConnection connection = null;
        try {
            connection = RequestUtil.setConnection("/message/all" + "?to_id="+toId, GET, false);
            connection.setRequestProperty("Cookie", token);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<List<Message>> res = new Gson().fromJson(result, new TypeToken<ResponseObject<List<Message>>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<List<Contact>> getContactList(){
        HttpURLConnection connection = null;
        try {
            connection = RequestUtil.setConnection("/message/contact", GET, false);
            connection.setRequestProperty("Cookie", token);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<List<Contact>> res = new Gson().fromJson(result, new TypeToken<ResponseObject<List<Contact>>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<List<News>> getNewsByUserId(int userId){
        HttpURLConnection connection = null;
        try {
            connection = RequestUtil.setConnection("/question/newsDetailByUserId?uid="+userId, GET, false);
            connection.setRequestProperty("Cookie", token);

            String result = RequestUtil.getResponse(connection);
            ResponseObject<List<News>> res = new Gson().fromJson(result, new TypeToken<ResponseObject<List<News>>>() {
            }.getType());
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Bitmap downLoadImage(String fileName){
        try {
            URL url = new URL("http://35.244.106.99:8000/forum/user/headImg?fileName="+fileName);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setConnectTimeout(6000); //超时设置
            connection.setDoInput(true);
            connection.setUseCaches(false); //设置不使用缓存
            InputStream inputStream=connection.getInputStream();
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);

            inputStream.close();
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ResponseObject<Object> uploadAvatar(Bitmap image) {
        String urlHost = "http://35.244.106.99:8000/forum/user/headImg";
        String key = "file";
        String endString = "\r\n";
        String twoHyphen = "--";
        String boundary = "*****";

        byte[] imageBytes = bitmap2Bytes(image);
        try {

            URL url = new URL(urlHost);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            connection.setRequestMethod(POST);

            connection.setRequestProperty("Cookie", token);

            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);


            DataOutputStream dsDataOutputStream = new DataOutputStream(connection.getOutputStream());
            dsDataOutputStream.writeBytes(twoHyphen + boundary + endString);
            dsDataOutputStream.writeBytes("Content-Disposition:form-data;" + "name=\"" + key + "\";filename=\"" +
                    "avatar.jpg\"" + endString);
            dsDataOutputStream.writeBytes(endString);


            dsDataOutputStream.write(imageBytes, 0, imageBytes.length);

            dsDataOutputStream.writeBytes(endString);
            dsDataOutputStream.writeBytes(twoHyphen + boundary + twoHyphen + endString);

            dsDataOutputStream.close();

            String result = RequestUtil.getResponse(connection);
            ResponseObject<Object> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Object>>() {
            }.getType());
            return res;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseObject<Object> sendImage(Bitmap image, int toId) {
        String urlHost = "http://35.244.106.99:8000/forum/message/sendImage?to_id="+toId;
        String key = "file";
        String endString = "\r\n";
        String twoHyphen = "--";
        String boundary = "*****";

        byte[] imageBytes = bitmap2Bytes(image);
        try {

            URL url = new URL(urlHost);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            connection.setRequestMethod(POST);

            connection.setRequestProperty("Cookie", token);

            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);




            DataOutputStream dsDataOutputStream = new DataOutputStream(connection.getOutputStream());
            dsDataOutputStream.writeBytes(twoHyphen + boundary + endString);
            dsDataOutputStream.writeBytes("Content-Disposition:form-data;" + "name=\"" + key + "\";filename=\"" +
                    "avatar.jpg\"" + endString);
            dsDataOutputStream.writeBytes(endString);


            dsDataOutputStream.write(imageBytes, 0, imageBytes.length);

            dsDataOutputStream.writeBytes(endString);
            dsDataOutputStream.writeBytes(twoHyphen + boundary + twoHyphen + endString);

            dsDataOutputStream.close();

            String result = RequestUtil.getResponse(connection);
            ResponseObject<Object> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Object>>() {
            }.getType());
            return res;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ResponseObject<Object> newsWithImage(List<Bitmap> images, String title, String content) {
        String urlHost = "http://35.244.106.99:8000/forum/question/createWithImage?title="+title+"&content="+content;
        String key = "files";
        String endString = "\r\n";
        String twoHyphen = "--";
        String boundary = "*****";


        try {

            URL url = new URL(urlHost);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            connection.setRequestMethod(POST);

            connection.setRequestProperty("Cookie", token);

            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "utf-8");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            DataOutputStream dsDataOutputStream = new DataOutputStream(connection.getOutputStream());


            for(Bitmap image : images){
                byte[] imageBytes = bitmap2Bytes(image);
                dsDataOutputStream.writeBytes(twoHyphen + boundary + endString);
                dsDataOutputStream.writeBytes("Content-Disposition:form-data;" + "name=\"" + key + "\";filename=\"" +
                        "avatar.jpg\"" + endString);
                dsDataOutputStream.writeBytes(endString);

                dsDataOutputStream.write(imageBytes, 0, imageBytes.length);

                dsDataOutputStream.writeBytes(endString);

            }
            dsDataOutputStream.writeBytes(twoHyphen + boundary + twoHyphen + endString);



            dsDataOutputStream.close();

            String result = RequestUtil.getResponse(connection);
            ResponseObject<Object> res = new Gson().fromJson(result, new TypeToken<ResponseObject<Object>>() {
            }.getType());
            return res;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static byte[] bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }



}
