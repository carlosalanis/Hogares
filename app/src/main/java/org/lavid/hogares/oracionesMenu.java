package org.lavid.hogares;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Calendar;
import java.util.Date;

public class oracionesMenu extends AppCompatActivity {

    CardView cardOCR1; CardView cardOCR2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oraciones_menu);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(calendar.WEEK_OF_YEAR);


        cardOCR1 = findViewById(R.id. card_view1);
        cardOCR1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_comunicacion.html");
                startActivity(mainIntent);
            }
        });

        cardOCR2 = findViewById(R.id. card_view2);
        cardOCR2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_comunicacion2.html");
                startActivity(mainIntent);
            }
        });


    }
}
