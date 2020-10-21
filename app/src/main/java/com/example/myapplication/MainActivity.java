package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.android_client.Requests;
import com.example.myapplication.android_client.entity.Comment;
import com.example.myapplication.android_client.entity.Contact;
import com.example.myapplication.android_client.entity.Message;
import com.example.myapplication.android_client.entity.News;
import com.example.myapplication.android_client.entity.ResponseObject;
import com.example.myapplication.android_client.entity.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    static String TAG = "my";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<Object> loginResult = Requests.signIn("jiaweiw1", "Aaaa1111");
                        Log.d(TAG, loginResult.toString());
                    }
                }).start();

            }
        });

        Button getInfo = findViewById(R.id.getInfo);
        getInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<User> userInfoResponse = Requests.getUserInfo();
                        Log.d(TAG, userInfoResponse.toString());
                    }
                }).start();

            }
        });

        Button createNews = findViewById(R.id.createNews);
        createNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<Integer> createNewsResp = Requests.createNews("from huawei","huawei NO1");
                        Log.d(TAG, createNewsResp.toString());
                    }
                }).start();

            }
        });

        Button getNewsDetail = findViewById(R.id.getNewsDetail);
        getNewsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<News> getNewsDetailResp = Requests.getNewsDetail(26);
                        Log.d(TAG, getNewsDetailResp.toString());
                    }
                }).start();

            }
        });

        Button createComment = findViewById(R.id.createComment);
        createComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<Integer> createCommentResp = Requests.createComment(17,"comment from HUAWEI");
                        Log.d(TAG, createCommentResp.toString());
                    }
                }).start();
            }
        });

        Button getComments = findViewById(R.id.getComments);
        getComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<List<Comment>> getCommentsResp = Requests.getComments(17);
                        Log.d(TAG, getCommentsResp.toString());
                    }
                }).start();
            }
        });

        Button mainPageNews = findViewById(R.id.mainPageNews);
        mainPageNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<List<News>> mainPageNewsResp = Requests.getMainPageNews();
                        Log.d(TAG, mainPageNewsResp.toString());
                    }
                }).start();
            }
        });

        Button createMessage = findViewById(R.id.createMessage);
        createMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<Object> createMessageResp = Requests.createTextMessage(21,"hello from HUAWEI");
                        Log.d(TAG, createMessageResp.toString());
                    }
                }).start();
            }
        });

        Button getMessage = findViewById(R.id.getMessage);
        getMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<List<Message>> getMessageResp = Requests.getMessage(21);
                        Log.d(TAG, getMessageResp.toString());
                    }
                }).start();
            }
        });

        Button getContactList = findViewById(R.id.getContactList);
        getContactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ResponseObject<List<Contact>> getContactListResp = Requests.getContactList();
                        Log.d(TAG, getContactListResp.toString());
                    }
                }).start();
            }
        });




    }


}