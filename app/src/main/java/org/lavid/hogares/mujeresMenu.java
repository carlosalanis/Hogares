package org.lavid.hogares;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class mujeresMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ImageView imgMujeres; int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujeres_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        // Get from the SharedPreferences
        SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
        boolean isAdmin = settings.getBoolean("isAdmin", false);

        imgMujeres = findViewById(R.id.imgMDLB);
        imgMujeres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter++;
                if((counter == 10) && !isAdmin) {
                    SharedPreferences settings = getApplicationContext().getSharedPreferences("HOGARES_PREFS", 0);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putBoolean("isAdmin", true);
                    editor.apply();

                    Toast.makeText(mujeresMenu.this, "Listo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayList<String> list = new ArrayList<>();
        list.add("1/EVA/MADRE DE TODOS LOS VIVIENTES/vida eterna");

        if(week>=3 || isAdmin) list.add(0,"2/SARA/HEROÍNA DE LA FE/promesa cumplida");
        if(week>=4 || isAdmin) list.add(0,"3/REBECA/MATRIARCA DEL PUEBLO DE DIOS/pueblo escogido");
        if(week>=5 || isAdmin) list.add(0,"4/LEA Y RAQUEL/EDIFICARON LA CASA DE ISRAEL/servicio");
        if(week>=6 || isAdmin) list.add(0,"5/RAHAB/UNA VIDA REDIMIDA/generosidad");
        if(week>=7 || isAdmin) list.add(0,"6/DÉBORA/LA MADRE Y JUEZ DE ISRAEL/alabanza");

        String[] estudiosDataset = new String[list.size()];
        list.toArray(estudiosDataset);

        recyclerView = findViewById(R.id.mujeresRView);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new mujeresAdapter(estudiosDataset);
        recyclerView.setAdapter(mAdapter);

    }

}
