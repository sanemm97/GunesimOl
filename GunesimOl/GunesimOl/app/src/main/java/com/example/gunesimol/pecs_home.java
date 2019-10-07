package com.example.gunesimol;

import android.content.ActivityNotFoundException;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

public class Pecs_home extends Fragment implements View.OnClickListener {
    ImageView imgV_yiyecekler,imgV_hayvanlar,imgV_eylemler,imgV_oyuncaklar,imgV_duygular,imgV_sayilar,imgV_cross;
    ImageView resim1,resim2,resim3,resim4,resim5;
    ImageView selectedImage;
    HorizontalScrollView grup1,grup2;
    MediaPlayer btnSes=new MediaPlayer();
    Button sesCal;
    int deger=0;
    ImageView imageview []= new ImageView[5];
    int [] yiyecek_grup=new int[5];
    int [] hayvan_grup=new int[5];
    int [] eylem_grup=new int[5];
    int [] oyuncak_grup=new int[5];
    int [] duygu_grup=new int[5];
    int [] sayi_grup=new int[5];
    int [] yiyecek_ses_grup=new int[5];
    int [] hayvan_ses_grup=new int[5];
    int [] eylem_ses_grup=new int[5];
    int [] oyuncak_ses_grup=new int[5];
    int [] duygu_ses_grup=new int[5];
    int [] sayi_ses_grup=new int[5];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.pecs_home,container,false);
        imgV_yiyecekler=view.findViewById(R.id.imgV_yiyecekler);
        imgV_hayvanlar=view.findViewById(R.id.imgV_hayvanlar);
        imgV_eylemler=view.findViewById(R.id.imgV_eylemler);
        imgV_oyuncaklar=view.findViewById(R.id.imgV_oyuncaklar);
        imgV_duygular=view.findViewById(R.id.imgV_duygular);
        imgV_sayilar=view.findViewById(R.id.imgV_sayilar);
        imgV_cross=view.findViewById(R.id.imgV_cross);
        sesCal=view.findViewById(R.id.btn_selectImage);
        selectedImage=view.findViewById(R.id.ımgV_selectedImage);
        resim1=view.findViewById(R.id.resim1);
        resim2=view.findViewById(R.id.resim2);
        resim3=view.findViewById(R.id.resim3);
        resim4=view.findViewById(R.id.resim4);
        resim5=view.findViewById(R.id.resim5);
        grup1=view.findViewById(R.id.grup1);
        grup2=view.findViewById(R.id.grup2);
        imgV_yiyecekler.setOnClickListener(this);
        imgV_hayvanlar.setOnClickListener(this);
        imgV_eylemler.setOnClickListener(this);
        imgV_oyuncaklar.setOnClickListener(this);
        imgV_duygular.setOnClickListener(this);
        imgV_sayilar.setOnClickListener(this);
        imgV_cross.setOnClickListener(this);
        resim1.setOnClickListener(this);
        resim2.setOnClickListener(this);
        resim3.setOnClickListener(this);
        resim4.setOnClickListener(this);
        resim5.setOnClickListener(this);
        imageview[0]=resim1;
        imageview[1]=resim2;
        imageview[2]=resim3;
        imageview[3]=resim4;
        imageview[4]=resim5;
        yiyecek_grup[0] =R.drawable.yiyecek1;
        yiyecek_grup[1]=R.drawable.yiyecek2;
        yiyecek_grup[2]=R.drawable.yiyecek3;
        yiyecek_grup[3]=R.drawable.yiyecek4;
        yiyecek_grup[4]=R.drawable.yiyecek5;
        hayvan_grup[0] =R.drawable.hayvan1;
        hayvan_grup[1] =R.drawable.hayvan2;
        hayvan_grup[2] =R.drawable.hayvan3;
        hayvan_grup[3] =R.drawable.hayvan4;
        hayvan_grup[4] =R.drawable.hayvan5;
        eylem_grup[0] =R.drawable.eylem1;
        eylem_grup[1] =R.drawable.eylem2;
        eylem_grup[2] =R.drawable.eylem3;
        eylem_grup[3] =R.drawable.eylem4;
        eylem_grup[4] =R.drawable.eylem5;
        oyuncak_grup[0]=R.drawable.oyuncak1;
        oyuncak_grup[1]=R.drawable.oyuncak2;
        oyuncak_grup[2]=R.drawable.oyuncak3;
        oyuncak_grup[3]=R.drawable.oyuncak4;
        oyuncak_grup[4]=R.drawable.oyuncak5;
        duygu_grup[0]=R.drawable.duygu1;
        duygu_grup[1]=R.drawable.duygu2;
        duygu_grup[2]=R.drawable.duygu3;
        duygu_grup[3]=R.drawable.duygu4;
        duygu_grup[4]=R.drawable.duygu5;
        sayi_grup[0]=R.drawable.sayi1;
        sayi_grup[1]=R.drawable.sayi2;
        sayi_grup[2]=R.drawable.sayi3;
        sayi_grup[3]=R.drawable.sayi4;
        sayi_grup[4]=R.drawable.sayi5;
        yiyecek_ses_grup[0] =R.raw.yiyecek1;
        yiyecek_ses_grup[1]=R.raw.yiyecek2;
        yiyecek_ses_grup[2]=R.raw.yiyecek3;
        yiyecek_ses_grup[3]=R.raw.yiyecek4;
        yiyecek_ses_grup[4]=R.raw.yiyecek5;
        hayvan_ses_grup[0] =R.raw.hayvan1;
        hayvan_ses_grup[1] =R.raw.hayvan2;
        hayvan_ses_grup[2] =R.raw.hayvan3;
        hayvan_ses_grup[3] =R.raw.hayvan4;
        hayvan_ses_grup[4] =R.raw.hayvan5;
        eylem_ses_grup[0] =R.raw.eylem1;
        eylem_ses_grup[1] =R.raw.eylem2;
        eylem_ses_grup[2] =R.raw.eylem3;
        eylem_ses_grup[3] =R.raw.eylem4;
        eylem_ses_grup[4] =R.raw.eylem5;
        oyuncak_ses_grup[0]=R.raw.oyuncak1;
        oyuncak_ses_grup[1]=R.raw.oyuncak2;
        oyuncak_ses_grup[2]=R.raw.oyuncak3;
        oyuncak_ses_grup[3]=R.raw.oyuncak4;
        oyuncak_ses_grup[4]=R.raw.oyuncak5;
        duygu_ses_grup[0]=R.raw.duygu1;
        duygu_ses_grup[1]=R.raw.duygu2;
        duygu_ses_grup[2]=R.raw.duygu3;
        duygu_ses_grup[3]=R.raw.duygu4;
        duygu_ses_grup[4]=R.raw.duygu5;
        sayi_ses_grup[0]=R.raw.sayi1;
        sayi_ses_grup[1]=R.raw.sayi2;
        sayi_ses_grup[2]=R.raw.sayi3;
        sayi_ses_grup[3]=R.raw.sayi4;
        sayi_ses_grup[4]=R.raw.sayi5;
        sesCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    btnSes.start();
                }
                catch (ActivityNotFoundException hata)
                {
                    Toast.makeText(getContext(),"Media oynatımı sırasında bir hata oluştu. \n"+hata.getMessage(),Toast.LENGTH_LONG).show();}

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgV_yiyecekler:
                resimler(yiyecek_grup);
                break;
            case R.id.imgV_hayvanlar:
                resimler(hayvan_grup);
                break;
            case R.id.imgV_eylemler:
                resimler(eylem_grup);
                break;
            case R.id.imgV_oyuncaklar:
                resimler(oyuncak_grup);
                break;
            case R.id.imgV_sayilar:
                resimler(sayi_grup);
                break;
            case R.id.imgV_duygular:
                resimler(duygu_grup);
                break;
            case  R.id.imgV_cross:
                grup2.setVisibility(View.INVISIBLE);
                imgV_cross.setVisibility(View.INVISIBLE);
                break;
            case R.id.resim1:
                if(deger==1)
                {
                    seciliResim(yiyecek_grup[0]);
                    btnSes = MediaPlayer.create(getContext(),yiyecek_ses_grup[0]);
                }
                else if(deger==2)
                {
                    seciliResim(hayvan_grup[0]);
                    btnSes = MediaPlayer.create(getContext(),hayvan_ses_grup[0]);
                }
                else if(deger==3)
                {
                    seciliResim(eylem_grup[0]);
                    btnSes = MediaPlayer.create(getContext(),eylem_ses_grup[0]);
                }else if(deger==4)
                {
                    seciliResim(oyuncak_grup[0]);
                    btnSes = MediaPlayer.create(getContext(),oyuncak_ses_grup[0]);
                }else if(deger==5)
                {
                    seciliResim(duygu_grup[0]);
                    btnSes = MediaPlayer.create(getContext(),duygu_ses_grup[0]);
                }
                else if(deger==6)
                {
                    seciliResim(sayi_grup[0]);
                    btnSes = MediaPlayer.create(getContext(),sayi_ses_grup[0]);
                }
                break;
            case R.id.resim2:
                if(deger==1)
                {
                    seciliResim(yiyecek_grup[1]);
                    btnSes = MediaPlayer.create(getContext(),yiyecek_ses_grup[1]);
                }
                else if(deger==2)
                {
                    seciliResim(hayvan_grup[1]);
                    btnSes = MediaPlayer.create(getContext(),hayvan_ses_grup[1]);
                }
                else if(deger==3)
                {
                    seciliResim(eylem_grup[1]);
                    btnSes = MediaPlayer.create(getContext(),eylem_ses_grup[1]);
                }else if(deger==4)
                {
                    seciliResim(oyuncak_grup[1]);
                    btnSes = MediaPlayer.create(getContext(),oyuncak_ses_grup[1]);
                }else if(deger==5)
                {
                    seciliResim(duygu_grup[1]);
                    btnSes = MediaPlayer.create(getContext(),duygu_ses_grup[1]);
                }
                else if(deger==6)
                {
                    seciliResim(sayi_grup[1]);
                    btnSes = MediaPlayer.create(getContext(),sayi_ses_grup[1]);
                }
                break;
            case R.id.resim3:
                if(deger==1)
                {
                    seciliResim(yiyecek_grup[2]);
                    btnSes = MediaPlayer.create(getContext(),yiyecek_ses_grup[2]);
                }
                else if(deger==2)
                {
                    seciliResim(hayvan_grup[2]);
                    btnSes = MediaPlayer.create(getContext(),hayvan_ses_grup[2]);
                }
                else if(deger==3)
                {
                    seciliResim(eylem_grup[2]);
                    btnSes = MediaPlayer.create(getContext(),eylem_ses_grup[2]);
                }else if(deger==4)
                {
                    seciliResim(oyuncak_grup[2]);
                    btnSes = MediaPlayer.create(getContext(),oyuncak_ses_grup[2]);
                }else if(deger==5)
                {
                    seciliResim(duygu_grup[2]);
                    btnSes = MediaPlayer.create(getContext(),duygu_ses_grup[2]);
                }
                else if(deger==6)
                {
                    seciliResim(sayi_grup[2]);
                    btnSes = MediaPlayer.create(getContext(),sayi_ses_grup[2]);
                }
                break;
            case R.id.resim4:
                if(deger==1)
                {
                    seciliResim(yiyecek_grup[3]);
                    btnSes = MediaPlayer.create(getContext(),yiyecek_ses_grup[3]);
                }
                else if(deger==2)
                {
                    seciliResim(hayvan_grup[3]);
                    btnSes = MediaPlayer.create(getContext(),hayvan_ses_grup[3]);
                }
                else if(deger==3)
                {
                    seciliResim(eylem_grup[3]);
                    btnSes = MediaPlayer.create(getContext(),eylem_ses_grup[3]);
                }else if(deger==4)
                {
                    seciliResim(oyuncak_grup[3]);
                    btnSes = MediaPlayer.create(getContext(),oyuncak_ses_grup[3]);
                }else if(deger==5)
                {
                    seciliResim(duygu_grup[3]);
                    btnSes = MediaPlayer.create(getContext(),duygu_ses_grup[3]);
                }
                else if(deger==6)
                {
                    seciliResim(sayi_grup[3]);
                    btnSes = MediaPlayer.create(getContext(),sayi_ses_grup[3]);
                }
                break;
            case R.id.resim5:
                if(deger==1)
                {
                    seciliResim(yiyecek_grup[4]);
                    btnSes = MediaPlayer.create(getContext(),yiyecek_ses_grup[4]);
                }
                else if(deger==2)
                {
                    seciliResim(hayvan_grup[4]);
                    btnSes = MediaPlayer.create(getContext(),hayvan_ses_grup[4]);
                }
                else if(deger==3)
                {
                    seciliResim(eylem_grup[4]);
                    btnSes = MediaPlayer.create(getContext(),eylem_ses_grup[4]);
                }else if(deger==4)
                {
                    seciliResim(oyuncak_grup[4]);
                    btnSes = MediaPlayer.create(getContext(),oyuncak_ses_grup[4]);
                }else if(deger==5)
                {
                    seciliResim(duygu_grup[4]);
                    btnSes = MediaPlayer.create(getContext(),duygu_ses_grup[4]);
                }
                else if(deger==6)
                {
                    seciliResim(sayi_grup[4]);
                    btnSes = MediaPlayer.create(getContext(),sayi_ses_grup[4]);
                }
                break;

        }

    }

    private void resimler(int[] dizi) {

        for(int i=0;i<=4;i++)
        {
            imageview[i].setImageResource(dizi[i]);
        }
        grup2.setVisibility(View.VISIBLE);
        imgV_cross.setVisibility(View.VISIBLE);
        if(dizi==yiyecek_grup) {
            deger=1;
        }
        else if(dizi==hayvan_grup) {
            deger=2;
        }
        else if(dizi==eylem_grup) {
            deger=3;
        }
        else if(dizi==oyuncak_grup) {
            deger=4;
        }

        else if(dizi==duygu_grup) {
            deger=5;
        }
        else if(dizi==sayi_grup) {
            deger=6;
        }
    }
    private void seciliResim(int resim) {

        grup2.setVisibility(View.INVISIBLE);
        imgV_cross.setVisibility(View.INVISIBLE);
        selectedImage.setImageResource(resim);

    }
}
