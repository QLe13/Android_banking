package com.csci3397.dummybankingapp;
import com.csci3397.dummybankingapp.User;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
import com.csci3397.dummybankingapp.logInPage;
import com.csci3397.dummybankingapp.register;

public class MainActivity extends AppCompatActivity {
//    private String userName;
//    private String password;
//    private String legalName;
//    private String ssn;
//    private String phoneNumber;
//    private Integer accountBalance;
    public static Map<String, User> users = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (users.size()==0){
            User admin = new User("admin", "admin", "Administrator", "111111111", "0000000000", 10000.0);
            User qle1 = new User("qle1", "1312", "q", "111111111", "2109357221", 98188.0);
            users.put(admin.getUserName(), admin);
            users.put(qle1.getUserName(), qle1);
        }
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, logInPage.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}