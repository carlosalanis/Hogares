package org.lavid.hogares;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

public class sermonMenu extends AppCompatActivity {

    CardView cardSermon1; CardView cardSermon2; CardView cardSermon3;
    CardView cardSermon4; CardView cardSermon5; CardView cardSermon6;
    CardView cardSermon7;  CardView cardSermon8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sermon_menu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cardSermon1 = findViewById(R.id.card_view);
        cardSermon1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "lospobres.html");
                startActivity(mainIntent);
            }
        });

        cardSermon2 = findViewById(R.id.card_view2);
        cardSermon2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "losquelloran.html");
                startActivity(mainIntent);
            }
        });

        cardSermon3 = findViewById(R.id.card_view3);
        cardSermon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "loshumildes.html");
                startActivity(mainIntent);
            }
        });

        cardSermon4 = findViewById(R.id.card_view4);
        cardSermon4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "losquetienenhambre.html");
                startActivity(mainIntent);
            }
        });

        cardSermon5 = findViewById(R.id.card_view5);
        cardSermon5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "losmisericordiosos.html");
                startActivity(mainIntent);
            }
        });

        cardSermon6 = findViewById(R.id.card_view6);
        cardSermon6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "losdelimpio.html");
                startActivity(mainIntent);
            }
        });

        cardSermon7 = findViewById(R.id.card_view7);
        cardSermon7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "losqueprocuran.html");
                startActivity(mainIntent);
            }
        });

        cardSermon8 = findViewById(R.id.card_view8);
        cardSermon8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "losperseguidos.html");
                startActivity(mainIntent);
            }
        });

    }
}
