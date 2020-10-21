package com.example.imagedownload;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imagedownload.android_client.Requests;
import com.example.imagedownload.android_client.entity.ResponseObject;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button content;
    ImageView image;
    Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = findViewById(R.id.content1);
        image = findViewById(R.id.image1);
        content.setOnClickListener(this);

        Button uploadAvartar = findViewById(R.id.content2);
        uploadAvartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        ResponseObject<Object> content =Requests.uploadAvatar(bitmap);
                        Log.i("my",content.toString());
                    }
                }).start();
            }
        });

        Button sendImage = findViewById(R.id.content3);
        sendImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        ResponseObject<Object> content =Requests.sendImage(bitmap,21);
                        Log.i("my",content.toString());
                    }
                }).start();
            }
        });

        Button newsWithImage = findViewById(R.id.content4);
        newsWithImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<Bitmap> images = new ArrayList<>();
                        // 上传两张，虽然是一样的
                        images.add(bitmap);
                        images.add(bitmap);

                        ResponseObject<Object> content =Requests.newsWithImage(images,"news from android","god plz");
                        Log.i("my",content.toString());
                    }
                }).start();
            }
        });







    }

    public Bitmap GetImageInputStream(String imageurl) {
        // 改成接口传过来的imageurl
        return Requests.downLoadImage("97aef328-9844-4c47-b055-e4a9e799e1d2.jpg");
    }

    @Override
    public void onClick(View view) {
        new Task().execute("http://35.244.106.99:8000/forum/user/headImg?fileName=9f065c20-6c44-45c7-bd1a-472c5df3bb8d.jpeg");
    }

    Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 0x123) {
                image.setImageBitmap(bitmap);
            }
        }

        ;
    };

    class Task extends AsyncTask<String, Integer, Void> {

        protected Void doInBackground(String... params) {
            bitmap = GetImageInputStream((String) params[0]);
            return null;
        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Message message = new Message();
            message.what = 0x123;
            handler.sendMessage(message);
        }
    }
}