package com.example.gunesimol;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

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
    String story_tittle, story_giris,story_gelisme, story_sonuc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        /*   veri_gonder.putExtra("image",filePath);
                    veri_gonder.putExtra("tittle", tittle);
                    veri_gonder.putExtra("giris",giris);
                    veri_gonder.putExtra("gelisme",gelisme);
                    veri_gonder.putExtra("sonuc",sonuc);*/

        /*Bundle veri_al = getIntent().getExtras();*/

        /*story_tittle = veri_al.getString("tittle");
        story_giris=veri_al.getString("giris");
        story_gelisme=veri_al.getString("gelisme");
        story_sonuc=veri_al.getString("sonuc");
        filePath=getIntent().getData();*/
        socialstorySave=findViewById(R.id.btn_socialstory_save);
        socialstorySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(s1.isChecked() && s2.isChecked()&& s3.isChecked() && s4.isChecked() && s5.isChecked() && s6.isChecked() && s7.isChecked() && s8.isChecked())
                {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    final String userid = user.getUid();
                    DatabaseReference databaseReferenceStories= FirebaseDatabase.getInstance().getReference("socialstories").child(userid);
                    storyid = databaseReferenceStories.push().getKey();
                    Date date=new Date();
                    SimpleDateFormat today=new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat time=new SimpleDateFormat("HH:mm");
                    stories stories=new stories(storyid,story_tittle,story_giris,story_gelisme,story_sonuc,today.format(date),time.format(date));
                    databaseReferenceStories.child(storyid).setValue(stories).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            fStorage = FirebaseStorage.getInstance();
                            StorageReference storageRef = fStorage.getReference().child("storyPhotos").child(userid).child(MainActivity.storyid);
                            storageRef.putFile(filePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                    Toast.makeText(getBaseContext(),"Sosyal öykünüz başarılı bir şekilde kayıt edilmişir.",Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getBaseContext(),"Sosyal öykünüz kaydedilmedi",Toast.LENGTH_LONG).show();
                                }
                            });
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
                   // MyListener listener= (MyListener) getActivity();
                   // listener.saveStory(false);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("resim");

        Bitmap bitMap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        resimm.setImageBitmap(bitMap);
    }
}
