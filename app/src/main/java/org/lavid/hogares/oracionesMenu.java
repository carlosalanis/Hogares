package org.lavid.hogares;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class oracionesMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oraciones_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<String> list = new ArrayList<>();
        list.add("24/NAVIDAD/ADMIRABLE CONSEJERO/clave24");
        list.add("23/JESUS/POR TI Y POR MI/clave23");
        list.add("22/JESUS/POR PERDÓN DE LOS HOMBRES/clave22");
        list.add("21/JESUS/POR LA VOLUNTAD DEL PADRE/clave21");
        list.add("20/DOS CIEGOS/POR VISTA/clave20");
        list.add("19/EL PUBLICANO/POR JUSTIFICACIÓN/clave19");
        list.add("18/PABLO/POR PROTECCIÓN EN LA TEMPESTAD/clave18");
        list.add("17/ESTEBAN/POR SU MUERTE/clave17");
        list.add("16/CORNELIO/POR GUÍA/clave16");
        list.add("15/PABLO/POR LA SALUD DEL PADRE DE PUBLIO/clave15");
        list.add("14/PABLO/POR EL AGUIJÓN EN LA CARNE/clave14");
        list.add("13/CREYENTES/POR LA SEGURIDAD DE PEDRO/clave13");
        list.add("12/PEDRO/POR LA RESURRECCIÓN DE DORCAS (TABITA)/clave12");
        list.add("11/JABES/POR BENDICIÓN/clave11");
        list.add("10/ELISEO/POR VISIÓN, CEGUERA Y VISTA/clave10");
        list.add("9/SANSÓN/POR FUERZA/clave9");


        String[] estudiosDataset = new String[list.size()];
        list.toArray(estudiosDataset);

        recyclerView = findViewById(R.id.oracionesRView);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new oracionesAdapter(estudiosDataset);
        recyclerView.setAdapter(mAdapter);

    }

}
