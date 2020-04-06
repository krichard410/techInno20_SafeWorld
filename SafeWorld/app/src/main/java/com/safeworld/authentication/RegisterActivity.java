package com.safeworld.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.safeworld.R;
/**
 * The RegisterActivity class implement the register function when the user click the create account button
 * @author nieruize
 * @version 1.0
 */
public class RegisterActivity extends AppCompatActivity {

    private Button signup_btn;
    private EditText userName, userEmail, userPassword;
    private Intent LoginActivity;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // hide the actionbar in the top the screen
        getSupportActionBar().hide();

        userName = findViewById(R.id.signup_user_name);
        userEmail = findViewById(R.id.signup_user_email);
        userPassword = findViewById(R.id.signup_user_password);
        LoginActivity = new Intent(getApplicationContext(), LoginActivity.class);
        signup_btn = findViewById(R.id.signup_btn);
        mAuth = FirebaseAuth.getInstance();

        // implement the function of register button
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = userEmail.getText().toString();
                final String password = userPassword.getText().toString();
                final String name = userName.getText().toString();

                if( email.isEmpty() || name.isEmpty() || password.isEmpty()) {
                    // something goes wrong : all fields must be filled
                    // we need to display an error message
                    showMessage("Please Verify all fields");
                }else {
                    // everything is ok and all fields are filled now we can start creating user account
                    // CreateUserAccount method will try to create the user if the email is valid
                    CreateUserAccount(email,name,password);
                }
            }
        });
    }

    // implement the register function by using the firebase authentication
    private void CreateUserAccount(String email, final String name, String password) {
        // this method create user account with specific email and password
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            // user account created successfully
                            showMessage("Account created");

                            // redirect the user to log in page
                            updateUI();

                        }else{
                            // account creation failed
                            showMessage("account creation failed" + task.getException().getMessage());
                        }
                    }
                });
    }

    // simple method to show toast message
    private void showMessage(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

    // start the new activity
    private void updateUI() {
        startActivity(LoginActivity);
        finish();
    }
}
