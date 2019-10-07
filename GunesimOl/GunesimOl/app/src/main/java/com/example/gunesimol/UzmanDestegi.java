package com.example.gunesimol;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UzmanDestegi extends AppCompatActivity {
    Button btn_gonder;
    EditText edtt_konu,edtt_icerik;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Uzman Desteği");
        setContentView(R.layout.uzmandestegi);
        btn_gonder=findViewById(R.id.btn_gonder);
        edtt_icerik=findViewById(R.id.edtt_mailIcerik);
        edtt_konu=findViewById(R.id.edtt_mailKonu);
        btn_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, edtt_konu.getText());
                emailIntent.putExtra(Intent.EXTRA_TEXT, edtt_icerik.getText());
                startActivity(Intent.createChooser(emailIntent, "E-mail Göndermek için Seçiniz:"));
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, "sanemm97@gmail.com");
                try{
                    startActivity(emailIntent);
                }
                catch (ActivityNotFoundException hata)
                {
                    Toast.makeText(getApplicationContext(),"Eposta gönderimi sırasında bir hata oluştu. \n"+hata.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
