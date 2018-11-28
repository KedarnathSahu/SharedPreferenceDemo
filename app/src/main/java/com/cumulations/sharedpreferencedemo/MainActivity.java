package com.cumulations.sharedpreferencedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);

        SharedPreferences sharedPreferences=getSharedPreferences("LoginData", Context.MODE_PRIVATE);
        if(sharedPreferences.contains("email") && sharedPreferences.contains("password")){
            String email=sharedPreferences.getString("email","XXX");
            String password=sharedPreferences.getString("password","XXX");
            emailText.setText(email);
            passwordText.setText(password);
        }
    }

    public void save(View view) {

        if((emailText != null && !(emailText.getText().toString().equals(""))) || ( passwordText != null && !(passwordText.getText().toString().equals("")))){
            SharedPreferences sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("email", emailText.getText().toString());
            editor.putString("password", passwordText.getText().toString());
            editor.apply();
            Toast.makeText(this, "LogIn Data saved successfully.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Please Fill the Form.", Toast.LENGTH_SHORT).show();
        }
    }
}
