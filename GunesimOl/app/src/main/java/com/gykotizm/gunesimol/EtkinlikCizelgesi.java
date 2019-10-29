package com.gykotizm.gunesimol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EtkinlikCizelgesi extends Fragment {
    int [] beceri=new int[9];
    int [] yazi=new int[9];
    Button beceri_buton;
    TextView beceri_yazi;
    ImageView beceri_resim;
    int sayac=1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.etkinlikcizelgesi,container,false);
        beceri[0] =R.drawable.beceri1;
        beceri[1] =R.drawable.beceri2;
        beceri[2] =R.drawable.beceri3;
        beceri[3] =R.drawable.beceri4;
        beceri[4] =R.drawable.beceri5;
        beceri[5] =R.drawable.beceri6;
        beceri[6] =R.drawable.beceri7;
        beceri[7] =R.drawable.beceri8;
        beceri[8] =R.drawable.beceri9;
        yazi[0]=R.string.cizelge1;
        yazi[1]=R.string.cizelge2;
        yazi[2]=R.string.cizelge3;
        yazi[3]=R.string.cizelge4;
        yazi[4]=R.string.cizelge5;
        yazi[5]=R.string.cizelge6;
        yazi[6]=R.string.cizelge7;
        yazi[7]=R.string.cizelge8;
        yazi[8]=R.string.cizelge9;

        beceri_resim=view.findViewById(R.id.beceri_resim);
        beceri_buton=view.findViewById(R.id.beceri_ileri);
        beceri_yazi=view.findViewById(R.id.beceri_yazi);
        beceri_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sayac<9)
                {
                    beceri_resim.setImageResource(beceri[sayac]);
                    beceri_yazi.setText(yazi[sayac]);
                    sayac++;
                    if(sayac==9)
                    {
                        sayac=0;
                    }

                }

            }
        });
        return view;

    }
}
