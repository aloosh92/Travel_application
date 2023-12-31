package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgortPassword extends AppCompatActivity {
    private EditText emailEditText;
    private Button  resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgort_password);

        emailEditText=findViewById(R.id.email);
        resetPasswordButton=findViewById(R.id.buttonPanel);
        progressBar =findViewById(R.id.ProgressBar);

        auth=FirebaseAuth.getInstance();

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }
    private  void  resetPassword(){
        String email=emailEditText.getText().toString().trim();

        if(email.isEmpty()){
            emailEditText.setError("Email is required!");
            emailEditText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("please provide valid email!");
            emailEditText.requestFocus();
            return;

        }

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(ForgortPassword.this,"Check your Email to reset  your Password",Toast.LENGTH_LONG).show();

                }else
                {
                    Toast.makeText(ForgortPassword.this,"Try again Something wrong happened",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}