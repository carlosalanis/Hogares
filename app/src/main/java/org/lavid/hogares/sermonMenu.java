package org.lavid.hogares;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import java.util.Calendar;
import java.util.Date;

public class sermonMenu extends AppCompatActivity {

    CardView cardSermon1; CardView cardSermon2; CardView cardSermon3;
    CardView cardSermon4; CardView cardSermon5; CardView cardSermon6;
    CardView cardSermon7; CardView cardSermon8; CardView cardSermon9;
    CardView cardSermon10; CardView cardSermon11; CardView cardSermon12;
    CardView cardSermon13; CardView cardSermon14; CardView cardSermon15;
    CardView cardSermon16; CardView cardSermon17; CardView cardSermon18;
    RelativeLayout cardLayout10; RelativeLayout cardLayout11;
    RelativeLayout cardLayout12; RelativeLayout cardLayout13;
    RelativeLayout cardLayout14; RelativeLayout cardLayout15;
    RelativeLayout cardLayout16; RelativeLayout cardLayout17;
    RelativeLayout cardLayout18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sermon_menu);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(calendar.WEEK_OF_YEAR);


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


        cardSermon9 = findViewById(R.id.card_view9);
        cardSermon9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "lasal.html");
                startActivity(mainIntent);
            }
        });

        cardSermon10 = findViewById(R.id.card_view10);
        cardSermon10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "laconsumacion.html");
                startActivity(mainIntent);
            }
        });
        cardSermon10.setVisibility(View.GONE);
        cardLayout10 = findViewById(R.id.cardLayout10);

        cardSermon11 = findViewById(R.id.card_view11);
        cardSermon11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "laira.html");
                startActivity(mainIntent);
            }
        });
        cardSermon11.setVisibility(View.GONE);
        cardLayout11 = findViewById(R.id.cardLayout11);

        cardSermon12 = findViewById(R.id.card_view12);
        cardSermon12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "eladulterio.html");
                startActivity(mainIntent);
            }
        });
        cardSermon12.setVisibility(View.GONE);
        cardLayout12 = findViewById(R.id.cardLayout12);

        cardSermon13 = findViewById(R.id.card_view13);
        cardSermon13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "unavida.html");
                startActivity(mainIntent);
            }
        });
        cardSermon13.setVisibility(View.GONE);
        cardLayout13 = findViewById(R.id.cardLayout13);

        cardSermon14 = findViewById(R.id.card_view14);
        cardSermon14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "lavenganza.html");
                startActivity(mainIntent);
            }
        });
        cardSermon14.setVisibility(View.GONE);
        cardLayout14 = findViewById(R.id.cardLayout14);

        cardSermon15 = findViewById(R.id.card_view15);
        cardSermon15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "enemigos.html");
                startActivity(mainIntent);
            }
        });
        cardSermon15.setVisibility(View.GONE);
        cardLayout15 = findViewById(R.id.cardLayout15);

        cardSermon16 = findViewById(R.id.card_view16);
        cardSermon16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "hipocresia.html");
                startActivity(mainIntent);
            }
        });
        cardSermon16.setVisibility(View.GONE);
        cardLayout16 = findViewById(R.id.cardLayout16);

        cardSermon17 = findViewById(R.id.card_view17);
        cardSermon17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "comodar.html");
                startActivity(mainIntent);
            }
        });
        cardSermon17.setVisibility(View.GONE);
        cardLayout17 = findViewById(R.id.cardLayout17);

        cardSermon18 = findViewById(R.id.card_view18);
        cardSermon18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "comoorar.html");
                startActivity(mainIntent);
            }
        });
        cardSermon18.setVisibility(View.GONE);
        cardLayout18 = findViewById(R.id.cardLayout18);

        switch (week) {
            case 2:
                cardSermon10.setVisibility(View.VISIBLE);
                cardLayout10.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 3:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardLayout11.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 4:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardLayout12.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 5:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardLayout13.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 6:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardSermon14.setVisibility(View.VISIBLE);
                cardLayout14.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 7:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardSermon14.setVisibility(View.VISIBLE);
                cardSermon15.setVisibility(View.VISIBLE);
                cardLayout15.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 8:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardSermon14.setVisibility(View.VISIBLE);
                cardSermon15.setVisibility(View.VISIBLE);
                cardSermon16.setVisibility(View.VISIBLE);
                cardLayout16.setBackgroundColor(Color.parseColor("#F5843F"));
                break;

            case 9:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardSermon14.setVisibility(View.VISIBLE);
                cardSermon15.setVisibility(View.VISIBLE);
                cardSermon16.setVisibility(View.VISIBLE);
                cardSermon17.setVisibility(View.VISIBLE);
                cardLayout17.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
            case 10:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardSermon14.setVisibility(View.VISIBLE);
                cardSermon15.setVisibility(View.VISIBLE);
                cardSermon16.setVisibility(View.VISIBLE);
                cardSermon17.setVisibility(View.VISIBLE);
                cardSermon18.setVisibility(View.VISIBLE);
                cardLayout18.setBackgroundColor(Color.parseColor("#F5843F"));
                break;

            default:
                cardSermon10.setVisibility(View.VISIBLE);
                cardSermon11.setVisibility(View.VISIBLE);
                cardSermon12.setVisibility(View.VISIBLE);
                cardSermon13.setVisibility(View.VISIBLE);
                cardSermon14.setVisibility(View.VISIBLE);
                cardSermon15.setVisibility(View.VISIBLE);
                cardSermon16.setVisibility(View.VISIBLE);
                cardSermon17.setVisibility(View.VISIBLE);
                cardSermon18.setVisibility(View.VISIBLE);
                cardLayout18.setBackgroundColor(Color.parseColor("#F5843F"));
                break;
        }

    }
}
