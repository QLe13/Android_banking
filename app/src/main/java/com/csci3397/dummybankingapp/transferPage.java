package com.csci3397.dummybankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class transferPage extends AppCompatActivity {
    Spinner mySpinner;
    String cur_userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cur_userName = getIntent().getStringExtra("cur_user");
        setContentView(R.layout.activity_transfer_page);
        mySpinner = findViewById(R.id.my_spinner);
        List<String> keysList = new ArrayList<>(MainActivity.users.keySet());
        if (keysList.size()==1){
            Toast.makeText(this, "There is no user other than you!", Toast.LENGTH_SHORT).show();
        }
        keysList.add(0, "Select an option");
        keysList.remove(cur_userName);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, keysList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
    }

    public void lofOff(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void submit(View view) {
        String selected_user = (String)mySpinner.getSelectedItem();
        if (selected_user == "Select an option"){
            Toast.makeText(this, "No user selected", Toast.LENGTH_SHORT).show();
            return;
        }
        User curUser = MainActivity.users.get(cur_userName);
        User selectedUser = MainActivity.users.get(selected_user);
        EditText transfer$ = findViewById(R.id.transfer_balance);
        Double transfer_balance = Double.parseDouble(transfer$.getText().toString());
        if(transfer_balance > curUser.getBalance()){
            Toast.makeText(this, "You poor, not enough money", Toast.LENGTH_SHORT).show();
            return;
        }
        curUser.setBalance(curUser.getBalance()-transfer_balance);
        selectedUser.setBalance(selectedUser.getBalance()+transfer_balance);
        String confirm = cur_userName+ " you have $"+MainActivity.users.get(cur_userName).getBalance().toString()+" left in your account!";
        Toast.makeText(this,confirm, Toast.LENGTH_LONG).show();
        transfer$.setText("");
        return;
    }

    public void go_to_userinfo(View view) {
        Intent intent = new Intent(this, userInfo.class);
        intent.putExtra("username",cur_userName);
        intent.putExtra("balance",Double.toString(MainActivity.users.get(cur_userName).getBalance()));
        String beautyPhone = MainActivity.users.get(cur_userName).getPhoneNumber();
        String beautyPhone2 = beautyPhone.substring(0,3)+'-'+beautyPhone.substring(3,6)+'-'+beautyPhone.substring(6,beautyPhone.length());
        intent.putExtra("phoneNumber",beautyPhone2);
        startActivity(intent);
    }
}