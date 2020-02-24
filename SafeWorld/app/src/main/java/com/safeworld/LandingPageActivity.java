package com.safeworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.safeworld.authentication.LoginActivity;
import com.safeworld.authentication.RegisterActivity;

public class LandingPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        getSupportActionBar().hide();

        Button login = findViewById(R.id.login);
        Button signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUp = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toSignUp);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUp = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(toSignUp);
            }
        });

    }
}
