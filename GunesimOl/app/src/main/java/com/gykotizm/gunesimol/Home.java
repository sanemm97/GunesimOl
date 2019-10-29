package com.gykotizm.gunesimol;



import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gykotizm.gunesimol.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.NumberFormat;

public class Home extends Fragment {
    Button  btn_otizm,btn_oturumuKapat;
    TextView sosyaloykusayisi;
    int sayac=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home,container,false);
        btn_otizm=view.findViewById(R.id.btn_otizm);
        btn_oturumuKapat=view.findViewById(R.id.btn_signOut);
        sosyaloykusayisi=view.findViewById(R.id.sosyaloyku_sayisi);
        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(3);
        nf.setMinimumIntegerDigits(2);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(nf, nf));
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return super.formatLabel(value, isValueX)+ ".gün";
                } else {
                    // show currency for y values
                    return super.formatLabel(value, isValueX) ;
                }
            }
        });
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>
                (new DataPoint[] {
                        new DataPoint(0, 11),
                        new DataPoint(1, 5),
                        new DataPoint(2, 3),
                        new DataPoint(3, 2),
                        new DataPoint(4, 6)
                });

        graph.addSeries(series);
        series.setTitle("Kayıt Grafiği");
        series.setColor(Color.BLUE);
        series.setDrawBackground(true);
        series.getBackgroundColor();
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);
        btn_oturumuKapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();

            }
        });
        btn_otizm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otizmNedir();

            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("socialstories").child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    sayac=sayac+1;
                }
                sosyaloykusayisi.setText(" "+String.valueOf(sayac));
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        return view;
    }


    private void otizmNedir() {
        MyListener listener= (MyListener) getActivity();
        listener.otizmNedir();
    }

    private void signOut() {
        MyListener listener= (MyListener) getActivity();
        listener.signOut();
    }

}
