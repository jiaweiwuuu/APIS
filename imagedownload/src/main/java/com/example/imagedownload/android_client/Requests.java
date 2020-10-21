package com.example.imagedownload.android_client;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.imagedownload.android_client.entity.ResponseObject;
import com.example.imagedownload.android_client.util.RequestUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Requests {
    static String POST = "POST";
    static String GET = "GET";
    static String token = "token=ffec163aa6704c94b01fc48f9a3d0913";

    public static Bitmap downLoadImage(String fileName) {
        try {
            URL url = new URL("http://35.244.106.99:8000/forum/user/headImg?fileName=" + fileName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(6000); //超时设置
            connection.setDoInput(true);
            connection.setUseCaches(false); //设置不使用缓存
            connection.setRequestProperty("Cookie", token);
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

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
