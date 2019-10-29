package com.gykotizm.gunesimol;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gykotizm.gunesimol.R;

public class NewSocialStory extends AppCompatActivity {


    Button btn_next;
    EditText edtt_social_tittle,edtt_social_giris,edtt_social_gelisme,edtt_social_sonuc,edtt_social_target;
    String tittle, giris, gelisme, sonuc,hedef;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Yeni Sosyal Öykü");
        setContentView(R.layout.newsocialstory);
        btn_next=findViewById(R.id.btn_social_next);
        edtt_social_tittle=findViewById(R.id.edtt_social_tittle);
        edtt_social_giris=findViewById(R.id.edtt_social_giris);
        edtt_social_gelisme=findViewById(R.id.edtt_social_gelisme);
        edtt_social_sonuc=findViewById(R.id.edtt_social_sonuc);
        edtt_social_target=findViewById(R.id.edtt_social_target);

        final Intent veri_gonder = new Intent(this, SocialStoryForm.class);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tittle=edtt_social_tittle.getText().toString();
                giris=edtt_social_giris.getText().toString();
                gelisme=edtt_social_gelisme.getText().toString();
                sonuc=edtt_social_sonuc.getText().toString();
                hedef=edtt_social_target.getText().toString();
                if(tittle.isEmpty() || giris.isEmpty() || gelisme.isEmpty() || sonuc.isEmpty() ||  hedef.isEmpty())
                {
                    Toast.makeText(getBaseContext(), "Lütfen zorunlu alanları doldurunuz", Toast.LENGTH_LONG).show();
                }
                else
                {

                    veri_gonder.putExtra("tittle", tittle);
                    veri_gonder.putExtra("giris",giris);
                    veri_gonder.putExtra("gelisme",gelisme);
                    veri_gonder.putExtra("sonuc",sonuc);
                    veri_gonder.putExtra("hedef",hedef);
                    startActivity(veri_gonder);
                }

            }
        });
    }
}


