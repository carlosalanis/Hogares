package org.lavid.hogares;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import java.util.Calendar;
import java.util.Date;

public class oracionesMenu extends AppCompatActivity {

    CardView cardOCR1; CardView cardOCR2; CardView cardOCR3; CardView cardOCR4; CardView cardOCR5;
    CardView cardOCR9; CardView cardOCR10; CardView cardOCR11; CardView cardOCR12; CardView cardOCR13;
    CardView cardOCR14; CardView cardOCR15; CardView cardOCR16; CardView cardOCR17; CardView cardOCR18;
    CardView cardOCR19; CardView cardOCR20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oraciones_menu);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

/*
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

        cardOCR3 = findViewById(R.id. card_view3);
        cardOCR3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_abraham_ismael.html");
                startActivity(mainIntent);
            }
        });

        cardOCR4 = findViewById(R.id. card_view4);
        cardOCR4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_isaac.html");
                startActivity(mainIntent);
            }
        });

        cardOCR5 = findViewById(R.id. card_view5);
        cardOCR5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_jacob.html");
                startActivity(mainIntent);
            }
        });
*/
        cardOCR9 = findViewById(R.id. card_view9);
        cardOCR9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_sanson.html");
                startActivity(mainIntent);
            }
        });

        cardOCR10 = findViewById(R.id. card_view10); // week 34
        cardOCR10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_eliseo.html");
                startActivity(mainIntent);
            }
        });


        cardOCR11 = findViewById(R.id.card_view11); // week 35
        cardOCR11.setVisibility(View.GONE);
        if(week>=35) {
            cardOCR11.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                    mainIntent.putExtra("cap", "oracion_jabes.html");
                    startActivity(mainIntent);
                }
            });
            cardOCR11.setVisibility(View.VISIBLE);
        }


        cardOCR12 = findViewById(R.id.card_view12); // week 36
        cardOCR12.setVisibility(View.GONE);
        if(week>=36) {
            cardOCR12.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                    mainIntent.putExtra("cap", "oracion_pedro.html");
                    startActivity(mainIntent);
                }
            });
            cardOCR12.setVisibility(View.VISIBLE);
        }


        cardOCR13 = findViewById(R.id.card_view13);
        cardOCR13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                    mainIntent.putExtra("cap", "oracion_creyentes.html");
                    startActivity(mainIntent);
                }
            });

        cardOCR14 = findViewById(R.id. card_view14);
        cardOCR14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_pablo.html");
                startActivity(mainIntent);
            }
        });


        cardOCR15 = findViewById(R.id. card_view15);
        cardOCR15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_pablo_publio.html");
                startActivity(mainIntent);
            }
        });


        cardOCR16 = findViewById(R.id. card_view16);
        cardOCR16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_cornelio.html");
                startActivity(mainIntent);
            }
        });

        cardOCR17 = findViewById(R.id. card_view17);
        cardOCR17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_esteban.html");
                startActivity(mainIntent);
            }
        });

        cardOCR18 = findViewById(R.id. card_view18);
        cardOCR18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                mainIntent.putExtra("cap", "oracion_pablo_protec.html");
                startActivity(mainIntent);
            }
        });

        cardOCR19 = findViewById(R.id. card_view19);
        cardOCR19.setVisibility(View.GONE);
        if(week>=43) {
            cardOCR19.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                    mainIntent.putExtra("cap", "oracion_publicano.html");
                    startActivity(mainIntent);
                }
            });
            cardOCR19.setVisibility(View.VISIBLE);
        }

        cardOCR20 = findViewById(R.id. card_view20);
        cardOCR20.setVisibility(View.GONE);
        if(week>=44) {
            cardOCR20.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent mainIntent = new Intent(getApplicationContext(), chapters.class);
                    mainIntent.putExtra("cap", "oracion_dosciegos.html");
                    startActivity(mainIntent);
                }
            });
            cardOCR20.setVisibility(View.VISIBLE);
        }

    }
}
