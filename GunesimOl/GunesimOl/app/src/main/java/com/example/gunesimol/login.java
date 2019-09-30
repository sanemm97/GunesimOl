package com.example.gunesimol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
    private Button btn_login,btn_register;
    private EditText edtt_email, edtt_password;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        btn_login= (Button) findViewById(R.id.btn_login);
        btn_register= (Button) findViewById(R.id.btn_register);
        edtt_email= (EditText) findViewById(R.id.edtt_email);
        edtt_password= (EditText) findViewById(R.id.edtt_password);
        if(firebaseUser != null){ // check user session

            Intent i = new Intent(login.this,MainActivity.class);
            startActivity(i);
            finish();
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtt_email.getText().toString();
                password = edtt_password.getText().toString();
                if(email.isEmpty() || password.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }
                else{

                    /* mAuth.signOut(); çıkış*/
                    login();
                }
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(login.this, register.class);
               startActivity(intent);
               finish();
            }
        });

    }
    private void login() {

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent intent = new Intent(login.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
                else{

                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
