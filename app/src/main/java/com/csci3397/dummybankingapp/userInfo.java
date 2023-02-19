package com.csci3397.dummybankingapp;

import androidx.appcompat.app.AppCompatActivity;
import com.csci3397.dummybankingapp.MainActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class userInfo extends AppCompatActivity {
    TextView userNameTV;
    String cur_userName;
    TextView balanceTV;
    TextView phoneNumberTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initTextView();
    }
    private void initTextView() {
        userNameTV = (TextView)findViewById(R.id.curUserName);
        balanceTV  = (TextView)findViewById(R.id.curBalance);
        phoneNumberTV  = (TextView)findViewById(R.id.curPhoneNumber);
        cur_userName = getIntent().getStringExtra("username");
        userNameTV.setText("Username: "+cur_userName);
        balanceTV.setText("Balance: $"+getIntent().getStringExtra("balance"));
        phoneNumberTV.setText("Phone #: "+getIntent().getStringExtra("phoneNumber"));
    }

    public void lofOff(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void transferPage(View view) {
        Intent intent = new Intent(this, transferPage.class);
        intent.putExtra("cur_user",cur_userName);
        startActivity(intent);
    }
}