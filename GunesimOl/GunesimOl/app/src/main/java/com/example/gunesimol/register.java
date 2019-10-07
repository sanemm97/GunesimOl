package com.example.gunesimol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    private Button btn_save;
    private EditText edtt_register_email, edtt_register_password;
    private FirebaseAuth mAuth;
    private String email, password;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Kayıt Ol");
        setContentView(R.layout.register);
        edtt_register_email = (EditText)findViewById(R.id.edtt_register_email);
        edtt_register_password = (EditText)findViewById(R.id.edtt_register_password);
        btn_save = (Button) findViewById(R.id.btn_save);
        mAuth = FirebaseAuth.getInstance();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = edtt_register_email.getText().toString();
                password = edtt_register_password.getText().toString();
                if(email.isEmpty() || password.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Tüm alanları doldurunuz!",Toast.LENGTH_SHORT).show();

                }else{

                    register();
                }
            }
        });
    }
    private void register() {

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent i = new Intent(Register.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
