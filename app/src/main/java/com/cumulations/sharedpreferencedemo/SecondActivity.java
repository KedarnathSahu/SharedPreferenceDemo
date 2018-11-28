package com.cumulations.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class SecondActivity extends AppCompatActivity {

    public static final String DEFAULT = "N/A";
    TextView emailTextView, passwordTextView,toggleButtonTextView,aSwitchTextView;
    ToggleButton toggleButton;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        emailTextView = findViewById(R.id.textView);
        passwordTextView = findViewById(R.id.textView2);
        toggleButton = findViewById(R.id.toggleButton);
        aSwitch = findViewById(R.id.switch1);
        toggleButtonTextView=findViewById(R.id.textView5);
        aSwitchTextView = findViewById(R.id.textView6);
    }

    public void load(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginData", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", DEFAULT);
        String password = sharedPreferences.getString("password", DEFAULT);

        String toggleStatus=DEFAULT;
        if(toggleButton.getText().equals(getResources().getString(R.string.ton))){
            toggleStatus=getResources().getString(R.string.ton);
        }else if(toggleButton.getText().equals(getResources().getString(R.string.toff))){
            toggleStatus=getResources().getString(R.string.toff);
        }

        String switchStatus;
        if(aSwitch.isChecked()){
            switchStatus=getResources().getString(R.string.son);
        }else{
            switchStatus=getResources().getString(R.string.soff);
        }

        emailTextView.setText(email);
        passwordTextView.setText(password);
        toggleButtonTextView.setText(toggleStatus);
        aSwitchTextView.setText(switchStatus);
    }
}
