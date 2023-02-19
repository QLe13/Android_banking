package com.csci3397.dummybankingapp;

import androidx.appcompat.app.AppCompatActivity;
import com.csci3397.dummybankingapp.User;
import com.csci3397.dummybankingapp.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class logInPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
    }

    public void register(View view) {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }

    public void submit(View view) {
        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        EditText ssn = findViewById(R.id.ssn);
        if (userName.getText().length() == 0){
            Toast.makeText(this, "Missing username",Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.getText().length() == 0){
            Toast.makeText(this, "Missing password",Toast.LENGTH_SHORT).show();
            return;
        }
        if (ssn.getText().length() == 0){
            Toast.makeText(this, "Missing ssn",Toast.LENGTH_SHORT).show();
            return;
        }
        String user_Name = userName.getText().toString();
        if (!MainActivity.users.containsKey(user_Name)){
            Toast.makeText(this, "User not exist",Toast.LENGTH_SHORT).show();
            return;
        }
        User cur_user = MainActivity.users.get(user_Name);
        String pass_word = password.getText().toString();
        String SSN = ssn.getText().toString();
        if (!pass_word.equals(cur_user.getPassword()) ||
            !SSN.equals(cur_user.getSsn())){
            Toast.makeText(this, "Double check your information",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, userInfo.class);
        intent.putExtra("username",user_Name);
        intent.putExtra("balance",Double.toString(cur_user.getBalance()));
        String beautyPhone = cur_user.getPhoneNumber();
        String beautyPhone2 = beautyPhone.substring(0,3)+'-'+beautyPhone.substring(3,6)+'-'+beautyPhone.substring(6,beautyPhone.length());
        intent.putExtra("phoneNumber",beautyPhone2);
        startActivity(intent);
        return;

    }
}