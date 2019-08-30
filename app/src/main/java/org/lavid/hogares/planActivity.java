package org.lavid.hogares;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class planActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter planAdapter;
    private RecyclerView.LayoutManager layoutManager;
    String[] planDataset;
    DatabaseHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Lecturas para hoy");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = findViewById(R.id.citasRView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Extract data
        dbHelper = new DatabaseHelper(this);
        planDataset = dbHelper.getCitas();

        // Get actual date
        SimpleDateFormat formateadorfecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("MX"));
        SimpleDateFormat formateadordia = new SimpleDateFormat("EEEE", new Locale("MX"));
        Date fechaDate = new Date();

        String fecha = formateadorfecha.format(fechaDate);
        String dia = formateadordia.format(fechaDate);

        // Set controls
        TextView txtDia = findViewById(R.id.txtDia);
        TextView txtFecha = findViewById(R.id.txtFecha);
        txtFecha.setText(fecha);
        txtDia.setText(dia);

        recyclerView.setAdapter(new planAdapter(planDataset));


    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}
