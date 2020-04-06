package com.safeworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.safeworld.authentication.LoginActivity;
import com.safeworld.authentication.RegisterActivity;
/**
 * The LandingPageActivity using for landing the welcome page
 * @author nieruize
 * @version 1.0
 */
public class LandingPageActivity extends AppCompatActivity {

    // attribute
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();

        Button login = findViewById(R.id.login);
        Button signup = findViewById(R.id.signup);

        // sign up page will show when user clicked
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUp = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(toSignUp);
            }
        });

        // log in page will show when user clicked
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSignUp = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(toSignUp);
            }
        });

    }
}
