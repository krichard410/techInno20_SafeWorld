package com.safeworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.safeworld.authentication.LoginActivity;
import com.safeworld.authentication.RegisterActivity;

public class LandingPageActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

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

    @Override
    protected void onStart() {
        //user do not need to login again if they already login previously
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null) {
            //user is already connected  so we need to redirect him to home page
            Intent toMain = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(toMain);
            finish();
        }
    }
}
