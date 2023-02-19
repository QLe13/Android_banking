package com.csci3397.dummybankingapp;

import androidx.appcompat.app.AppCompatActivity;
import com.csci3397.dummybankingapp.logInPage;
import com.csci3397.dummybankingapp.User;
import com.csci3397.dummybankingapp.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    //    private String userName;
    //    private String password;
    //    private String legalName;
    //    private String ssn;
    //    private String phoneNumber;
    //    private Integer accountBalance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void logIn(View view) {
        Intent intent = new Intent(this, logInPage.class);
        startActivity(intent);
    }

    public void submit(View view){
        EditText userName = findViewById(R.id.userName);
        EditText password = findViewById(R.id.password);
        EditText legalName = findViewById(R.id.name);
        EditText ssn = findViewById(R.id.ssn);
        EditText phoneNumber = findViewById(R.id.phoneNumber);
        EditText accountBalance = findViewById(R.id.balance);
        EditText confirmPass = findViewById(R.id.confirm_pass);
        if (userName.getText().length() == 0 ||
            password.getText().length() == 0 ||
            legalName.getText().length() == 0 ||
            ssn.getText().length() == 0 ||
            phoneNumber.getText().length() == 0 ||
            accountBalance.getText().length() == 0 ||
            confirmPass.getText().length() == 0){
            Toast.makeText(this, "Missing information!", Toast.LENGTH_SHORT).show();
            return;
        }
        String user_Name = userName.getText().toString();
        if (MainActivity.users.containsKey(user_Name)){
            Toast.makeText(this, "User existed!", Toast.LENGTH_SHORT).show();
            return;
        }
        String pass_word = password.getText().toString();
        String legal_Name = legalName.getText().toString();
        String SSN = ssn.getText().toString();
        String phone_Number = phoneNumber.getText().toString();
        Double account_Balance = Double.parseDouble(accountBalance.getText().toString());
        String confirm_Pass = confirmPass.getText().toString();
        //check for empty spaces

        // check for mismatching password
        if (!pass_word.equals(confirm_Pass)){
            Toast.makeText(this, "Passwords mismatching!", Toast.LENGTH_SHORT).show();
            return;
        }
        User new_user = new User(user_Name,pass_word,legal_Name,SSN,phone_Number,account_Balance);
        MainActivity.users.put(user_Name,new_user);
        Toast.makeText(this, "Registered successful, switching to login UI", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, logInPage.class);
        startActivity(intent);
        return;
    }

}