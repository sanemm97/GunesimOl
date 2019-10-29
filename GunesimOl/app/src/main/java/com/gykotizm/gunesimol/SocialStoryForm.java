package com.gykotizm.gunesimol;


import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.gykotizm.gunesimol.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SocialStoryForm extends AppCompatActivity {
    RadioButton s1,s2,s3,s4,s5,s6,s7,s8;
    Button socialstorySave;
    static String storyid;
    FragmentManager manager;
    private FirebaseStorage fStorage;
    private Uri filePath;
    ImageView resimm;
    String story_tittle, story_giris,story_gelisme, story_sonuc,story_hedef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Yeni Sosyal Öykü");
        resimm=findViewById(R.id.resimm);
        setContentView(R.layout.socialstory_form);
        s1=findViewById(R.id.socialstory_q1);
        s2=findViewById(R.id.socialstory_q2);
        s3=findViewById(R.id.socialstory_q3);
        s4=findViewById(R.id.socialstory_q4);
        s5=findViewById(R.id.socialstory_q5);
        s6=findViewById(R.id.socialstory_q6);
        s7=findViewById(R.id.socialstory_q7);
        s8=findViewById(R.id.socialstory_q8);
        Bundle veri_al = getIntent().getExtras();
        story_tittle = veri_al.getString("tittle");
        story_giris=veri_al.getString("giris");
        story_gelisme=veri_al.getString("gelisme");
        story_sonuc=veri_al.getString("sonuc");
        story_hedef=veri_al.getString("hedef");
        socialstorySave=findViewById(R.id.btn_socialstory_save);
        socialstorySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s1.isChecked() && s2.isChecked()&& s3.isChecked() && s4.isChecked() && s5.isChecked() && s6.isChecked() && s7.isChecked() && s8.isChecked())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    final String userid = user.getUid();
                    DatabaseReference databaseReferenceStories= FirebaseDatabase.getInstance().getReference("socialstories").child(userid);
                    storyid =databaseReferenceStories.push().getKey();
                    Date date=new Date();
                    SimpleDateFormat today=new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat time=new SimpleDateFormat("HH:mm");
                    Stories stories=new Stories(storyid,story_tittle,story_giris,story_gelisme,story_sonuc,story_hedef,today.format(date),time.format(date));
                    databaseReferenceStories.child(storyid).setValue(stories).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getBaseContext(),"Sosyal öykünüz başarılı bir şekilde kaydedildi.",Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getBaseContext(),"Sosyal öykünüz kaydedilmedi",Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SocialStoryForm.this);
                    builder.setTitle("Uyarı");
                    builder.setMessage("Lütfen sosyal öykünüzü yukarıda belirtilen maddelere göre yeniden düzenleyiniz.");
                    builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SocialStoryForm.super.onBackPressed();
                        }
                    });
                    builder.show();
                }
            }

        });
    }
}
