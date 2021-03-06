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
import com.safeworld.MainActivity;
import com.safeworld.R;

/**
 * The loginActivity class implement the login function when the user click the login button
 * @author nieruize
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {

    private Button login_btn;
    private EditText userMail,userPassword;
    private Intent HomeActivity;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // hide the actionbar in the top the screen
        getSupportActionBar().hide();

        userMail = findViewById(R.id.login_user_email);
        userPassword = findViewById(R.id.login_user_password);
        login_btn = findViewById(R.id.login_btn);
        HomeActivity = new Intent(getApplicationContext(), MainActivity.class);
        mAuth = FirebaseAuth.getInstance();

        // implement the function of login button
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String mail = userMail.getText().toString();
                final String password = userPassword.getText().toString();

                if (mail.isEmpty() || password.isEmpty()) {
                    showMessage("Please Verify All Field");

                } else {
                    signIn(mail,password);
                }

            }
        });
    }

    // show the error message
    private void showMessage(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
    }

    // implement the log in function by using the firebase authentication
    private void signIn(String mail, String password) {
        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    updateUI();
                } else {
                    showMessage(task.getException().getMessage());
                }
            }
        });
    }

    // start the new activity
    private void updateUI() {
        startActivity(HomeActivity);
        finish();
    }
}
