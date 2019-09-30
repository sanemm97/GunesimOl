package com.example.gunesimol;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

public class NewSocialStory extends AppCompatActivity {
    Button btn_next,btn_SocialPictureLoad;
    EditText edtt_social_tittle,edtt_social_giris,edtt_social_gelisme,edtt_social_sonuc;
    String tittle, giris, gelisme, sonuc;
    TextView image;
    ImageView story_image;
    private static final int PICK_IMAGE_REQUEST = 123;
    private Uri filePath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Picasso.get().load(filePath).fit().centerCrop().into(story_image);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsocialstory);
        btn_next=findViewById(R.id.btn_social_next);
        image=findViewById(R.id.image);
        edtt_social_tittle=findViewById(R.id.edtt_social_tittle);
        edtt_social_giris=findViewById(R.id.edtt_social_giris);
        edtt_social_gelisme=findViewById(R.id.edtt_social_gelisme);
        edtt_social_sonuc=findViewById(R.id.edtt_social_sonuc);
        story_image=findViewById(R.id.story_image);
        btn_SocialPictureLoad=findViewById(R.id.btn_SocialPictureLoad);
        final Intent veri_gonder = new Intent(this, MainActivity.class);
        btn_SocialPictureLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Resim Seçiniz"), PICK_IMAGE_REQUEST);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tittle=edtt_social_tittle.getText().toString();
                giris=edtt_social_giris.getText().toString();
                gelisme=edtt_social_gelisme.getText().toString();
                sonuc=edtt_social_sonuc.getText().toString();
                //tittle.isEmpty() || giris.isEmpty() || gelisme.isEmpty() || sonuc.isEmpty() || filePath==null
                if(filePath==null)
                {
                    Toast.makeText(getBaseContext(), "Lütfen zorunlu alanları doldurunuz", Toast.LENGTH_LONG).show();
                }
                else
                {

                    Bitmap bmp =  ((BitmapDrawable) story_image.getDrawable()).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byte[] byteArray = stream.toByteArray();
                    Intent intent = new Intent(getApplicationContext(), SocialStoryForm.class);
                    intent.putExtra("resim", byteArray);
                    startActivity(intent);
                   // Intent intent = new Intent(getApplicationContext(), SocialStoryForm.class);

//passes the file path string with the intent
                 //   intent.putExtra("path", filePath);

                  //  startActivity(intent);



                    /* Tüm alanlar doldurulduysa verileri daha sonra geri dönüldüğünde kullanılmak
                     üzere açılacak bir sonraki Activty'e gönderiyoruz */

                    /*listener.saveDataStory(tittle,giris,gelisme,sonuc,filePath);
                    veri_gonder.putExtra("image",filePath);
                    veri_gonder.putExtra("tittle", tittle);
                    veri_gonder.putExtra("giris",giris);
                    veri_gonder.putExtra("gelisme",gelisme);
                    veri_gonder.putExtra("sonuc",sonuc);
                    startActivity(veri_gonder);*/
                }
            }
        });
    }
}
